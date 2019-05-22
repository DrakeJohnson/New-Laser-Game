

public interface LaserGameInterface {
	/*
	 Shoot
	 Reload
	 Shield
	 Checks if alive
	 Checks if they have "energy"
	 Menu/interface
	 Win screen
	 Lose screen
	 bot choose
	 difficulty choosing
	 "attack" sound
	 */
	public boolean Pshoot();//does a shoot animation or message and returns positive if the player shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
	public boolean Preload();//does a reload animation or message and returns positive if the player reloaded this turn, also calls ammo and increases by 1
	public boolean Pblock();//does a shield animation or message and returns positive if the player shileded this turn
	public boolean Palive();//does all the logic to figure out if the player dies this turn
	public boolean Cshoot();//does a shoot animation or message and returns positive if the computer shot this turn also checks if there is ammo and reduces it by 1 if it successfuly shoots
	public boolean Creload();//does a reload animation or message and returns positive if the computer reloaded this turn, also calls ammo and increases by 1
	public boolean Cblock();//does a shield animation or message and returns positive if the computer shileded this turn
	public boolean Calive();//does all the logic to figure out if the player or computer dies this turn
	public int Pammo();//keeps a count of the ammo the player
	public int Cammo();//keeps a count of the computer ammo
	public void menu();//outputs nice prompts to let the player choose what they want to do each turn and guides the turns consecutively, calling all the correct methods in order
	public void win();//win screen if the computer dies
	public void lose();//lose screen if the player dies
	public void draw();//draw screen if both die
	public void bot();//randomly chooses what the bot should do, won't shoot if it doesn't have ammo
	public void sound();//plays a shooting sound that will be called when the player or computer shoots

}
