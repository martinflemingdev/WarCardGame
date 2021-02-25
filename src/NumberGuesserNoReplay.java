import java.util.Scanner;

public class NumberGuesserNoReplay {

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println( " Welcome to Martin Fleming's Number Guesser!");
		System.out.println("*********************************************");
		System.out.println("\n" + "Guess my number between 1 and 10 in 3 guesses: ");
		int randomInt = (int) (Math.random()*10)+1;
		int numOfGuesses = 1;
		Scanner input = new Scanner(System.in);
		int guess = input.nextInt();
		while (numOfGuesses < 4) {
			while ((guess > 11 || guess < 0)) {
				System.out.println("Seriously, guess a number between 1 and 10:");
				guess = input.nextInt();
			}
			if (guess == randomInt) {
				System.out.println("Congratulations! You've guessed the number in " + numOfGuesses + " tries!");
				System.exit(1);
			} 
			else if ((guess < randomInt) && numOfGuesses < 3) {
				System.out.println("Guess higher!");
				guess = input.nextInt();
			} else if ((guess > randomInt) && numOfGuesses < 3) {
				System.out.println("Guess lower!");
				guess = input.nextInt();
			} numOfGuesses++;
		} System.out.println("Sorry, the number was " + randomInt + ".");
	}
}
