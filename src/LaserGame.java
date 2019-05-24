import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;


public class LaserGame implements LaserGameInterface {
	boolean pshot, preloaded, pblocked, cshot, creloaded, cblocked;
	int Pammo, Cammo;
	
	public LaserGame() {//constructor
		pshot = false;
		preloaded = false;
		pblocked = false;
		cshot = false;
		creloaded = false;
		cblocked = false;
		Pammo = 0;
		Cammo = 0;
	} //   
	
	public void Pshoot() {//does a shoot animation or message and returns positive if the player shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
		System.out.println("Shoot");
		Pammo--;
		
		//Ascii for the weapon
		/*
		System.out.println("_,`__________________________________________,,,`");
		System.out.println("`      /  /  /  /      _  ___ ___ ___ ___ ___  ");
		System.out.println(" _ __ /  /  /  /  ____|___ ___ ___ ___ ___ __");
		System.out.println("/ --  --------   |                               ");
		System.out.println("| -- -------    |                                ");
		System.out.println("| ------------|                                  ");
		System.out.println("  /  /  / -- /");
		System.out.println(" /  /  / -- /");
		System.out.println("/  /  / -- /");
		System.out.println("|  -    -- |");
		System.out.println("------------");
		*/
		JOptionPane.showMessageDialog(null, "_,`__________________________________________,,,` \n"
				+ "`      /  /  /  /      _  ___ ___ ___ ___ ___   \n" 
				+ " _ __ /  /  /  /  ____|___ ___ ___ ___ ___ __ \n"
				+ "/ --  --------   |                                \n"
				+ "| -- -------    |                                 \n"
				+ "| ------------|                                   \n"
				+ "  /  /  / -- / \n"
				+ " /  /  / -- / \n"
				+ "/  /  / -- / \n"
				+ "|  -    -- | \n"
				+ "----------- \n");
		
		
		pshot = true;
	}
	
	public void Preload() {//does a reload animation or message and returns positive if the player reloaded this turn, also calls ammo and increases by 1
		System.out.println("Reload");
		
		JOptionPane.showMessageDialog(null, "Reloaded!");
		
		Pammo++;
		preloaded = true;
	}
	
	public void Pblock() {//does a shield animation or message and returns positive if the player shielded this turn
		System.out.println("Block");
		
		JOptionPane.showMessageDialog(null, "|------------------------------------| \n"
				+ "|                                                | \n"
				+ "|                                                | \n"
				+ "|                                                | \n"
				+ "|---                                        ---| \n"
				+ "    |---                                ---| \n"
				+ "        |---                        ---| \n"
				+ "            |---                ---| \n"
				+ "                |---        ---| \n"
				+ "                    |------| \n");
		
		pblocked = true;
	}
	
	public boolean Calive() {//does all the logic to figure out if the player dies this turn
		if (pshot == true && cblocked == false)
			return false;
		else
			return true;
	}
	
	public void Cshoot() {//does a shoot animation or message and returns positive if the computer shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
		System.out.println("AI shot");
		Cammo--;
		cshot = true;
	}
	
	public void Creload() {//does a reload animation or message and returns positive if the computer reloaded this turn, also calls ammo and increases by 1
		System.out.println("AI reloaded");
		Cammo++;
		creloaded = true;
	}
	
	public void Cblock() {//does a shield animation or message and returns positive if the computer shielded this turn
		System.out.println("AI blocked");
		cblocked = true;
	}
	
	public boolean Palive() {//does all the logic to figure out if the player or computer dies this turn
		if (cshot == true && pblocked == false)
			return false;
		else
			return true;
	}

	public void menu() {//outputs nice prompts to let the player choose what they want to do each turn and guides the turns consecutively, calling all the correct methods in order
		JOptionPane.showMessageDialog( null, "Welcome to Laser Battle!!!" );//a message box with this text appears welcoming the player
		JOptionPane.showMessageDialog( null, "You and your opponent (the AI) has the choice to reload, shoot, or block every turn... choose wisely!" );//another message box to explain how the game works
		Scanner cin = new Scanner(System.in);
		char choice = ' ';//player input to choose what action to do
		while (Palive()==true&&Calive()==true) {//main menu of the game, continues until somebody dies
			turnReset();
			do {//makes sure they choose an actual option
			System.out.println("Enter 's' for shoot, 'r' for reload, and 'b' for block");
			choice = cin.next().charAt(0);
			if (choice == 's') {
				if (Pammo==0) {
					System.out.println("You don't have any ammo try again");
				}
				else if (Pammo>0) {
				Pshoot();
				break;
				}
			}
			else if (choice == 'r') {
				Preload();
				break;
			}
			else if (choice == 'b') {
				Pblock();
				break;
			}
			else {
				System.out.println("Try again");
			}
			} while (choice != 's'||choice != 'r'||choice != 'b');
			bot();
			
		}//ends loop when someone dies
		if (Palive()==false&&Calive()==false) {//checks after someone dies if there was a draw
			draw();
		}
		else if (Palive()==false) {//checks for loss
			lose();
		}
		else if (Calive()==false) {//checks for win
			win();
		}
	}
	
	public void win() {//win screen if the computer dies
		JOptionPane.showMessageDialog( null, "You Win!!!!!!!" );
	}
	
	public void lose() {//lose screen if the player dies
		JOptionPane.showMessageDialog( null, "You Lose :(" );
	}
	
	public void bot() {//randomly chooses what the bot should do, won't shoot if it doesn't have ammo
		//System.out.println("Bot test");
		int choice;
		Random rand = new Random();
		choice = rand.nextInt(3);
		switch (choice) {
		case 0://shoots
			if (Cammo==0) {
				Creload();
			}
			else if (Cammo>0) {
				Cshoot();
			}
			break;
		case 1://reloads
			Creload();
			break;
		case 2://blocks
			Cblock();
			break;
		}
		}
	
	public void sound() {//plays a shooting sound that will be called when the player or computer shoots
		
	}

	public void draw() {
		JOptionPane.showMessageDialog( null, "Draw :/" );
	}

	
	public void turnReset() {
		pshot = false;
		preloaded = false;
		pblocked = false;
		cshot = false;
		creloaded = false;
		cblocked = false;
	}
	

}
