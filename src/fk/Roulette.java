package fk;

import java.util.Scanner;
import java.util.Random;

public class Roulette {
	public void bet(Player player) {

		Scanner scanner = new Scanner(System.in); // Scanner-instans för att läsa in
		Random random = new Random(); // Skapa en instans av Random-klassen
		double saldoNu = player.getSaldo(); // Hämta spelarens saldo
		boolean fortsattSpela = true;
		WheelOfFortune wheel = new WheelOfFortune(); // Skapa en instans av WheelOfFortune-klassen
		String vald;


		// Implementera logiken för att placera insatsen

		while (fortsattSpela) {  // Loop tills användaren väljer att avsluta
			System.out.println("Välj en färg, svart eller rött");
			System.out.println("1. Svart");
			System.out.println("2. Rött");
			System.out.print("Ange ditt val (1 eller 2): ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				vald = "Svart";
			case 2:
				vald = "Rött";


				// Rensa radbrytning från inmatningsbufferten
				scanner.nextLine();

				System.out.println("Du har valt " + vald);
				System.out.println("Insatsen placeras på roulettbordet");
				System.out.println("Hjulet snurrar");

				// Slumpmässigt generera ett heltal mellan 0 och 1 (inklusive)
				int colorNumber = random.nextInt(2) + 1; // 1 för svart, 2 för rött

				// Ange färg för att kunna skriva ut i text			
				String color;
				if (colorNumber == 1) {
					color = "svart";
				} else { 
					color = "rött";
				}
				System.out.println("Kulan stannade på " + color);

				// Kolla om det är vinst eller inte

				if (choice == colorNumber) {
					player.deposit(100);
					System.out.println("Du vann!! Grattis!!");
				} else {
					player.withdraw(50);
					System.out.println("Tyvärr vann du inte denna gång");
				}
				saldoNu = player.getSaldo();
				System.out.println("Ditt saldo är nu: " + saldoNu);

				// Här kollas om den ska köras en gång till
				System.out.println("Vill du försöka en gång till?");
				System.out.println("1. Ja");
				System.out.println("2. Nej");
				System.out.print("Ange ditt val (1 eller 2): ");

				int val = scanner.nextInt();
				if (val == 2) {

					fortsattSpela = false;
					System.out.println("Vill du spela Wheel of fortune?");
					System.out.println("1. Ja");
					System.out.println("2. Nej");
					System.out.print("Ange ditt val (1 eller 2): ");

					int newchoice = scanner.nextInt();

					switch (newchoice) {
					case 1:
						wheel.spin(player);
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
			
		}
		
		// Stäng Scanner-objektet
					scanner.close();
	}
}

