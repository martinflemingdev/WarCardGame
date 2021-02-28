package wargame;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	public void displayTitleScreen() {
		System.out.println("*********************************");
		System.out.println("*   WECLOME TO THE GAME OF...   *");
		System.out.println("* __          __     _____  _   *\r\n" + 
				"* \\ \\        / /\\   |  __ \\| |  *\r\n" + 
				"*  \\ \\  /\\  / /  \\  | |__) | |  *\r\n" + 
				"*   \\ \\/  \\/ / /\\ \\ |  _  /| |  *\r\n" + 
				"*    \\  /\\  / ____ \\| | \\ \\|_|  *\r\n" + 
				"*     \\/  \\/_/    \\_\\_|  \\_(_)  *");
		System.out.println("*                               *");
		System.out.println("*********************************");
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
}
