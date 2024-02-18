package ETbwz;

import ETbwz.Computer.Computer;
import ETbwz.Computer.ComputerRepository;

import ETbwz.Bestellung.Bestellung;
import ETbwz.Bestellung.Bestellposition;
import ETbwz.Bestellung.BestellungRepository;

import ETbwz.Kunde.Adresse;
import ETbwz.Kunde.Kunde;
import ETbwz.Kunde.KundeRepository;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ComputerShopApp {

    public void run() {

        //Main Menu
        System.out.println("Willkommen");
        System.out.println("----------");
        System.out.println("1. Computer verwalten");
        System.out.println("2. Bestellungen verwalten");
        System.out.println("3. Kunden verwalten");
        System.out.println("9. Beenden");

        // Menu Auswahl Scanner
        Scanner verwaltungsScanner = new Scanner(System.in);
        int verwaltungAuswahl = verwaltungsScanner.nextInt();

        switch (verwaltungAuswahl) {

            //Computer verwalten
            case 1:
            {
                System.out.println("1. Alle Computer anzeigen");
                System.out.println("2. Computer nach ID suchen");
                System.out.println("3. Computer einfügen");
                System.out.println("4. Computer ändern");
                System.out.println("5. Computer löschen");
                System.out.println("9. Beenden");

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                // Computer anzeigen
                switch (userInput) {
                    case 1: {
                        ComputerRepository computerRepository = new ComputerRepository();
                        computerRepository.getAll();
                        break;
                    }

                    // Computer nach Id anzeigen lassen
                    case 2: {

                        ComputerRepository computerRepository = new ComputerRepository();
                        Scanner scanner2 = new Scanner(System.in);
                        // ComputerId nachfragen
                        System.out.println("Alle Computer: ");
                        computerRepository.getAll();
                        System.out.println("ComputerId: ");
                        computerRepository.getById(scanner2.nextLine());

                        break;
                    }

                    // Computer einfügen
                    case 3: {

                        Computer computer = new Computer();
                        ComputerRepository computerRepository = new ComputerRepository();
                        Scanner scanner1 = new Scanner(System.in);

                        // Computer Daten abfragen
                        System.out.println("Hersteller: ");
                        computer.setHersteller(scanner1.nextLine());
                        System.out.println("Modell: ");
                        computer.setModell(scanner1.nextLine());
                        System.out.println("Arbeitsspeicher [GB]: ");
                        computer.setArbeitsspeicher(scanner1.nextInt());
                        scanner1.nextLine();
                        System.out.println("CPU: ");
                        computer.setCpu(scanner1.nextLine());
                        System.out.println("Massenspeicher: ");
                        computer.setMassenspeicher(scanner1.nextInt());
                        scanner1.nextLine();
                        System.out.println("Typ (Notebook / Desktop): ");
                        computer.setTyp(scanner1.nextLine());
                        System.out.println("Einzelpreis: ");
                        computer.setEinzelpreis(scanner1.nextDouble());

                        // Computer einfügen
                        computerRepository.insert(new Computer(computer.getHersteller(), computer.getModell(), computer.getArbeitsspeicher(), computer.getCpu(), computer.getMassenspeicher(), computer.getTyp(), computer.getEinzelpreis()));
                        break;
                    }


                    case 4: {

                        Computer computer = new Computer();
                        ComputerRepository computerRepository = new ComputerRepository();
                        Scanner scanner1 = new Scanner(System.in);
                        Scanner idScanner = new Scanner(System.in);

                        // Nach Computer abfragen & Daten bearbeiten

                        System.out.println("Alle Computer: ");
                        computerRepository.getAll();
                        System.out.println("Computer Id: ");
                        String idString = idScanner.nextLine();
                        System.out.println("Neu Hersteller: ");
                        computer.setHersteller(scanner1.nextLine());
                        System.out.println("Neu Modell: ");
                        computer.setModell(scanner1.nextLine());
                        System.out.println("Neu Arbeitsspeicher [GB]: ");
                        computer.setArbeitsspeicher(scanner1.nextInt());
                        scanner1.nextLine();
                        System.out.println("Neu CPU: ");
                        computer.setCpu(scanner1.nextLine());
                        System.out.println("Neu Massenspeicher: ");
                        computer.setMassenspeicher(scanner1.nextInt());
                        scanner1.nextLine();
                        System.out.println("Neu Typ (Notebook / Desktop): ");
                        computer.setTyp(scanner1.nextLine());
                        System.out.println("Neu Einzelpreis: ");
                        computer.setEinzelpreis(scanner1.nextDouble());

                        // Bearbeitete daten einfügen
                        computerRepository.update(new Computer(computer.getHersteller(), computer.getModell(), computer.getArbeitsspeicher(), computer.getCpu(), computer.getMassenspeicher(), computer.getTyp(), computer.getEinzelpreis()), idString);
                        break;
                    }

                    // Computer löschen
                    case 5:
                    {
                        ComputerRepository computerRepository = new ComputerRepository();
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("ComputerId: ");
                        computerRepository.delete(scanner2.nextLine());
                    }

                    case 9: {
                        break;
                    }
                }
                break;
            }

            // Bestellungen verwalten
            case 2:
            {
                System.out.println("1. Alle Bestellungen anzeigen");
                System.out.println("2. Bestellung nach ID suchen");
                System.out.println("3. Bestellung einfügen");
                System.out.println("4. Bestellung ändern");
                System.out.println("5. Bestellung löschen");
                System.out.println("9. Beenden");

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                // Bestellungen anzeigen
                switch (userInput) {
                    case 1: {
                        BestellungRepository bestellungRepository = new BestellungRepository();
                        bestellungRepository.getAll();
                        break;
                    }

                    // Bestellungen nach Bestell-Nummer Anzeigen
                    case 2: {
                        BestellungRepository bestellungRepository = new BestellungRepository();
                        Scanner scanner2 = new Scanner(System.in);

                        System.out.println("Alle Bestellungen: ");
                        bestellungRepository.getAll();
                        System.out.println("Bestell-Nummer: ");
                        bestellungRepository.getById(scanner2.nextInt());
                        scanner2.nextLine();
                        break;
                    }

                    // Bestellung einfügen
                    case 3: {
                        List<Bestellposition> bestellpositionen = new ArrayList<>();
                        BestellungRepository bestellungRepository = new BestellungRepository();
                        ComputerRepository computerRepository = new ComputerRepository();

                        Scanner scanner1 = new Scanner(System.in);
                        String userInput1;
                        String computerId = null;
                        // Bestellpositionen einfügen
                        do {
                            System.out.println("Verfügbare Computer:");
                            computerRepository.getAll();
                            System.out.println("Artikel (ComputerId): ");
                            computerId = scanner1.next();
                            scanner1.nextLine();
                            System.out.println("Stück: ");
                            int pieces = scanner1.nextInt();
                            scanner1.nextLine();

                            // Preis vom Computer mit der gegebenen ComputerId abrufen
                            Computer computer = computerRepository.getById(computerId);
                            double computerPreis = computer.getEinzelpreis();

                            // Bestellposition erstellen und hinzufügen
                            Bestellposition bestellposition = new Bestellposition();
                            bestellposition.setPreis(computerPreis);
                            bestellposition.setPieces(pieces);
                            bestellpositionen.add(bestellposition);

                            System.out.println("Weitere Artikel bestellen? (ja/nein): ");
                            userInput1 = scanner1.nextLine();
                        } while (userInput1.equalsIgnoreCase("ja"));

                        Bestellung bestellung = new Bestellung();
                        Random rand = new Random();
                        int randomNumber;
                        do {
                            randomNumber = rand.nextInt(32000);
                        } while (bestellungRepository.exists(randomNumber));

                        LocalDate now = LocalDate.now();
                        bestellung.setBestellnummer(randomNumber);
                        bestellung.setBestelldatum(now);

                        // Bestellung einfügen
                        bestellungRepository.insert(bestellung, computerId, bestellpositionen);

                        break;
                    }


                    // Bestellung bearbeiten (nicht fertig)
                    case 4: {

                    }

                    // Bestellung löschen
                    case 5:
                    {
                        BestellungRepository bestellungRepository = new BestellungRepository();
                        Scanner scanner2 = new Scanner(System.in);

                        System.out.println("Alle Bestellungen: ");
                        bestellungRepository.getAll();
                        System.out.println("Bestellungnummer: ");
                        bestellungRepository.delete(scanner2.nextInt());
                        scanner2.nextLine();
                        break;
                    }

                    // Beenden
                    case 9: {
                        break;
                    }
                }
                break;
            }

            // Kunden verwalten
            case 3:
            {
                System.out.println("1. Alle Kunden anzeigen");
                System.out.println("2. Kunde nach ID suchen");
                System.out.println("3. Kunde einfügen");
                System.out.println("4. Kunde ändern");
                System.out.println("5. Kunde löschen");
                System.out.println("9. Beenden");

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                // Alle Kunden anzeigen
                switch (userInput) {
                    case 1: {
                        KundeRepository kundeRepository = new KundeRepository();
                        kundeRepository.getAll();
                        break;
                    }

                    // Kunde nach Id anzeigen lassen
                    case 2: {
                        KundeRepository kundeRepository = new KundeRepository();
                        Scanner scanner2 = new Scanner(System.in);

                        System.out.println("KundeId: ");
                        kundeRepository.getById(scanner2.nextLine());
                        break;
                    }

                    // Neue Kunde einfügen
                    case 3: {
                        Kunde kunde = new Kunde();
                        KundeRepository kundeRepository = new KundeRepository();
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Nachname: ");
                        kunde.setNachname(scanner1.nextLine());
                        System.out.println("Vorname: ");
                        kunde.setVorname(scanner1.nextLine());
                        System.out.println("Geschlecht: ");
                        kunde.setGender(scanner1.nextLine());
                        System.out.println("Geburtsdatum (Format: dd.MM.yyyy): ");
                        String dateString = scanner1.next();
                        kunde.setGeburtsdatum(dateString);
                        scanner1.nextLine();
                        System.out.println("Sprache: ");
                        kunde.setSprache(scanner1.nextLine());
                        System.out.println("Email: ");
                        kunde.setEmail(scanner1.nextLine());
                        System.out.println("Telefon: ");
                        kunde.setTelefon(scanner1.nextLine());
                        System.out.println("Strasse: ");
                        String strasse = scanner1.nextLine();
                        System.out.println("PLZ: ");
                        int plz = scanner1.nextInt();
                        scanner1.nextLine();
                        System.out.println("Ort: ");
                        String ort = scanner1.nextLine();

                        Adresse adresse = new Adresse(strasse, plz ,ort);
                        kunde.setAdresse(adresse);

                        kundeRepository.insert(kunde);

                        break;
                    }

                    // Kunde bearbeiten
                    case 4: {
                        Kunde kunde = new Kunde();
                        KundeRepository kundeRepository = new KundeRepository();
                        Scanner scanner1 = new Scanner(System.in);
                        Scanner idScanner = new Scanner(System.in);

                        System.out.println("Alle Kunden: ");
                        kundeRepository.getAll();

                        // Nach Kunde abfragen & Daten bearbeiten
                        System.out.println("Kunde Id: ");
                        String idString = idScanner.nextLine();
                        System.out.println("Neu Nachname: ");
                        kunde.setNachname(scanner1.nextLine());
                        System.out.println("Neu Vorname: ");
                        kunde.setVorname(scanner1.nextLine());
                        System.out.println("Neu Geschlecht: ");
                        kunde.setGender(scanner1.nextLine());
                        System.out.println("Neu Geburtsdatum: ");
                        String dateString = scanner1.next();
                        kunde.setGeburtsdatum(dateString);
                        scanner1.nextLine();
                        System.out.println("Neu Sprache: ");
                        kunde.setSprache(scanner1.nextLine());
                        System.out.println("Neu Email: ");
                        kunde.setEmail(scanner1.nextLine());
                        System.out.println("Neu Telefon: ");
                        kunde.setTelefon(scanner1.nextLine());

                        System.out.println("Strasse: ");
                        String strasse = scanner1.nextLine();
                        System.out.println("PLZ: ");
                        int plz = scanner1.nextInt();
                        scanner1.nextLine();
                        System.out.println("Ort: ");
                        String ort = scanner1.nextLine();

                        Adresse adresse = new Adresse(strasse, plz ,ort);
                        kunde.setAdresse(adresse);

                        kundeRepository.update(kunde, idString);
                        break;
                    }
                    case 5:
                    {
                        KundeRepository kundeRepository = new KundeRepository();
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("KundeId: ");
                        kundeRepository.delete(scanner2.nextLine());
                    }

                    case 9: {
                        break;
                    }
                }
                break;
            }

        }



    }

}
