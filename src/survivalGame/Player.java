package survivalGame;


import java.util.Scanner;

public class Player {
	private int damage, healthy, money,rHealthy;
	private String userName, avatarName;
	private Inventory inv;
	
	Scanner scan = new Scanner(System.in);
	public Player(String userName) {

		this.userName = userName;
	}

	public void selectAvatar() {
		switch (avatarMenu()) {
		case 1: {
			initPlayer("Samurai", 5, 21, 5);
			break;
		}
		case 2: {
			initPlayer("Archer", 7, 18, 20);
			break;
		}
		case 3: {
			initPlayer("Knight", 8, 24, 5);
			break;
		}
		default:{
			initPlayer("Samurai", 5, 21, 5);
			break;
		}
		}
		System.out.println("Your Avatar Specifications => "+"\r Avatar Name : " + getAvatarName() + "\r Damage : " + getDamage() + " \r Healthy : " +getHealthy() + "\r Money : " + getMoney());
	}

	public int avatarMenu() {
		System.out.println("<======== Select Your Avatar ========> ");
		System.out.println("                     ______");
		System.out.println("                  .-\"      \"-.");
		System.out.println("                 /            \\");
		System.out.println("                |              |");
		System.out.println("                |,  .-.  .-.  ,|");
		System.out.println("                | )(__/  \\__)( |");
		System.out.println("                |/     /\\     \\|");
		System.out.println("      (@_       (_     ^^     _)");
		System.out.println(" _     ) \\_______\\__|IIIIII|__/__________________");
		System.out.println("(_)@8@8{}<________|-\\IIIIII/-|___________________>");
		System.out.println("       )_/        \\          /");
		System.out.println("      (@           `--------`");
		System.out.println("");
		System.out.println("1 - Samurai => Healthy:21 , Damage:5  , Money:5");
		System.out.println("2 - Archer  => Healthy:18 , Damage:7  , Money:20");
		System.out.println("3 - Knight  => Healthy:24 , Damage:8  , Money:5");
		System.out.println("<======== =========================== ========> ");
		System.out.print("Your Select : ");
		int avatarId = scan.nextInt();
		while(avatarId <1|| avatarId>3) {
			System.out.println("Wrong Input :/ ");
			System.out.print("Your Select : ");
			avatarId = scan.nextInt();

		}
		return avatarId;
		}

	public void initPlayer(String avtName,int dmg,int hlt , int money)
	{
		setAvatarName(avtName);
		setDamage(dmg);
		setHealthy(hlt);
		setMoney(money);
		setrHealthy(hlt);
	}	
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	
	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	
	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	

}
