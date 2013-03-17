package theGame;

import java.util.HashMap;
import java.util.Random;

public class Player {
	private Random randomGenerator;
	private String name;
	private String type;
	private int health;
	private int gold;
	private int minDamage;
	private int maxDamage;
	private HashMap<String, Item> items;
	private Weapon weapon;
	

	public Player(String name, String type, int minDamage, int maxDamage){
		setName(name);
		setType(type);
		setMinDamage(minDamage);
		setMaxDamage(maxDamage);
		gold = 500;
		health = 100; 
		items = new HashMap<String, Item>();
		randomGenerator = new Random();
	}
	
	public void equipWeapon(String searchString){
		Item item = findItem(searchString);
		if(item instanceof Weapon){
			weapon = (Weapon)item;
		}else
			System.out.println("This is not a weapon, try again!");
	}
	
	public int attack(){
		int attack = randomGenerator.nextInt(maxDamage - minDamage + 1) + minDamage;
		if(weapon != null){
			return attack + weapon.getDamage();
		}else{
			return attack;
		}
		
	}
	
    public void run(){
        System.out.println("You run over the hills and far far away!");
        
        //If the player has enough gold to lose 50 gold.
        if(getGold() >= 50){
            changeGold(-50);
            System.out.println("You lose 50 gold in the process." + "You now have " + getGold() + " left.");
        }
   
        //If the player is broke
        else if(getGold() == 0){
            System.out.println("Fortunately you don't have any gold to lose.");
        }    
   
        //If he has some gold but not 50 he loses all
        else{
            int goldLeft = getGold();
            changeGold(-goldLeft);
            System.out.println("You did not have enough gold, you lose the " + goldLeft +  " you had left.");
        }
     }
	
	public int instaGib(){
		changeHealth(-999);
		return health;
	}

	public void addItem(String name, Item item){
		items.put(name, item);
	}

	public Item findItem(String itemName){
		Item i = items.get(itemName);
		if(i != null){
			return i;
		}else{
			System.out.println(itemName + " was not found!");
			return null;
		}
	}

	public boolean sellItem(String itemName){
		try{
			Item i = findItem(itemName);
			System.out.println("Your item has been sold for " + i.getValue() + " gold.");
			gold += i.getValue();
			items.remove(i);
			return true;

		}
		catch(NullPointerException e){
			System.out.println("Your item has not been found!");
			return false;
		}
	}

	public boolean useItem(String itemName){
		try{
			Item i = findItem(itemName);
			items.remove(i);
			System.out.println(name + " " + i.getAction() + " the " + i.getName() + ".");
			return true;
		}
		catch(NullPointerException e){
			System.out.println("Your item has not been found!");
			return false;
		}
	}

	public void changeHealth(int value){
		health += value;
		health = Utils.intTest(health);
	}
	
	public int getGold() {
		return gold;
	}

	public void changeGold(int value){
		gold+= value;
		gold = Utils.intTest(gold);
	}

	public boolean isAlive() {
		if (health > 0){
			return true;
		}else{
			return false;
		}
	}

	public String toString() {
		String playerString = "***" + name + "***" + "\n";
		playerString += "Type: " + type + "\n";
		playerString += "Health: " + health + "\n";
		playerString += "Gold: " + gold + "\n";
		playerString += "" + "\n";
		playerString += "Contents of" + " " + name + "`s backpack:" + "\n";
		playerString += "" + "\n";


		for(Item i : items.values() ){
			playerString += i.toString();
		}
		return playerString;
	}

	public void print(){
		System.out.println(toString());
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Utils.stringTest(name);
	}

	public String getType() {
		return type;
	}

	public void setType(String lowerType) {
		String newType = lowerType.toLowerCase();
		if(newType.equals ("warrior") || newType.equals("mage") || newType.equals("rogue") || newType.equals("hunter)")){
			type = newType;
		}else{
			type = "Unspecified";
		}
	}

	public int getHealth() {

		return health;
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
