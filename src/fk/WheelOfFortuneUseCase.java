package fk;

import java.util.Scanner;

import fk.Roulette;
import fk.WheelOfFortune;

public class WheelOfFortuneUseCase {
public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in); // Skapar en Scanner-instans för att läsa in
        WheelOfFortune wheel = new WheelOfFortune(); // Skapa en instans av WheelOfFortune-klassen
        Roulette roulette = new Roulette();  // Skapa en instans av Roulette-klassen

        // Menyn
        System.out.println("Välkommen till vårt casino!");
        System.out.println("Vilket spel vill du spela idag?");
        System.out.println("1. Wheel of Fortune");
        System.out.println("2. Roulette");
        System.out.print("Ange ditt val (1 eller 2): ");

        int gameChoice = scanner.nextInt();

        // Rensa radbrytning från inmatningsbufferten
        scanner.nextLine();

        switch (gameChoice) {
            case 1:
                // Anropa spin() från WheelOfFortune-instansen
                wheel.spin();
                break;
            case 2:
                // Anropa bet() från Roulette-instansen
                roulette.bet();
                break;
            default:
                System.out.println("Ogiltigt val!");
                break;
        }

        // Stäng Scanner-objektet
        scanner.close();
    }
}
