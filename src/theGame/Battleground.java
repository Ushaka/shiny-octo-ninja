package theGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Battleground {
	private ArrayList<Monster> monsters;
	private InputReader inputReader;
	private Monster currentMonster;
	private Player player;

	public Battleground(ArrayList<Monster> monsters, Player player){
		this.player = player;
		this.monsters = monsters;
		inputReader = new InputReader();
	}

	public void setCurrentMonster(){
		Random randomMonster = new Random();
		currentMonster = monsters.get(randomMonster.nextInt(monsters.size()));
		if(currentMonster.isAlive()==false){
			monsters.remove(currentMonster); //if a monster is dead, remove it from the list
			setCurrentMonster(); //sets a new monster that is alive
		}
	}

	public void runGame(){
		setCurrentMonster();
		System.out.println(player.getName() + " has entered the battleground.");
		System.out.println("A " + currentMonster.getName() + " has been chosen as the opponent!");
		while(!startGame()){
			startGame();
		}
	}

	public boolean startGame(){
		HashSet<String> input = inputReader.getInput();
		boolean finished = false;

		while(!finished){
			if(input.contains("attack")){
				if(player.isAlive()){
					int playerDamage = player.attack();
					currentMonster.changeHealth(-playerDamage);
					System.out.println(player.getName() + " attacks " + currentMonster.getName() + 
							" for " + playerDamage + " damage " + currentMonster.getName() + " has " + currentMonster.getHealth() + " left!");
					if(currentMonster.isAlive()){
						int monsterDamage = currentMonster.attack();
						player.changeHealth(-monsterDamage);
						System.out.println(currentMonster.getName() + " attacks " + player.getName() + 
								" for " + monsterDamage + " damage " + player.getName() + " has " + player.getHealth() + " left!");
						if(!player.isAlive()){
							System.out.println("You died, why so sad?");
							finished = true;
							return true;
						}
					}else{
						System.out.println("The monster died, sad story bro.");
						monsters.remove(currentMonster);
						setCurrentMonster();
					}

				}else{
					finished = true;
					System.out.println("You are already dead, revive and try again!");
					return true;
				}

			}else if(input.contains("run")){
				player.run();
				finished = true;
				return true;
			}

			return false;
		}

		return false;
	}
}
