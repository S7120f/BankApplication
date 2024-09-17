import java.util.Scanner;

public class App {

    static double balance = 0; // static för att kunna använda variablen i hela klassen och inte bara i main
                               // metoden

    public static void main(String[] args) throws Exception {

        // skapa en scanner för att kunna skriva in saker i terminalen
        Scanner input = new Scanner(System.in);

        boolean run = true; // skapa en boolean för att kunna köra programmet i en loop sålänge run är true

        while (run) {

            System.out.println("Välkommen till banken! Välj ett alternativ?  n 1. Se saldo. n 2 Insättning. n 3 uttag. n 4. Avsluta programmet.");
            int val = input.nextInt(); //

            switch (val) {
                case 1:
                    balance();
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
                    break;
            }

        }

    }

    // metod för att se saldo
    public static void balance() {
        System.out.println("Ditt saldo är: " + balance + " kronor.");
    }

    // metod för insättning
    public static void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Välj belopp att sätta in på kontot: ");
        double depoist = input.nextDouble();
        balance += depoist;
        System.out.println(depoist + " kronor har blivit insatt på ditt konto.");

    }

    // metod för uttag
    public static void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Välj belopp att ta ut från kontot: ");
        double withdraw = input.nextDouble();
        balance -= withdraw;
        System.out.println(withdraw + " kronor har blivit uttaget från ditt konto.");
    }

    // metod för att avsluta programmet
    public static void exit() {
        System.out.println("Tack för att du använde banken. Ha en bra dag!");
    }

}
