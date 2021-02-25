package sandbox;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	//instance variable
	private Scanner userInput;
	int choice = 0;
	Dictionary dictionary = new Dictionary();

	public Menu() {
		this.userInput = new Scanner(System.in);
	}

	public void displayMenu() {
		System.out.println("______ _____ _____ _____ _____ _____ _   _   ___  ________   __");
		System.out.println("|  _  \\_   _/  __ \\_   _|_   _|  _  | \\ | | / _ \\ | ___ \\ \\ / /");
		System.out.println("| | | | | | | /  \\/ | |   | | | | | |  \\| |/ /_\\ \\| |_/ /\\ V / ");
		System.out.println("| | | | | | | |     | |   | | | | | | . ` ||  _  ||    /  \\ /  ");
		System.out.println("| |/ / _| |_| \\__/\\ | |  _| |_\\ \\_/ / |\\  || | | || |\\ \\  | |  ");
		System.out.println("|___/  \\___/ \\____/ \\_/  \\___/ \\___/\\_| \\_/\\_| |_/\\_| \\_| \\_/  ");
		System.out.println("***************************************************************");
		System.out.println("************* Welcome to your personal Dictionary *************");
		System.out.println("***************************************************************");
		while (choice == 0) {
			System.out.println("\n" + "Please make a choice:");	
			System.out.println("1. Add a word to the dictionary");		
			System.out.println("2. Display the dictionary");
			System.out.println("3. Save the dictionary to a text file");
			System.out.println();
			try {choice = userInput.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n" + "You typed something wrong, please try again" + "\n");
				choice = 0;
			}
			userInput.nextLine();
			if (choice == 1) {
				System.out.println("Please enter a new word:");

				String word = userInput.nextLine();
				if ((word == null) || (word.isEmpty())) {
					System.out.println("Please enter a word:");
				}
				System.out.println("Please define " + word + ":");
				String definition = userInput.nextLine();
				DictionaryWord dictWord = new DictionaryWord(word, definition);
				dictionary.addWord(dictWord);
				choice = 0;




			}
			if (choice == 2) {
				// alpha orders list by implementing comparable on dictionary word class
				Collections.sort(dictionary.getDictionary());
				dictionary.displayDictionary();
				choice = 0;
			}
			if (choice == 3) {

			}
		}

	} 
}


