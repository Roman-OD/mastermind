

public class Player {

	
	String name;
	int score;
	String currentRank;
	String[] ranks = { "Filthy Peasant", 
	                   "Village Noble", 
	                   "Hey, not bad guy",
	                   "Master Tactician",
	                   "Village King" };
	
	
	
	public Player(String n){
		name = n;
		score = 0;
		currentRank = ranks[0];
	}
	
	
	public void showStats()
	{
		System.out.println(name);
		System.out.println("Villagers Saved: " + score);
		System.out.println("Rank: " + currentRank);
		
	}
}
