package fk;

import java.util.Scanner;

import fk.Player;

public class WheelOfFortuneUseCase {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in); // Skapar en Scanner-instans för att läsa in
        
        // Fråga efter spelarens namn
        System.out.print("Ange ditt namn: ");
        String playerName = scanner.nextLine();
        
        // Fråga efter spelarens saldo
        System.out.print("Ange ditt saldo: ");
        double playerSaldo = scanner.nextDouble();
        scanner.nextLine(); // Rensa radbrytning från inmatningsbufferten

        // Skapa spelarinstans med det angivna namnet och saldot
        Player player = new Player(playerName, playerSaldo);
        
        // Skapa en instans av WheelOfFortune-klassen
        WheelOfFortune wheel = new WheelOfFortune(); 
        // Skapa en instans av Roulette-klassen
        Roulette roulette = new Roulette();  

        // Menyn
        System.out.println("Välkommen till vårt casino!");
        System.out.println("Vilket spel vill du spela?");
        System.out.println("1. Wheel of Fortune");
        System.out.println("2. Roulette");
        System.out.print("Ange ditt val (1 eller 2): ");

        int gameChoice = scanner.nextInt();

        // Rensa radbrytning från inmatningsbufferten
        scanner.nextLine();

        switch (gameChoice) {
            case 1:
                // Anropa spin() 
                wheel.spin(player);
                break;
            case 2:
                // Anropa bet()
                roulette.bet(player);
                break;
            default:
                System.out.println("Ogiltigt val!");
                break;
        }

        // Stäng Scanner-objektet
        scanner.close();
    }
}