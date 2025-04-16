package survivalGame;

public abstract class BattleLocation extends Location {

	Obstacle obstacle; // Enemy

	BattleLocation(Player player, Obstacle obstacle, String name) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
	}

	public boolean getLocation() {
		return true;
	}

}
