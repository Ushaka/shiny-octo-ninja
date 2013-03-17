package theGame;

public class Item {
	private String name;
	private String description;
	private int value;
	private String action;
	
	public Item(String name, String description, int value, String action){
		setName(name);
		setDescription(description);
		setValue(value);
		setAction(action);
	}
	
	public String toString(){
	        String itemString = "***" + name + "***" + "\n";
	        itemString += "Description: " + description + "\n";
	        itemString += "Action: " + action + "\n";
	        itemString += "Value: " + value + "\n";
	        itemString += "\n";
	        
	        return itemString;
	    }
	    
	public void print(){
		System.out.println(toString());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = Utils.stringTest(name);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = Utils.stringTest(description);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = Utils.intTest(value);
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = Utils.stringTest(action);
	}
}
