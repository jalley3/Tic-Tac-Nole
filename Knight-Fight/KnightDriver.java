import java.util.Random;
import java.util.Scanner;


public class KnightDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//intro and prompts
		System.out.println("Welcome to KnightFight");
		System.out.println("Enter Name");
		String name = scan.nextLine();
		System.out.printf("%n%nPlease Choose your weapon: ");
		System.out.printf("%n1. Longsword %n2. Warhammer %n3. Spear %n4. Battle Axe");
		int choice = scan.nextInt();
		Knight opponent;
		String weapon = null;
		//switch based on weapon selection
		switch (choice){
		case 1: weapon = "Long Sword";
			break;
		case 2: weapon = "Warhammer";
			break;
		case 3: weapon = "Spear";
			break;
		case 4: weapon = "Battle Axe";
			break;
		default: System.out.println("Invalid choice");
			break;
		}
		Knight player = new Knight(name, weapon); //construct knight
		System.out.println("Auto Generate Opponent? (Y/N)");
		String ag = scan.nextLine();
		ag = scan.nextLine(); //for some reason this only worked if i had this line twice
		if (ag.equals("y")){
			opponent = new Knight(); //randomize
		}
		else if (ag.equals("n")) //user builds opponent
		{ 
			System.out.println("Enter Name");
			String name2 = scan.nextLine();
			System.out.printf("%n%nPlease Choose your weapon: ");
			System.out.printf("%n1. Longsword %n2. Warhammer %n3. Spear %n4. Battle Axe");
			int choice2 = scan.nextInt();
			String weapon2 = null;
			switch (choice2){
			  case 1: weapon2 = "Longsword";
				break;
			  case 2: weapon2 = "Warhammer";
				break;
		   	  case 3: weapon2 = "Spear";
				break;
			  case 4: weapon2 = "Battle Axe";
				break;
			  default: System.out.println("Invalid choice");
			    break;
			}
			opponent = new Knight(name2, weapon2);
		}
		else 
		{
			System.out.println("Invalid Command");
			opponent = new Knight();
		}
		PrintSummary(player);
		PrintSummary(opponent);
		System.out.println("Press any key to continue");
		scan.nextLine();
		Random randomizer = new Random();
		int start = randomizer.nextInt(2); //determine who goes first
		int move = 0; //track number of moves
		int damage = 0; //track damage
		int damage2 = 0;
		//while both players have life, the fight will go on!
		while ((player.GetHealth() > 0) && (opponent.GetHealth()>0)){
			if (start == 0) //player goes first
				{
			    damage = player.Fight(opponent);
				start = 1;
				move ++;
				PrintResults(move, damage, damage2, start, player, opponent);
			  
			}
			else if (start == 1)
			{
				if (opponent.GetHealth() > 0){
				  damage2 = opponent.Fight(player);
				  start = 0;
				  move++;
				  PrintResults(move, damage, damage2, start, player, opponent);
					
				}
			}
		}
		//victory messages
		if (player.GetHealth() < 1){
			System.out.printf("%nGAH! You have been defeated!");
		}
		else if (opponent.GetHealth() < 1){
			System.out.printf("%nYES! VICTORIOUS. You have rid the earth of that scum!");
		}
		//prompt for restart
		System.out.printf("%n%ntype 'again' to restart");
		String end = scan.nextLine();
		end.toLowerCase();
		if (end.equals("again")){
			KnightDriver.main(null);
		scan.close(); //close scanner
		}
			
	}
	
	//a better formatted version of toString
	public static void PrintSummary (Knight k){
		  System.out.format("%nName             : ");
		  System.out.format("%s", k.GetName());
		  System.out.printf("%nHealth           : ");
		  System.out.format("%d", k.GetHealth());
		  System.out.format("%nWeapon           : ");
		  System.out.format("%s", k.GetWeapon());
		  System.out.format("%nArmor            : ");
		  System.out.format("%s%n", k.GetArmor());
	}
	
	/*
	 *  this function prints the summary of the round 
	 *  it checks who started and prints in the appropriate order
	 *  it also displays the amount of damage and the amount of health remaining
	 */
	public static void PrintResults (int move, int damage, int damage2, int start, Knight k, Knight opp)
	{
		if (move %2 == 0){
	
		if (start == 0){
		System.out.printf("%n%n%s did %d of damage to %s. Remaining Health: %d"
				,k.GetName(), damage, opp.GetName(), opp.GetHealth());
		   if (k.GetHealth()> 0)
			{
			   System.out.printf("%n%s did %d of damage to %s. Remaining Health: %d%n"
				,opp.GetName(), damage2, k.GetName(), k.GetHealth());
			}
		   else{
				System.out.printf("%n%s did %d of damage to %s. Remaining Health: 0"
						,opp.GetName(), damage2, k.GetName());
		   }
		}
		else if ((start == 1))
		  {
			System.out.printf("%n%n%s did %d of damage to %s. Remaining Health: %d"
			,opp.GetName(), damage2, k.GetName(), k.GetHealth());
			if (opp.GetHealth() > 0)
			{
				System.out.printf("%n%s did %d of damage to %s. Remaining Health: %d%n"
				,k.GetName(), damage, opp.GetName(), opp.GetHealth());
			}
			else {
				System.out.printf("%n%s did %d of damage to %s. Remaining Health: 0"
						,k.GetName(), damage, opp.GetName());
			}
		  }
		}
		else if ((start == 1) && (opp.GetHealth() < 1))
		{
			System.out.printf("%n%n%s did %d of damage to %s. Remaining Health: 0"
					,k.GetName(), damage, opp.GetName());
		}
		else if ((start == 0) && (k.GetHealth() < 1)){
			System.out.printf("%n%n%s did %d of damage to %s. Remaining Health: 0"
					,opp.GetName(), damage2, k.GetName());
		}
	}
}