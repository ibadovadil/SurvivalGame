package survivalGame;

import java.util.Random;

public class Obstacle {
	private String name;
	private int damage, killAward, healthy, maxCount;

	public Obstacle(String name, int damage, int killAward, int healthy, int maxCount) {
		this.name = name;
		this.damage = damage;
		this.killAward = killAward;
		this.healthy = healthy;
		this.maxCount = maxCount;
	}

	public int obstacleCount() {
		Random r = new Random();
		return r.nextInt(this.maxCount) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getKillAward() {
		return killAward;
	}

	public void setKillAward(int killAward) {
		this.killAward = killAward;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

}
