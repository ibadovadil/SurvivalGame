package survivalGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Adventure Game!");
		System.out.println();
		System.out.println("Rules:");
		System.out.println("1. The Safe House fully restores your health.");
		System.out.println("2. You can buy necessary weapons and armors from the Store.");
		System.out.println("3. You will win the game after defeating all enemies, collecting all the awards (Water, Food, Firewood), and returning to the Safe House.");
		System.out.println();
		System.out.println("Before starting the game, please enter your name: ");
		
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=================================================");
			System.out.println();
			System.out.println("Select a location to perform an action: ");
			System.out.println("1. Safe House --> A safe place of your own, no enemies!");
			System.out.println("2. Cave --> You might encounter a zombie!");
			System.out.println("3. Forest --> You might encounter a vampire!");
			System.out.println("4. River --> You might encounter a bear!");
			System.out.println("5. Store --> You can buy weapons or armor!");
			System.out.print("Choose your destination: ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("Please choose a valid location: ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4:
					location = new River(player);
					break;
				case 5:
					location = new ToolStore(player);
					break;
				default:
					location = new SafeHouse(player);
			}

			if (location.getClass().getSimpleName().equals("SafeHouse")) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Congratulations! You have won the game!");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Game Over!");
				break;
			}
		}
	}
}
