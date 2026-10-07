# Leitlinien für Claude

Gilt für jede Sitzung in diesem Repository. Zielgruppe der Werkzeuge: RAV-Kundinnen und -Kunden
in Bewerbungskursen und Einzelcoachings.

## Arbeitsweise

- Widersprechen, wenn eine Annahme falsch ist. Direkt und pragmatisch.
- Ohne belastbare Quelle sagen: «Das weiss ich nicht». Nicht raten, keine erfundenen Zahlen
  (zum Beispiel keinen Prozentsatz für den verdeckten Arbeitsmarkt).
- Rechtsangaben (AVIG, Zwischenverdienst, Kompensationszahlungen, Einarbeitungszuschüsse,
  Zumutbarkeit) nur mit Quelle. Sonst als unsicher kennzeichnen und auf RAV-Personalberatung,
  Arbeitslosenkasse oder arbeit.swiss verweisen.
- Schweizer Hochdeutsch: «ss» statt «ß», Sie-Form, kurze Sätze, nicht wertend.

## Grundsätze für die Werkzeuge

- **Tool-Dateien (`*.html`) liegen bewusst nicht im Repository.** Nicht committen; als Datei an die
  Nutzerin oder den Nutzer übergeben.
- **Nichts im Browser speichern.** Kein `localStorage`, `sessionStorage` oder IndexedDB. Auf gemeinsam
  genutzten Kurscomputern sähe sonst die nächste Person die Daten der vorherigen. Gesichert wird
  nur über «Sichern als Datei» / «Datei einlesen». Jedes Werkzeug hat «Sitzung beenden».
- **Offline lauffähig.** Keine externen Schriften, CDNs oder Tracker.
- **Zweck der Werkzeuge:** (1) Eigeninitiative durch angeleitete, strukturierte Recherche;
  (2) klare Ausschlusskriterien als Gesprächsinhalt für das Einzelgespräch zur Bewerbungsstrategie.
  Sackgassen werden benannt («Zurückstellen»), weil sie nicht zu einer raschen Integration führen.
- **Schadensminderungspflicht beachten.** Keine Fragen oder Funktionen, die zumutbare Arbeit
  ausschliessen helfen (Interesse, Wunschlohn, «Passt zu mir?»). Gesundheitliche Einschränkungen
  klärt das RAV, nicht das Werkzeug.
- **Einstufungen sind Gesprächsgrundlage, keine Entscheidung.** Schwellenwerte sind gesetzt, nicht
  geeicht; das gehört transparent in den Disclaimer.

## Plattformen und ihre Rolle

- **Job-Room:** Stellen und RAV-Kandidaten. Suchradius bei beiden Suchen auf 10 km stellen; die
  Kandidatensuche steht standardmässig auf 150 km.
- **jobs.ch:** Grösse des offenen Marktes (Stichwortsuche, Treffer überfliegen).
- **LinkedIn:** Ansprechpersonen nach Funktion finden, Firmenbeiträge als Signal.
- **Coople:** Schweizer Plattform für Temporär- und Flexjobs. Zeigt, welche Betriebe gerade
  kurzfristig Personal brauchen: ein Einstiegssignal, kein Recherchewerkzeug.
- **berufsberatung.ch:** Berufsbilder, Anforderungen, Bildungswege.

## Bewerbungstexte im Schweizer Stil

Aufbau Sie – Ich – Wir. Belegt statt behauptet, zurückhaltend im Ton.

### Sie-Teil: eine kreative Einleitung aus der eigenen Firmenrecherche

Darum ist die Firmenrecherche so wichtig: Jeder Mensch achtet auf andere Dinge. Was der Person
auffällt, macht die Bewerbung einzigartig, auch wenn eine KI beim Formulieren hilft.

- **Aufhänger gibt es viele, nicht nur den Slogan:**
  - Slogan und Werbesprache
  - Zahlen: Gründungsjahr, Mitarbeitende, Filialen, Tagesmengen, Kundschaft (für zahlenaffine Personen)
  - Geschichte und Tradition
  - Werte und Leitbild, und woran man sie im Alltag sieht
  - Produkte und Dienstleistungen, aus Sicht der Kundschaft
  - Aktuelles: Neubau, neue Filiale, Auszeichnung, Übernahme, Medienbericht
  - Menschen: Lehrlingsausbildung, Teamkultur, Auftritt in den sozialen Medien
  - Eigener Berührungspunkt: selbst Kundin oder Kunde gewesen, beobachtet, erlebt
