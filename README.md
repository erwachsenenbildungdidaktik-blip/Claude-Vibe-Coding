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

### Dashboard (Startseite)
- Zeigt alle TN im Klientenordner: Gantt-Diagramm (Zeitfenster passt sich automatisch an: vom frühesten Start bis zum spätesten Ende aller laufenden TN, dazu geplante TN ab 4 Wochen vor Start und beendete bis 2 Wochen nach Ende; rote Heute-Linie), Stand pro TN, Kennzahlen.
- **Pendenzen & Termine**: überfällig (rot), fällig in 3 Tagen (orange), Termine der nächsten 7 Tage.
  Pendenzen = nicht abgehakte Wochenaufgaben (fällig am Freitag der Kurswoche) und nicht erreichte RAV-/Kursziele mit Datum.
  Termine = Start-/Standort-/Abschlussgespräche und geplante Vorstellungsgespräche.
- Aktualisiert sich jede Minute, solange der Tab offen ist. Erinnerungen gibt es nur bei offenem Tool.
- Kursdauer pro TN im Klienten-Dialog: regulär 4 Wochen, verlängert 5 oder 6 Wochen, oder Abbruch mit Datum.
- Beendete/abgebrochene TN: „Archivieren“ verschiebt die Datei samt ihren Sicherungskopien nach `_archiv/` (bzw. `_archiv/_sicherungen/`). Zurückholen: „Klienten“ → „Archiv …“.
- **To-dos**: in die Zeile einer TN am gewünschten Tag klicken (oder „+ To-do“). Erscheinen als ⚑ im Gantt
  (blau offen, rot überfällig, grau erledigt) und in den Pendenzen mit Kästchen zum Abhaken. Gespeichert in der
  (verschlüsselten) Datei der TN; zählen auch bei beendeten TN (z. B. „Schlussbericht senden“).
  Zusätzlich erscheinen sie in der **Übersicht** der TN in der Kurswoche ihres Datums (vor Kursbeginn → W1,
  Verlängerung/nach Kursende → W4, jeweils mit Hinweis) und lassen sich dort abhaken, bearbeiten und neu erfassen.
- Alle Dateien sollten dasselbe Passwort haben; abweichende lassen sich einzeln entsperren.

### Notizen-Export (Markdown)
„→ Notizen (.md)“ exportiert alle Notizen der offenen TN (Gesprächsnotizen, Traktanden-Notizen, Dossier, Zeugnisse,
Vorstellungsgespräche) nach Erfassungszeitpunkt sortiert. Zeitpunkte werden seit v5.12 gespeichert; ältere Notizen
sind nach Gesprächsdatum eingeordnet und mit „≈“ markiert. **Die .md-Datei ist unverschlüsselt.**

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
