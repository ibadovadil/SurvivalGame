package survivalGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;

    public static final Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("---------- Welcome Survival Game! ----------");
		System.out.print("Please Enter Your Name :  ");

		// String userName = scan.nextLine();
		player = new Player("a");
		player.selectAvatar();
		start();

	}

	public void start() {
	while (true) {
		System.out.println();
		System.out.println("<==============================>");
		System.out.println();
		System.out.print("Select Your Way :");
		System.out.println();
		System.out.println("1 => Safe House: Your home. No enemies.");
		System.out.println("2 => Cave: You often face zombies.");
		System.out.println("3 => Forest House: You often face vampires.");
		System.out.println("4 => River: You often face bears.");
		System.out.println("5 => Market: Buy guns and shields.");

		System.out.print("Your Way To ");

		int selectLoc = scan.nextInt();
//	    scan.nextLine();
		while (selectLoc < 0 || selectLoc > 5) {
			System.out.println("Wrong Input !");

			System.out.print("Select Your Way :");
			selectLoc = scan.nextInt();
//			scan.nextLine();
		}

		switch (selectLoc) {
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
			break;
		}
		
		boolean result = location.getLocation();
		if(!result) {
			System.out.println("Game Ended");
			break;
		}
		location.getLocation();
		
			
	}
	}
}
