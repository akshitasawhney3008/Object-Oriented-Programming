package game;

import java.util.ArrayList;

public class Weapon {
	private int strength;
	protected String name;
	public Weapon(String name)
	{
		this.name=name;
	}

	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public boolean battle(ArrayList<Weapon> list_of_weapon){
		Weapon w1= list_of_weapon.get(0);
		Weapon w2= list_of_weapon.get(1);
		if(w1.strength>w2.strength)
			{	return true;
			}
		else
			{
				return false;
			}
	}
	
}
