package survivalGame;

public class SafeHouse extends NormalLocation {

	SafeHouse(Player player) {
		super(player, "Safe House");
	}

	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println();
		System.out.println("                           (   )\r\n"
				+ "                          (    )\r\n"
				+ "                           (    )\r\n"
				+ "                          (    )\r\n"
				+ "                            )  )\r\n"
				+ "                           (  (                  /\\\r\n"
				+ "                            (_)                 /  \\  /\\\r\n"
				+ "                    ________[_]________      /\\/    \\/  \\\r\n"
				+ "           /\\      /\\        ______    \\    /   /\\/\\  /\\/\\\r\n"
				+ "          /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\\r\n"
				+ "   /\\    / /\\/\\  //___\\       \\__/  \\    \\/\r\n"
				+ "  /  \\  /\\/    \\//_____\\       \\ |[]|     \\\r\n"
				+ " /\\/\\/\\/       //_______\\       \\|__|      \\\r\n"
				+ "/      \\      /XXXXXXXXXX\\                  \\\r\n"
				+ "        \\    /_I_II  I__I_\\__________________\\\r\n"
				+ "               I_I|  I__I_____[]_|_[]_____I\r\n"
				+ "               I_II  I__I_____[]_|_[]_____I\r\n"
				+ "               I II__I  I     XXXXXXX     I\r\n"
				+ "            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println("You Are In Safe House ");     
		System.out.println("Your Healthy Is Max +++ "); 
		return true;
	}
}
