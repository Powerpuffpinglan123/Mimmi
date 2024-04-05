package fk;

import java.util.Scanner;

import fk.Player;
import fk.Roulette;

import java.util.Random;

public class WheelOfFortune {
public void spin() {
    	
        Scanner scanner = new Scanner(System.in); // Scanner-instans för att läsa in
        Random random = new Random(); // Skapa en instans av Random-klassen
        Player player = new Player("Alice", 1000); // Skapa en instans av Player-klassen
        boolean fortsattSpela = true;
        Roulette roulette = new Roulette();  // Skapa en instans av Roulette-klassen
        double saldo = player.getSaldo();
        double saldoNu = saldo;
        
        
        /*
         * 
         */
        
        // Implementera logiken för att placera insatsen
        // System.out.println("Det kostar 10 kr."); - Osäker på var detta ska stå

    	
        while (fortsattSpela) { // Loop tills användaren väljer att avsluta

            
            System.out.println("Varje försök kostar 50kr. Välj en siffra mellan 1 - 100: ");
           

            int choice = scanner.nextInt();

            // Rensa radbrytning från inmatningsbufferten
            scanner.nextLine();
            
            

            System.out.println("Du har valt " + choice);
            
            System.out.println("Hjulet snurrar");

            // Generera ett slumpmässigt heltal mellan 1 och 100
            int ran = random.nextInt(100) + 1; // om man inte lägger till + 1 blir det mellan 0-99

            System.out.println("Talet som vann är: " + ran);

            if (choice == ran) {
                System.out.println("Du vann!! Grattis!!");
            } else {
                System.out.println("Tyvärr vann du inte");
            }
            
            saldoNu = (saldoNu - 50);
            System.out.println("Ditt saldo är nu: " + saldoNu);

            System.out.println("Vill du försöka en gång till?");
            System.out.println("1. Ja");
            System.out.println("2. Nej");
            System.out.print("Ange ditt val (1 eller 2): ");

            int val = scanner.nextInt();
            if (val == 2) {
                // Användaren vill inte fortsätta - 
            	// här skulle jag vilja komma tillbaka till första "menyn" - Hur??
            	// Börja med att fråga om hen vill spela Roulette och gå dit
                fortsattSpela = false;
                System.out.println("Vill du spela Roulette?");
                System.out.println("1. Ja");
                System.out.println("2. Nej");
                System.out.print("Ange ditt val (1 eller 2): ");
                
                int newchoice = scanner.nextInt();
                
                switch (newchoice) {
                case 1:
                	roulette.bet();
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
