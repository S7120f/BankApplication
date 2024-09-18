import java.util.Scanner;

public class App {
    static double balance = 0; // static för att kunna använda variablen i hela klassen och inte bara i main metoden
    static Scanner input = new Scanner(System.in); // static för att kunna använda input i hela klassen och inte bara i main metoden

    public static void main(String[] args) {
        boolean run = true; // skapa en boolean för att kunna köra programmet i en loop sålänge run är true

        while (run) { // loop för att köra programmet så länge run är true
            // meny för att välja val
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Se saldo");
            System.out.println("2. Insättning");
            System.out.println("3. Uttag");
            System.out.println("4. Avsluta");

            if (input.hasNextInt()) { // kolla om input är ett heltal
                int choice = input.nextInt();  // läser användarens val
                switch (choice) { // switch case för att välja val
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

                    default: // om fel val görs
                        System.out.println("Felaktigt val. Vänligen välj ett nummer mellan 1 och 4."); // om fel val görs i menyn
                        break;
                }

            } else {
                System.out.println("Felaktigt inmatning. Vänligen ange ett nummer."); // om fel inmatning görs
                input.next(); // rensa input
            }
        }
        input.close(); // stänga input
    }

    // metod för att visa saldo
    public static void getBalance() {
        System.out.println("Ditt saldo är: " + balance + " kronor.");
    }

    // metod för insättning
    public static void deposit() {
        System.out.println("Välj belopp att sätta in på kontot: ");
        if (input.hasNextDouble()) { // kolla om input är ett nummer
            double deposit = input.nextDouble(); // läser in insättning
            if (deposit > 0) {
                balance += deposit;
                System.out.println(deposit + " kronor har blivit insatt på ditt konto.");
            } else {
                System.out.println("Felaktigt inmatning. Vänligen ange ett positivt nummer.");
            }
        } else { // om input inte är ett nummer
            System.out.println("Felaktigt inmatning. Vänligen ange ett belopp.");
            input.next(); // rensa felaktig inmatning
        }
        input.nextLine(); // rensar eventuell buffert

    }

    // metod för uttag
    public static void withdraw() {
        System.out.println("Välj belopp att ta ut från kontot: ");
        if (input.hasNextDouble()) { // kolla om input är ett giltigt decimaltal
            double withdraw = input.nextDouble();
            if (withdraw > balance) { // om uttaget är större än saldot
                System.out.println("Du har inte tillräckligt med pengar på kontot.");
            } else if (withdraw <= 0) { // om uttaget är mindre än eller lika med 0
                System.out.println("Felaktigt inmatning. Beloppet måste vara större än 0.");
            }
            else {
                balance -= withdraw;
                System.out.println(withdraw + " kronor har blivit uttaget från ditt konto.");
            }
        } else {
            System.out.println("Felaktigt inmatning. Vänligen ange ett belopp.");
            input.next(); // rensa input
        }
        input.nextLine(); // rensar eventuell buffert
    }

    // metod för att avsluta programmet
    public static void exit() {
        System.out.println("Tack för att du använde banken. Ha en bra dag!");
    }

}
