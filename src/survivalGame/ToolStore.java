package survivalGame;

public class ToolStore extends NormalLocation {

	ToolStore(Player player) {
		super(player, "Store");
	}

	public boolean getLocation() {
		System.out.println("Money : " + player.getMoney());
		System.out.println("1 => Weapons");
		System.out.println("2 => Armors");
		System.out.println("3 => Exit Store");

		System.out.println("Select Your Choice : ");
		int selTool = scan.nextInt();
		int selectItemId;
		switch (selTool) {
		case 1:
			selectItemId = weaponMenu();
			buyWeapon(selectItemId);
			break;
		case 2:
			selectItemId = armorMenu();
			buyArmor(selectItemId);
			break;
		case 3:

			break;
		default:
			break;
		}
		return true;
	}

	public int armorMenu() {
		System.out.println("1 => Light Armor   <Price : 15$ , Damage : 1> ");
		System.out.println("2 => Medium Armor  <Price : 25$ , Damage : 3> ");
		System.out.println("3 => Heavy Armor   <Price : 40$ , Damage : 5> ");
		System.out.println("4 => Go To Back");
		System.out.println("Select Armor ");
		int selWeaponId = scan.nextInt();
		return selWeaponId;
	}

	public void buyArmor(int itemId) {
		int avoid = 0, price = 0;
		String armorName = null;
		switch (itemId) {
		case 1:
			avoid = 1;
			armorName = "Light Armor";
			price = 15;
			break;

		case 2:
			avoid = 3;
			armorName = "Medium Armor";
			price = 25;
			break;
		case 3:
			avoid = 5;
			armorName = "Heavy Armor";
			price = 40;
			break;
		case 4:
			System.out.println("Exiting Store ...");
			break;
		default:
			System.out.println("Wrong Input !");
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setArmorName(armorName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You just bought " + armorName + "! Time to show them who's boss!");
				System.out.println("Avoided Damage upgraded : " + player.getInv().getArmor());
			} else {
				System.out.println("You don't have enough money!");
				System.out.println("Come back when you're richer!");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1 => Pistol  <Price : 25$ , Damage : 2> ");
		System.out.println("2 => Sword   <Price : 35$ , Damage : 3> ");
		System.out.println("3 => Rifle   <Price : 45$ , Damage : 7> ");
		System.out.println("4 => Go To Back");
		System.out.println("Select Weapon ");
		int selWeaponId = scan.nextInt();
		return selWeaponId;
	}

	public void buyWeapon(int itemId) {
		int damage = 0, price = 0;
		String weaponName = null;
		switch (itemId) {
		case 1:
			damage = 2;
			weaponName = "Pistol";
			price = 5;
			break;

		case 2:
			damage = 3;
			weaponName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			weaponName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Exiting Store ...");
			break;
		default:
			System.out.println("Wrong Input !");
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(weaponName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You just bought " + weaponName + "! Time to show them who's boss!");
				System.out.println("Damage upgraded: " + player.getDamage() + " ➜ " + player.getTotalDamage());
			} else {
				System.out.println("You don't have enough money!");
				System.out.println("Come back when you're richer!");
			}
		}

	}

}
