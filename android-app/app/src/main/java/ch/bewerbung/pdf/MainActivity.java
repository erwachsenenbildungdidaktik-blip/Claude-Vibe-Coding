// Copyright (c) 2026 Hugo Rohrbacher. Alle Rechte vorbehalten.
package ch.bewerbung.pdf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.window.OnBackInvokedDispatcher;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/** Hülle um die Web-App in assets/: alles läuft lokal, ohne Internet. */
public class MainActivity extends Activity {
    private static final int REQ_IMAGE = 1, REQ_SAVE = 2;
    private static final String START = "file:///android_asset/index.html";

    private WebView web;
    private ValueCallback<Uri[]> fileCallback;
    private File cameraFile;
    private Uri cameraUri;
    private byte[] pendingSave;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        web = new WebView(this);
        // Ab Android 15 zeichnet die App bis unter Statusleiste und Tastatur:
        // Abstände selbst setzen, der blaue Rand füllt den Platz hinter der Statusleiste.
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#1f5f8b"));
        root.addView(web);
        setContentView(root);
        if (Build.VERSION.SDK_INT >= 30) {
            root.setOnApplyWindowInsetsListener((v, in) -> {
                Insets bars = in.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
                Insets ime = in.getInsets(WindowInsets.Type.ime());
                v.setPadding(bars.left, bars.top, bars.right, Math.max(bars.bottom, ime.bottom));
                return WindowInsets.CONSUMED;
            });
        }

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);      // localStorage: Angaben bleiben gespeichert
        s.setTextZoom(100);
        web.addJavascriptInterface(new Bridge(), "AndroidApp");

        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r) {
                Uri u = r.getUrl();
                if (u.toString().startsWith("file:///android_asset/")) return false;
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (ActivityNotFoundException ignored) { }
                return true;
            }
        });

        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView v, ValueCallback<Uri[]> cb, FileChooserParams p) {
                if (fileCallback != null) fileCallback.onReceiveValue(null);
                fileCallback = cb;
                return openImageChooser();
            }

            @Override
            public boolean onJsAlert(WebView v, String url, String msg, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(msg)
                        .setPositiveButton("OK", (d, w) -> result.confirm())
                        .setOnCancelListener(d -> result.confirm())
                        .show();
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView v, String url, String msg, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(msg)
                        .setPositiveButton("Ja", (d, w) -> result.confirm())
                        .setNegativeButton("Abbrechen", (d, w) -> result.cancel())
                        .setOnCancelListener(d -> result.cancel())
                        .show();
                return true;
            }
        });

        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT, this::goBack);
        }

        if (state != null) web.restoreState(state);
        else web.loadUrl(START);
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBackPressed() {   // bis Android 12
        goBack();
    }

    /** Zurück-Taste = einen Schritt zurück; auf Schritt 1 wird die App geschlossen. */
    private void goBack() {
        web.evaluateJavascript("window.appBack ? window.appBack() : false", v -> {
            if (!"true".equals(v)) finish();
        });
    }

    private File shareDir() {
        File d = new File(getCacheDir(), "share");
        d.mkdirs();
        return d;
    }

    private Uri uriFor(File f) {
        return FileProvider.getUriForFile(this, getPackageName() + ".files", f);
    }

    /** Galerie / Dateien, dazu die Kamera als zusätzliche Auswahl. */
    private boolean openImageChooser() {
        Intent pick = new Intent(Intent.ACTION_GET_CONTENT);
        pick.addCategory(Intent.CATEGORY_OPENABLE);
        pick.setType("image/*");

        cameraFile = new File(shareDir(), "unterschrift-foto.jpg");
        cameraFile.delete();
        cameraUri = uriFor(cameraFile);
        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cam.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        cam.setClipData(ClipData.newRawUri("", cameraUri));
        cam.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Intent chooser = Intent.createChooser(pick, "Unterschrift wählen");
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{cam});
        try {
            startActivityForResult(chooser, REQ_IMAGE);
            return true;
        } catch (ActivityNotFoundException e) {
            fileCallback.onReceiveValue(null);
            fileCallback = null;
            return false;
        }
    }

    @Override
    protected void onActivityResult(int req, int res, Intent data) {
        super.onActivityResult(req, res, data);
        if (req == REQ_IMAGE && fileCallback != null) {
            Uri[] result = null;
            if (res == RESULT_OK) {
                if (data != null && data.getData() != null) result = new Uri[]{data.getData()};
                else if (cameraFile != null && cameraFile.length() > 0) result = new Uri[]{cameraUri};
            }
            fileCallback.onReceiveValue(result);
            fileCallback = null;
        } else if (req == REQ_SAVE) {
            if (res == RESULT_OK && data != null && data.getData() != null && pendingSave != null) {
                try (OutputStream os = getContentResolver().openOutputStream(data.getData())) {
                    os.write(pendingSave);
                    Toast.makeText(this, "PDF gespeichert", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(this, "Speichern fehlgeschlagen", Toast.LENGTH_LONG).show();
                }
            }
            pendingSave = null;
        }
    }

    /** Wird aus JavaScript als window.AndroidApp aufgerufen. */
    private class Bridge {
        @JavascriptInterface
        public String readClipboard() {
            try {
                ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData c = cm.getPrimaryClip();
                if (c == null || c.getItemCount() == 0) return "";
                CharSequence t = c.getItemAt(0).coerceToText(MainActivity.this);
                return t == null ? "" : t.toString();
            } catch (Exception e) {
                return "";
            }
        }

        @JavascriptInterface
        public void sharePdf(String b64, String name) {
            try {
                File f = new File(shareDir(), name);
                try (FileOutputStream os = new FileOutputStream(f)) {
                    os.write(Base64.decode(b64, Base64.DEFAULT));
                }
                Uri u = uriFor(f);
                Intent send = new Intent(Intent.ACTION_SEND);
                send.setType("application/pdf");
                send.putExtra(Intent.EXTRA_STREAM, u);
                send.putExtra(Intent.EXTRA_SUBJECT, name.replaceAll("\\.pdf$", "").replace('_', ' '));
                send.setClipData(ClipData.newRawUri("", u));
                send.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                runOnUiThread(() -> startActivity(Intent.createChooser(send, "PDF senden mit …")));
            } catch (Exception e) {
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Teilen fehlgeschlagen", Toast.LENGTH_LONG).show());
            }
        }

        @JavascriptInterface
        public void savePdf(String b64, String name) {
            pendingSave = Base64.decode(b64, Base64.DEFAULT);
            Intent i = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("application/pdf");
            i.putExtra(Intent.EXTRA_TITLE, name);
            runOnUiThread(() -> startActivityForResult(i, REQ_SAVE));
        }
    }
}
