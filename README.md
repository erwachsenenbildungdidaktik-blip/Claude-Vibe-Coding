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

> **Wichtig: Tool nie von einem Server-Laufwerk starten.** Liegt die Tool-Datei auf einem
> Netzlaufwerk – oft unbemerkt, weil der **Desktop** bzw. „Dokumente“ auf den Server umgeleitet
> ist (`\\server\…\Desktop`) –, bricht Edge das Ordnerfenster ohne Meldung ab (`AbortError`).
> Das Tool vom Stick oder von einem lokalen Ordner (z. B. `C:\BIN`) öffnen.
> Ab v5.17 zeigt das Diagnoseprotokoll an, woher das Tool gestartet wurde, und warnt in diesem Fall.

### Dashboard (Startseite)
- Zeigt alle TN im Klientenordner: Gantt-Diagramm (Zeitfenster passt sich automatisch an: vom frühesten Start bis zum spätesten Ende aller laufenden TN, dazu geplante TN ab 4 Wochen vor Start und beendete bis 2 Wochen nach Ende; rote Heute-Linie), Stand pro TN, Kennzahlen.
- **Pendenzen & Termine**: überfällig (rot), fällig in 3 Tagen (orange), Termine der nächsten 7 Tage.
  Pendenzen = nicht abgehakte Wochenaufgaben (fällig am Freitag der Kurswoche) und nicht erreichte RAV-/Kursziele mit Datum.
  Termine = Start-/Standort-/Abschlussgespräche und geplante Vorstellungsgespräche.
- Aktualisiert sich jede Minute, solange der Tab offen ist. Erinnerungen gibt es nur bei offenem Tool.
- **„+ TN erfassen“**: leerer Klient-Dialog; nach „Übernehmen“ geht es direkt ins Startgespräch.
- Kursdauer pro TN im Klienten-Dialog: regulär 4 Wochen, verlängert 5 oder 6 Wochen, oder Abbruch mit Datum.
  Bei einer Verlängerung wird pro Zusatzwoche gewählt, **welche Kurswoche wiederholt** wird (ab v5.18).
  Dann erscheinen die Reiter **„W5 · Wdh. W2“** bzw. **„W6 · …“** mit Aufgaben, Traktanden und Outputs der
  wiederholten Woche (eigener Häkchen-Stand), RAV-/Kursziele, Bewerbungen/Vorstellungsgespräche und Notizen.
  Im Gantt ist die Zusatzwoche schraffiert und mit der wiederholten Woche beschriftet.
  **„Verlängerung planen“** (ab v6.1, im Klient-Dialog und in den Reitern W5/W6): pro Zusatzwoche eine Kurswoche
  wiederholen und/oder einzelne Lernsequenzen aus dem offiziellen Katalog (Übersicht 2026: A1–A6, B, C, E) anklicken.
  Begründung ist immer „Kursziele nicht erreicht“: Das Tool listet die offenen Kursziele auf, Ergänzung als Freitext.
  Daraus entstehen eine **E-Mail an die Koordination** (Sequenzen nach Wochen) und eine **E-Mail an die RAV-Beratung**
  (Begründung, Schwerpunkte, bisheriger Verlauf) — kopieren oder per `mailto:` im Standard-Mailprogramm (Outlook)
  öffnen. Ab v6.3 sind die Links im Windows-Zeichensatz kodiert, damit Umlaute im klassischen Outlook stimmen. Die geplanten Sequenzen erscheinen in W5/W6 zum Abhaken und im Schlussbericht.
- **Kursabbruch** (ab v6.2, Klient-Dialog → „Abbruch: Grund, Verwarnungen & E-Mail …“): Datum, Grund (Abwesenheit von
  10 Tagen · 4 unentschuldigte Abwesenheitstage · nach mündlicher und schriftlicher Verwarnung), Daten der Verwarnungen.
  Daraus entsteht eine **E-Mail an die Koordination**, die das Offizielle übernimmt; der Schlussbericht nennt den Grund.
- Beendete/abgebrochene TN: „Archivieren“ verschiebt die Datei samt ihren Sicherungskopien nach `_archiv/` (bzw. `_archiv/_sicherungen/`). Zurückholen: „Klienten“ → „Archiv …“.
  Laufende TN lassen sich über „✕ entfernen“ beim Namen ebenso ins Archiv verschieben (z. B. bei Fehlerfassung).