- **Die Auswahl trifft die Person.** Frage an sie: «Was ist Ihnen bei der Recherche aufgefallen?»
  Claude formuliert aus dieser Beobachtung mehrere Varianten, die Person wählt.
- **Keine erfundenen Fakten.** Claude arbeitet nur mit dem, was die Person recherchiert hat.
  Zahlen und Fakten brauchen eine Quelle; eine falsche Zahl in der Einleitung schadet mehr als
  keine.
- Viele Firmen bevorzugen Personen, die sich mit ihren Werten identifizieren, auch mit Lücken im
  Profil, gegenüber Wunschkandidaten mit eigener Agenda.
- Den Aufhänger **nicht zitieren und kommentieren**, sondern in den eigenen Satz verweben, sodass
  er zur Brücke zur eigenen Erfahrung wird. Techniken:
  - **Weiterführen:** den Slogan aufnehmen und dort weiterdenken, wo die eigene Arbeit liegt.
  - **Hinter die Kulissen:** zeigen, was es braucht, damit der Slogan für die Kundschaft stimmt.
  - **Wortspiel oder Bild:** ein Begriff aus dem Slogan wird auf die eigene Rolle übertragen.
- Beispiele (erfundene Firmenangaben):
  - Schwach: «Ihr Slogan ‹Frische, die man schmeckt› spricht mich sehr an.»
  - Stark: «Frische, die man schmeckt, beginnt lange vor der Theke: beim Warenfluss, bei der
    Lagerung und beim richtigen Wort zur Kundin. Genau dort habe ich die letzten vier Jahre
    gearbeitet.»
  - Stark: «Bewegung in die Region bringen Sie mit Ihren Linien jeden Tag. Damit diese Bewegung im
    Lager nicht ins Stocken gerät, habe ich während fünf Jahren …»
  - Zahl: «40 000 Pakete verlassen Ihr Verteilzentrum jeden Tag. Damit jedes davon stimmt, braucht
    es Hände, die genau arbeiten: In den letzten fünf Jahren habe ich …»
  - Aktuelles: «Mit der neuen Filiale in Lyss kommen Sie Ihrer Kundschaft im Seeland ein gutes
    Stück näher. Diese Kundschaft kenne ich: …»
- Leitplanken: Die Einleitung muss von einem echten Beleg gedeckt sein. Der Ton richtet sich nach
  der Firma: bei konservativen Betrieben und öffentlichen Arbeitgebenden dezent statt verspielt.
  Prüffrage aus dem Arbeitsblatt: «Passt das zu dieser Firma?»

### Wir-Teil: Win-win auf Schweizer Art

Kein Auftrumpfen, keine selbstbezogenen Gewissheiten. Der Wir-Teil folgt drei Schritten:

1. **Einschätzen:** Die Anforderungen und Aufgaben kann ich einschätzen (zeigt, dass die Stelle
   verstanden ist).
2. **Einbringen:** Meine Erfahrung und Kompetenzen bringe ich ein (mit Beleg).
3. **Stärken:** Diese kann ich bei Ihnen weiter stärken und vertiefen.

Daraus ergibt sich die Win-win-Situation, zurückhaltend formuliert, etwa als Möglichkeit oder
Gelegenheit, die sich mit dieser Stelle bietet.

- Beispiel: «Die Aufgaben in Ihrem Kundendienst kann ich gut einschätzen: Reklamationen am Telefon
  gehörten in den letzten drei Jahren zu meinem Alltag. Diese Erfahrung bringe ich gerne bei Ihnen
  ein, und mit Ihrer zweisprachigen Kundschaft könnte ich meine Französischkenntnisse weiter
  festigen. Daraus ergäbe sich eine gute Grundlage für beide Seiten.»
- **Vermeiden:** «Ich bin überzeugt, dass …», «Ich bin sicher, dass ich …», «Ich passe perfekt …»,
  «meine Leidenschaft», «Ich bringe einen grossen Mehrwert».
- Eigene Agenda heisst: Weiterentwicklung **ohne Bezug zu den Aufgaben** («Ich möchte mich
  beruflich neu orientieren»). Weiterentwicklung **an den Aufgaben** ist Teil des Win-win.
- Einstieg anbieten statt Stelle fordern (Probeeinsatz, befristeter Einsatz, Saison), immer zu
  orts- und branchenüblichem Lohn.
