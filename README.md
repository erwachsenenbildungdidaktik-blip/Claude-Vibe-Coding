# BIN · Kurs & Coaching Tool

Eine einzige HTML-Datei, läuft offline im Browser. Nichts wird im Browser gespeichert.
Die Tool-Datei selbst liegt bewusst **nicht** in diesem Repository.

## Arbeiten mit dem USB-Stick (Edge / Chrome)

1. Tool-Datei auf den Stick kopieren und per Doppelklick in **Edge oder Chrome** öffnen.
2. **„Klienten“ → „Klientenordner wählen …“**: einmal pro Sitzung den Ordner auf dem Stick wählen.
3. Klient anklicken = öffnen (Passwort eingeben). **„+ Neuer Klient“** = Name erfassen, speichern, Passwort festlegen.
4. Jede Änderung wird nach ca. 1 Sekunde automatisch gespeichert (oben: „🔒 ✓ gespeichert · hh:mm“).
   `Strg+S` speichert sofort, `Strg+Shift+S` = Speichern unter.
5. **„Sitzung beenden“** am Schluss: speichert, leert das Fenster, vergisst Ordner und Passwort.
   Danach Tab schliessen und Stick auswerfen.

### Verschlüsselung
- Klientendateien sind mit Passwort verschlüsselt (AES-256-GCM, Schlüssel via PBKDF2-SHA256, 600 000 Runden).
- **Passwort vergessen = Daten weg.** Es gibt keine Hintertür.
- Alte, unverschlüsselte Dateien lassen sich weiterhin öffnen und werden beim nächsten Speichern verschlüsselt.
- Der **Dateiname** (enthält den Klientennamen) ist nicht verschlüsselt.
- Der Export „→ Schlussbericht“ bleibt unverschlüsselt (für den Generator).

### Sicherungskopien
Beim Öffnen eines Klienten wird der bisherige Stand in `_sicherungen/` abgelegt (die letzten 10 pro Klient).
Wiederherstellen: „Klienten“ → „Sicherungen“ beim Klienten → Stand anklicken.

## Firefox
Kein direkter Dateizugriff: „Klienten“ → „Datei laden …“ (Upload) und „Speichern“ (Download), ebenfalls verschlüsselt.