- **To-dos**: in die Zeile einer TN am gewünschten Tag klicken (oder „+ To-do“). Erscheinen als ⚑ im Gantt
  (blau offen, rot überfällig, grau erledigt) und in den Pendenzen mit Kästchen zum Abhaken. Gespeichert in der
  (verschlüsselten) Datei der TN; zählen auch bei beendeten TN (z. B. „Schlussbericht senden“).
  Zusätzlich erscheinen sie in der **Übersicht** der TN in der Kurswoche ihres Datums (vor Kursbeginn → W1,
  Verlängerung/nach Kursende → W4, jeweils mit Hinweis) und lassen sich dort abhaken, bearbeiten und neu erfassen.
- **Erinnerungen** (ab v6.5): To-dos haben optional eine Uhrzeit. Solange das Tool offen ist, erscheinen fällige
  To-dos unten rechts (mit Ton, auf Wunsch als Windows-Benachrichtigung) mit „Erledigt“ und „+1 Std.“; ohne Uhrzeit
  ab 08:00 am Fälligkeitstag. **„Speichern + Outlook“** lädt eine `.ics`-Datei mit Erinnerung (15 Min. vorher bzw.
  08:00) — Doppelklick übernimmt sie in Outlook, das dann auch bei geschlossenem Tool erinnert. Erneutes Übernehmen
  aktualisiert denselben Termin; erledigt wird im Tool abgehakt.
- Alle Dateien sollten dasselbe Passwort haben; abweichende lassen sich einzeln entsperren.

### Schlussbericht & IKT-Zertifikat (ab v6.0 im Tool)
Der frühere **Schlussbericht-Generator** ist als Reiter **„Schlussbericht“** eingebaut (auch über „→ Schlussbericht“
oben oder „Bericht“ im Dashboard). Kein JSON-Export mehr, keine Klartext-Dateien.
- **Vorbelegt aus dem Kurs-Tool:** Anrede, Name, Pensum, Status (Zwischenverdienst), Zielerreichung (RAV- und Kursziele),
  Dossier-Stand (W2-Outputs), Arbeitszeugnisse/Intervention, LinkedIn, Simulation A6.V, Führerausweis/Fahrzeug, IKT-Niveau,
  Job-Room. „Aus Kursdaten neu vorbelegen“ setzt die Eingaben zurück (die CSV bleibt).
- **Automatische Sätze** (je abschaltbar): Zielbilanz („Sie hat drei der vier vereinbarten RAV-Ziele erreicht …“),
  Kursverlauf (Verlängerung mit wiederholter Woche, Abbruch), Wirkung (Bewerbungen und Einladungen im Kurs vs. vorher).
  Die Schlussfolgerung beginnt passend zu Status, Zielerreichung und Dossier-Stand — nie mehr im Widerspruch zum Rest.
- **Gesprächsnotizen** aller Gespräche (inkl. W5/W6 und Traktanden-Notizen) stehen als Nachschlagewerk im Bericht.
- **Speichern:** Jede Eingabe landet verschlüsselt in der Klientendatei (`bericht`), ebenso die Kursteilnahmen-CSV.
- **Bausteine-Bibliothek:** liegt im Klientenordner unter `_bausteine/bibliothek.json` und wird automatisch geladen und
  gespeichert (enthält keine TN-Daten, solange keine Namen in Bausteine geschrieben werden).
- **Absenzen aus der CSV** (ab v6.4): Als Absenz zählen nur die Codes A–I (X = anwesend); leere oder unbekannte
  Codes werden nicht gewertet und als Warnung mit Datum angezeigt. Nur Code G trägt die Begründung aus der Grund-Zeile,
  alle anderen die Code-Bezeichnung (G ohne Begründung → Warnung). Umfang in Vierteltagen (¼ · ½ · ¾ · 1 Tag):
  pro Tageshälfte (Grenze 12:00) der Anteil der abwesenden an der geplanten Lektionszeit laut CSV.
- **IKT-Zertifikat:** zählt die besuchten Lektionen (jede Lektion = 1, unabhängig von der Dauer) und formuliert den
  Fliesstext aus den besuchten E-Sequenzen. Word-Zertifikat aus der SO-Datei wie bisher.
- Der Generator läuft weiterhin auch allein (`Schlussbericht-Generator_v7-0.html`).

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
