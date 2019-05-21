import java.util.*;
import java.io.*;
import javax.swing.*;
public class LaserGame implements LaserGameInterface {
	
	public LaserGame() {//constructor
		
	}
	
	public boolean Pshoot() {//does a shoot animation or message and returns positive if the player shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
		return true;
	}
	
	public boolean Preload() {//does a reload animation or message and returns positive if the player reloaded this turn, also calls ammo and increases by 1
		return true;
	}
	
	public boolean Pblock() {//does a shield animation or message and returns positive if the player shileded this turn
		return true;
	}
	
	public boolean Palive() {//does all the logic to figure out if the player dies this turn
		return true;
	}
	
	public boolean Cshoot() {//does a shoot animation or message and returns positive if the computer shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
		return true;
	}
	
	public boolean Creload() {//does a reload animation or message and returns positive if the computer reloaded this turn, also calls ammo and increases by 1
		return true;
	}
	
	public boolean Cblock() {//does a shield animation or message and returns positive if the computer shileded this turn
		return true;
	}
	
	public boolean Calive() {//does all the logic to figure out if the player or computer dies this turn
		return true;
	}
	
	public int Pammo() {//keeps a count of the ammo the player
		return 0;
	}
	
	public int Cammo() {//keeps a count of the computer ammo
	return 0;
	}
	
	public void menu() {//outputs nice prompts to let the player choose what they want to do each turn and guides the turns consecutively, calling all the correct methods in order
		JOptionPane.showMessageDialog( null, "Welcome to Laser Battle!!!" );
		JOptionPane.showMessageDialog( null, "You and your opponent (the computer) has the choice to reload, shoot, or block every turn... choose wisely!" );
		Scanner cin = new Scanner(System.in);
		int check = 0;
		char choice = ' ';
		while (Palive()==true||Calive()==true) {
			do {
			System.out.println("Enter 's' for shoot, 'r' for reload, and 'b' for block");
			choice = cin.next().charAt(0);
			if (choice == 's') {
				Pshoot();
			}
			if (choice == 'r') {
				Preload();
			}
			if (choice == 'b') {
				Pblock();
			}
				
			
			} while (choice == 's'||choice == 'r'||choice == 'b');
			
		}
	}
	
	public void win() {//win screen if the computer dies
	
	}
	
	public void lose() {//lose screen if the player dies
	
	}
	
	public int bot() {//randomly chooses what the bot should do, won't shoot if it doesn't have ammo
		return 0;
	
	}
	
	public void sound() {//plays a shooting sound that will be called when the player or computer shoots
	
	}
	

}
