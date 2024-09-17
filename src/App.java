import java.util.Scanner;

public class App {
    static double balance = 0; // static för att kunna använda variablen i hela klassen och inte bara i main
                               // metoden
    static Scanner input = new Scanner(System.in); // static för att kunna använda input i hela klassen och inte bara i
                                                   // main metoden

    public static void main(String[] args) throws Exception {
        boolean run = true; // skapa en boolean för att kunna köra programmet i en loop sålänge run är true

        while (run) {
            // meny för att välja vad
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Se saldo");
            System.out.println("2. Insättning");
            System.out.println("3. Uttag");
            System.out.println("4. Avsluta");
            int val = input.nextInt(); //

            if (input.hasNextInt()) { // kolla om input är ett nummer
                val = input.nextInt();

                switch (val) {
                    case 1:
                        getBalance();
                        break;

                    case 2:
                        deposit();
                        break;

                    case 3:
                        withdraw();
                        break;
                    case 4:
                        exit();
                        run = false;
                        break;

                    default:
                        System.out.println("Felaktigt val. Vänligen välj ett nummer mellan 1 och 4."); // om fel val
                                                                                                       // görs i menyn
                        break;
                }

            } else {
                System.out.println("Felaktigt inmatning. Vänligen ange ett nummer."); // om fel inmatning görs
                input.next(); // rensa input
            }
            input.close(); // stänga input
        }

    }

    // metod för att se saldo
    public static void getBalance() {
        System.out.println("Ditt saldo är: " + balance + " kronor.");
    }

    // metod för insättning
    public static void deposit() {
        System.out.println("Välj belopp att sätta in på kontot: ");
        if (input.hasNextDouble()) { // kolla om input är ett nummer
            double deposit = input.nextDouble();
            balance += deposit;
        } else { // om input inte är ett nummer
            System.out.println("Felaktigt inmatning. Vänligen ange ett nummer.");
            input.next();
        }

    }

    // metod för uttag
    public static void withdraw() {
        System.out.println("Välj belopp att ta ut från kontot: ");
        if (input.hasNextDouble()) {
            double withdraw = input.nextDouble();
            if (withdraw > balance) { // om uttaget är större än saldot
                System.out.println("Du har inte tillräckligt med pengar på kontot.");
            } else {
                balance -= withdraw;
                System.out.println(withdraw + " kronor har blivit uttaget från ditt konto.");
            }
        } else {
            System.out.println("Felaktigt inmatning. Vänligen ange ett nummer.");
            input.next(); // rensa input
        }
    }

    // metod för att avsluta programmet
    public static void exit() {
        System.out.println("Tack för att du använde banken. Ha en bra dag!");
    }

}
