import java.util.Scanner;

public class GuessANumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int win = 0, lose = 0, gamePlay = 0;
		String answerYesNo = "";
		
		//int randomNumber = 0 + (int) ( Math.random() * 10 );
		//System.out.printf("Random Number is: %d\n", randomNumber);
		System.out.print("Enter a number: ");
		int number = input.nextInt();		
		RandomNumber ranNumber = new RandomNumber();
		//loop until player want to stop by typing n
		while(!answerYesNo.equalsIgnoreCase("n"))
		{	
			//int randomNumber = 0 + (int) ( Math.random() * 10 );
			int rNumber = ranNumber.RanNumber();
			System.out.printf("Random Number is: %d\n", ranNumber.RanNumber());
			
			gamePlay++;
			//Check for number from 0-10
			if((number < 0) || (number > 10))
			{
				if(number < 0)
					System.out.printf("The number is %d less than random number: %d", number, rNumber);
				else if(number > 10)
					System.out.printf("The number is %d greater than random number: %d", number, rNumber);
				//Prompt user to re-enter the number
				System.out.print("Enter a number: ");
				number = input.nextInt();	
			}			
			else
			{
				if(rNumber == number)
				{
					System.out.println("Congratulation!!! You win");
					win++;
				}
				else if(rNumber < number)
				{
					System.out.print("\nToo Large, try again...");
					lose++;
				}
				else if(rNumber > number)
				{
					System.out.print("\nToo Small, try again...");
					lose++;
				}	
			}
			//Prompt user to play again
			System.out.print("\n\nDo you want to play again?\n");
			System.out.print("Please enter \"y\" for yes and \"n\" for no: ");
			answerYesNo = input.next().toUpperCase();			//turn the answer to upper case.
			//Check for user enters not Y or N
			if((!answerYesNo.equals("Y") && (!answerYesNo.equals("N"))))
			{
				System.out.println("Only \"y\" or \"n\" accepted");		
				System.out.print("\n\nDo you want to play again?\n");
				System.out.print("Please enter \"y\" for yes and \"n\" for no: ");
				answerYesNo = input.next().toUpperCase();		
			}
			if(answerYesNo.equals("Y"))
			{
				System.out.print("Enter a number: ");
				number = input.nextInt();					
			}
			else if(answerYesNo.equals("N"))
			{
				//Calculate percentage win and lose
				double percentLose = (lose*100)/gamePlay;
				double percentWin = (win*100)/gamePlay;
				//print out number of game played, number of win, number of lose, and percentage win lose with %% to print % sign.
				System.out.printf("\nYou played %d games", gamePlay);
				System.out.printf("\nNumber of good guess is: %d, and percentage is %.2f%% ", win, percentWin);
				System.out.printf("\nNumber of bad guess is: %d, and percentage is %.2f%%", lose,percentLose);				
				System.out.println("\nThanks for playing! Bye...");
			}	
			
		}
		input.close();
	}

}
