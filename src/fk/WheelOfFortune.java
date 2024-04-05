package fk;

import java.util.Scanner;
import java.util.Random;

public class WheelOfFortune {
    public void spin(Player player) {
    	
        Scanner scanner = new Scanner(System.in); // Scanner-instans för att läsa in
        Random random = new Random(); // Skapa en instans av Random-klassen
        boolean fortsattSpela = true;
        Roulette roulette = new Roulette();  // Skapa en instans av Roulette-klassen
        double saldoNu = player.getSaldo(); // Hämta spelarens saldo
              
        

    	
        while (fortsattSpela) { // Loop tills användaren väljer att avsluta

            System.out.println("Varje försök kostar 50kr. Välj en siffra mellan 1 - 10: ");
           
            int choice = scanner.nextInt();

            // Rensa radbrytning från inmatningsbufferten
            scanner.nextLine();

            System.out.println("Du har valt " + choice);
            System.out.println("Hjulet snurrar");

            // Generera ett slumpmässigt heltal mellan 1 och 10
            int ran = random.nextInt(10) + 1; // om man inte lägger till + 1 blir det mellan 0-9
            System.out.println("Talet som vann är: " + ran);

            if (choice == ran) {
            	player.deposit(1000);
                System.out.println("Du vann!! Grattis!!");
                
            } else {
            	player.withdraw(50);
                System.out.println("Tyvärr vann du inte");
               
            }
            
            saldoNu = player.getSaldo();
            System.out.println("Ditt saldo är nu: " + saldoNu);

            System.out.println("Vill du försöka en gång till?");
            System.out.println("1. Ja");
            System.out.println("2. Nej");
            System.out.print("Ange ditt val (1 eller 2): ");

            int val = scanner.nextInt();
            if (val == 2) {
                fortsattSpela = false;
                System.out.println("Vill du spela Roulette?");
                System.out.println("1. Ja");
                System.out.println("2. Nej");
                System.out.print("Ange ditt val (1 eller 2): ");
                
                int newchoice = scanner.nextInt();
                
                switch (newchoice) {
                case 1:
                	roulette.bet(player);
                    break;
                case 2:
                	fortsattSpela = false; 
                	System.out.println("Tack för idag");
                    break;
                default:
                    System.out.println("Ogiltigt val!");
                    break;
            }
               
            }
        }

        // Stäng Scanner-objektet
        scanner.close();
    }
}




