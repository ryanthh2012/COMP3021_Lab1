import java.util.Scanner;
import java.util.Random;

public class Game {
	public static int sum;
	public static int totalRound = 0;
	public static int correct = 0;
	
	public static int printAndCheck(int answer){
		if (answer == sum){
			correct++;
			System.out.println("You have answered correctly!");
		}
		else if (answer > sum){
			System.out.println("You have answered wrongly! You answer is too big!");
		}
		else {
			System.out.println("You have answered wrongly! You answer is too small!");
		}
		return 0;
	}
	
	public static void printEnding(){
		System.out.println("You have answered " + correct + " question(s) correct out of " + totalRound);
		System.out.println("You have got a score of " + (int)(((float)correct/totalRound)*100));
	}
	
	public static void main(String[] args){
		int input;
		int play = 1;
		String choice;
		int valueA;
		int valueB;
		final int MAXROUND = 3;
		
		Scanner reader = new Scanner(System.in);
		Random rand = new Random();
		
		while ((totalRound < MAXROUND) && (play == 1)){
			valueA = rand.nextInt(10) % 10;
			valueB = rand.nextInt(10) % 10;
			sum = valueA + valueB;
			
			System.out.print("What is the sum of " + valueA + "+" + valueB + "?");
			input = reader.nextInt();
			
			printAndCheck(input);
			
			totalRound++;
			if (totalRound < MAXROUND){
				System.out.print("Do you want to play again? (Y/N) ");
				choice = reader.next();
				if (!choice.startsWith("Y")&&!choice.startsWith("y")){
					play = 0;
				}
			}
		}
		
		printEnding();
		
	}
}
