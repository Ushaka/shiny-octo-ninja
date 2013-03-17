package theGame;

public class Weapon extends Item {
	
	private int damage;

	public Weapon(String name, String description, int value, String action, int damage) {
		super(name, description, value, action);
		this.setDamage(damage);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	

}
