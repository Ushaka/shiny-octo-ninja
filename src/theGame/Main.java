package theGame;

import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player("Marius", "Warrior", 50, 100);
		Item i = new Item("Swordfish", "A fish with a sword", 300, "swings");
		p.addItem("Swordfish", i);
		Item o = new Item("Potion", "A healthy drink", 400, "drinks");
		p.addItem("Potion", o);
		
		Monster dragon = new Monster("Dragon", 20, 30);
		Monster wolf = new Monster("Wolf", 15, 35);
		ArrayList <Monster> monsters = new ArrayList<Monster>();
		monsters.add(dragon);
		monsters.add(wolf);
		
		Battleground b = new Battleground(monsters, p);		
		b.runGame();

	}

}
