package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the amount of money you are starting with:");
		double startAmount = in.nextDouble();

		System.out.print("Enter the probabillity you win a single play:");
		double winChance = in.nextDouble();

		System.out.print("Enter the amount of money you reach to have a successful day:");
		double winLimit = in.nextDouble();

		System.out.print("Enter the number of days to simulate:");
		int totalSimulations = in.nextInt();

		int numWins = 0;
		int numRuins = 0;

		for (int i = 0; i < totalSimulations; i++) {
			double newAmount = startAmount;

			while (newAmount < winLimit && newAmount > 0) {
				double playRound = Math.random();

				if (playRound <= winChance) {
					newAmount++;
				}
				else {
					newAmount--;

				}

			}
			if(newAmount == winLimit) {
				System.out.println("Success "+i+" Day");
				numWins++;
			}

			else if (newAmount == 0) {
				System.out.println("Ruin "+i+" Day");
				numRuins++;


			}
			System.out.println("Daily balance: " + newAmount);
			
			

		}	
		
		System.out.println("Loses: "+numRuins+ ": " + totalSimulations);
		double ruinRate = (double)numRuins/(double)totalSimulations;
		
		double expectedRuin = 0.0;
		if(winChance == 0.5) {
			expectedRuin = 1-(startAmount/winLimit);
			
		}
		else {
			double a = (1-winChance)/winChance;
			expectedRuin = (Math.pow(a,startAmount) - Math.pow(a,winLimit))/1-Math.pow(a,winLimit);
		}
			
	
		
		System.out.println("Ruin rate from simulation: " + ruinRate + "Expected ruin rate: "+ expectedRuin);
		
		
	}



}




