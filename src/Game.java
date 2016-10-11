
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

	Scanner reader = new Scanner(System.in);
	ArrayList<String> colourBank = new ArrayList<String>();
	Random rand = new Random();	
	String[] masterCode = new String[4];
	String[] userGuess = new String[4];
	String userInput;
	int turnCounter;
	int xCounter = 0;
	boolean gameOver = false;
	
	public Game()
	{
		while(!gameOver)
		{
		
		System.out.println("\nBreak My Code!\n");
		System.out.println("Pick 4 of the correct colours in the right order! I will provide you with clues!");
		this.fillColourBank();
		this.generateMasterCode();
		turnCounter = 1;
//		this.showCode();
		
		
		while (turnCounter < 11)
		{	
			if(turnCounter == 10)
			{
			System.out.println("\nFINAL TURN");
			} else
			{
			System.out.println("\nTURN " + turnCounter);
			}
			this.promptUser();
			this.analyseGuess();
			if (xCounter == 4)
			{
				System.out.println("\nYOU WIN!\n");
				this.showCode();
				gameOver = true;
				break;
			}
			xCounter = 0;
			
		}
		if (turnCounter > 10)
		{
		System.out.println("\nYou Lose!\n");
		this.showCode();
		gameOver = true;
		}
		}
	}
	
	
	public void generateMasterCode()
	{
		
		int colourIndex;
		
		for (int i = 0; i < 4; i++)
		{
//			System.out.println("size:" + colourBank.size());
			colourIndex = rand.nextInt(colourBank.size())  + 0;
//			System.out.println("number: " + colourIndex);
			masterCode[i]= colourBank.get(colourIndex);
//			System.out.println("Colour Inserted into Code");
			colourBank.remove(colourIndex);
//			System.out.println("Colour Removed from Bank");
			
			
			
		}
		
	}
	
	public void fillColourBank()
	{
		colourBank.add("green");
		colourBank.add("blue");
		colourBank.add("red");
		colourBank.add("yellow");
		colourBank.add("black");
		colourBank.add("orange");
		colourBank.add("pink");
		colourBank.add("purple");
		colourBank.add("brown");
		
	}
	

	
	public void showCode()
	{
	
		for(int i = 0; i < 4; i++)
		{
		System.out.println(masterCode[i] + " ");	
		
		}
	}
	
	public void showBank()
	{
		
		for (int i = 0; i < colourBank.size(); i++)
		{
			System.out.println(colourBank.get(i));
		}
	}
	
	
	
	public void promptUser() 	{
		
		System.out.println("\nAttempt to break code:\n");
		for(int i = 0; i < userGuess.length; i++)
		{
			
			userGuess[i] = reader.next();
		}
		
//		for(int i = 0; i < userGuess.length; i++)
//		{
//			
//			System.out.println(userGuess[i]);
//		}
		
	turnCounter++;		
	
	}
	
	public void analyseGuess()	{
		
	    int ignored = 5;
		System.out.println("\nanalysing Guess\n");
		
		for (int i = 0; i < userGuess.length; i++)
		{
			if(userGuess[i].equals(masterCode[i]))
				{
				System.out.println("x");
				ignored = i;
				xCounter++;
				if (xCounter == 4)
				{
					
					break;
				}
				
				}
			
			for (int j = 0; j < masterCode.length; j++)
			{
				if (j == ignored)
				{
					continue;
				}
				else if(userGuess[i].equals(masterCode[j]))
				{
					System.out.println("^");
				}
			}
		}
		
	}
}
