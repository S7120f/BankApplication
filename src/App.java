import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // skapa en scanner för att kunna skriva in saker i terminalen
        Scanner input = new Scanner(System.in); 

        double balance = 0 ; // en variable för att hålla koll på saldot på kontot
        boolean run = true;


        // skapa funktion för att se hur mycket saldo det finns på konto 

        //System.out.println("Välkommen till banken! Välj ett alternativ?  n 1. Se saldo . n 2 Insättning ");
        //int val = input.nextInt();

        while (run) {

            System.out.println("Välkommen till banken! Välj ett alternativ?  n 1. Se saldo. n 2 Insättning. n 3 uttag");
            int val = input.nextInt();

            switch (val) {
                case 1:
                    System.out.println("Ditt saldo är " + balance + " kronor");
                    break;
                
                case 2:
                    System.out.println("Välj belopp att sätta in på ditt konto");
                    double deposit = input.nextDouble();
                    balance += deposit;
                    System.out.println( deposit + " kronor har blivit insatt på ditt konto. Tillgänligt belopp är: " + balance + " kronor.");
                    break;

                case 3: 
                    System.out.println("Välj ett belopp att ta ut");
                    double withdraw = input.nextDouble();
                    balance -= withdraw;
                    System.out.println(withdraw + " kronor har blivit uttaget från ditt konto. Tillgänligt belopp är: " + balance + " kronor.");
                    break;
                    
                default:
                    break;
            }

        }

        

        



    }
}
