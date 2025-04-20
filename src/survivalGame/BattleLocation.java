package survivalGame;

public abstract class BattleLocation extends Location {

	protected Obstacle obstacle; // Enemy
	protected String award; // For winnning game collect this one all

	protected BattleLocation(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {

		int obsCount = obstacle.obstacleCount();

		System.out.println("You are in the " + this.getName());
		System.out.println("Be careful, there are " + obsCount + " " + obstacle.getName() + " here.");
		System.out.println("<B>attle or R<un>");

		String selCase = Game.scan.nextLine();
		selCase = selCase.toUpperCase();

		if (selCase.equals("B")) {

			if (combat(obsCount)) {
				System.out.println(this.getName() + " Area " + "You Are Killed All Obstacles !!!");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Collecting...");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Collecting...");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Collecting...");
					player.getInv().setFirewood(true);
				}
				return true;
			} else if (selCase.equals("R")) {
			    System.out.println("You ran away from the battle.");
			    return true; 
			} else {
			    System.out.println("Invalid input. You lost your chance.");
			    return false; 
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealthy();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealthy() > 0) {
				System.out.println();
				System.out.print("<A>ttack or R<un>");

				String selCase = Game.scan.nextLine();
				selCase = selCase.toUpperCase();

				if (selCase.equals("A")) {
					System.out.println();
					System.out.println("<====================>");
					System.out.println("You hitted " + obstacle.getName());
					obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());

					afterBattleStats();

					System.out.println("<====================>");
					if (obstacle.getHealthy() > 0) {
						System.out.println();
						System.out.println(obstacle.getName() + " Hitted You");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterBattleStats();
					}

				} else {
					break;
				}
			}

			if (obstacle.getHealthy() < player.getHealthy()) {
				System.out.println("You Killed  " + obstacle.getName());
				player.setMoney(player.getMoney() + obstacle.getKillAward());
				System.out.println("Your Award : " + obstacle.getKillAward());
				System.out.println("You Have " + player.getMoney() + "$");
				obstacle.setHealthy(defObsHealth);
			} else {
				return false;
			}
			System.out.println("<====================>");
		}
		return true;
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Player Statistics");
		System.out.println("<====================>");

		System.out.println("Healthy : " + player.getHealthy());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Money : " + player.getMoney());

		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon : " + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor : " + player.getInv().getArmorName());
		}

	}

	public void enemyStats() {
		System.out.println();
		System.out.println(obstacle.getName() + " Statistics ");
		System.out.println("<====================>");

		System.out.println("Healthy : " + obstacle.getHealthy());
		System.out.println("Damage : " + obstacle.getDamage());
		System.out.println("Award : " + obstacle.getKillAward());

	}

	public void afterBattleStats() {
		System.out.println();
		System.out.println("Your Healthy :" + player.getHealthy());
		System.out.println(obstacle.getName() + " Healthy : " + obstacle.getHealthy());
		System.out.println();
	}
}
