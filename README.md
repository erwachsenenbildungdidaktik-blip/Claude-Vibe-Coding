# BIN · Kurs & Coaching Tool

Eine einzige HTML-Datei, läuft offline im Browser. Nichts wird im Browser gespeichert.

## Direkt auf dem USB-Stick arbeiten (Edge / Chrome)

1. `bin-kurs-tool.html` auf den Stick kopieren und per Doppelklick in **Edge oder Chrome** öffnen.
2. Neuer Klient: Daten erfassen, dann **„Speichern unter…“** und einen Ordner auf dem Stick wählen.
   Bestehender Klient: **„Öffnen“** und die `.json`-Datei auf dem Stick wählen, dann „Bearbeiten erlauben“ bestätigen.
3. Ab jetzt wird jede Änderung nach ca. 1 Sekunde automatisch in genau diese Datei geschrieben
   (Anzeige oben: „✓ gespeichert · hh:mm“). `Strg+S` speichert sofort, `Strg+Shift+S` = Speichern unter.
4. „Alle Daten löschen“ löst die Verknüpfung zur Datei, damit der nächste Klient nicht die alte Datei überschreibt.

In Firefox gibt es diese Schnittstelle nicht; dort funktionieren „Öffnen“ und „Speichern“ wie bisher per Upload/Download.
