package ETbwz;

import ETbwz.Computer.Computer;
import ETbwz.Computer.ComputerRepository;

import java.util.Scanner;

public class ComputerShopApp {

    public void run() {

        System.out.println("Willkommen");
        System.out.println("----------");
        System.out.println("1. Alle Computer anzeigen");
        System.out.println("2. Computer nach ID suchen");
        System.out.println("3. Computer einfügen");
        System.out.println("4. Computer ändern");
        System.out.println("5. Computer löschen");
        System.out.println("9. Beenden");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1: {
                ComputerRepository computerRepository = new ComputerRepository();
                computerRepository.getAll();
                break;
            }
            case 2: {
                ComputerRepository computerRepository = new ComputerRepository();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("ComputerId: ");
                computerRepository.getById(scanner2.nextLine());

                break;
            }
            case 3: {
                Computer computer = new Computer();
                ComputerRepository computerRepository = new ComputerRepository();
                Scanner scanner1 = new Scanner(System.in);
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

                computerRepository.insert(new Computer(computer.getHersteller(), computer.getModell(), computer.getArbeitsspeicher(), computer.getCpu(), computer.getMassenspeicher(), computer.getTyp(), computer.getEinzelpreis()));
                break;
            }


            case 4: {
                Computer computer = new Computer();
                ComputerRepository computerRepository = new ComputerRepository();
                Scanner scanner1 = new Scanner(System.in);
                Scanner idScanner = new Scanner(System.in);
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

                computerRepository.update(new Computer(computer.getHersteller(), computer.getModell(), computer.getArbeitsspeicher(), computer.getCpu(), computer.getMassenspeicher(), computer.getTyp(), computer.getEinzelpreis()), idString);
break;
            }
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
    }

}
