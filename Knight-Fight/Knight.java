import java.util.Random;

public class Knight {

	//private variables
  private String knightName;
  private int health;
  private String weapon;
  private String armor; 

  //default constructor with randomization
  Knight ()
  {
	Random randomizer = new Random();
	knightName = "Random Freddy";
	int min = 1;
	int max = 100;
	health = randomizer.nextInt(max-min+1)+min;
	int weaponTest = randomizer.nextInt(4);
	//tests for randomized weapon
	if (weaponTest == 0)
	{
		weapon = "Long Sword";		
	}
	if (weaponTest == 1){
		weapon = "Battle Axe";
	}
	if (weaponTest == 2){
		weapon = "Spear";
	}
	if (weaponTest == 3){
		weapon = "Warhammer";
	}
	int armorTest = randomizer.nextInt(2);
	if (armorTest == 0){
		armor = "Leather";
	}
	if (armorTest == 1){
		armor = "Steel";
	}
  }
  //user constructed class with parameters 
  Knight (String name, String stick)
  {
	Random randomizer = new Random();
	knightName = name;
	health = randomizer.nextInt(100) + 1;
	weapon = stick;
	int armorTest = randomizer.nextInt(2);
	if (armorTest == 0){
		armor = "Leather";
	}
	if (armorTest == 1){
		armor = "Steel";
	}
  }
  
  //getters and setters
  void SetName (String name){
	knightName = name;
  }
  void SetHealth (int hp){
	health = hp;
  }
  void SetWeapon (String stick){
	weapon = stick;
  }
  void SetArmor (String protect){
	armor = protect;
  }
  String GetName (){
	return knightName;
  }
  int GetHealth(){
	return health;
  }
  String GetWeapon() {
	return weapon;
  }
  String GetArmor(){
	return armor;
  }
  //to string method
 public String toString(){
	  return (knightName + health + weapon + armor);
  }
 //fight function
  int Fight(Knight k){
	 Random randomizer = new Random();
	 int damage = 0;
	 //randomize damage based on weapon
	 if (weapon.equals("Long Sword")){
		 damage = randomizer.nextInt(41) + 10;
	 }
	 else if (weapon.equals("Warhammer")){
		 damage = randomizer.nextInt(50) + 10;
	 }
	 else if (weapon.equals("Battle Axe")){
		 damage = randomizer.nextInt(11)+30;
	 }
	 else if (weapon.equals("Spear")){
		 damage = randomizer.nextInt(40) + 1;
	 }
	 //have armor affected by certain weapons
	 if ((k.armor.equals("Leather")) && (weapon.equals("Spear"))) {
		 damage = damage + 10;
	 }
	 if (k.armor.equals("Steel") && (weapon.equals("Warhammer"))){
		 damage = damage - 10;
	 }
	 //subtract damage from health to determine the new health
	 int newHealth = k.GetHealth() - damage;
	 k.SetHealth(newHealth);
	 return damage;
 }
}
