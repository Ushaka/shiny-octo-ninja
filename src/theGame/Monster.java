package theGame;

import java.util.Random;

public class Monster {
	private Random randomGenerator;
	private String name;
	private int health;
	private int gold;
	private int minDamage;
	private int maxDamage;

	public Monster(String name, int minDamage, int maxDamage){
		setName(name);
		setMinDamage(minDamage);
		setMaxDamage(maxDamage);
		gold = 500;
		health = 245;
		randomGenerator = new Random();
	}
	
	public int attack(){
		return randomGenerator.nextInt(maxDamage - minDamage + 1) + minDamage;
	}
	
	public boolean isAlive() {
		if (health > 0){
			return true;
		}else{
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Utils.stringTest(name);
	}

	public int getHealth() {
		return health;
	}

	public void changeHealth(int value){
		health += value;
		health = Utils.intTest(health);
	}
	
	public void changeGold(int value){
		health+= value;
		health = Utils.intTest(gold);
	}

	public int getGold() {
		return gold;
	}
	
	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
}
