package com.techelevator;

import com.techelevator.view.Menu;

public class CardGamesCLI {

//	instance vars
	private static final String MAIN_MENU_OPTION_DISPLAY_DECK = "Display Cards in Deck";
	private static final String MAIN_MENU_OPTION_PICK_GAME = "Pick a Game";
	private static final String Main_MEN_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_DECK, MAIN_MENU_OPTION_PICK_GAME, Main_MEN_OPTION_EXIT };
	private Menu menu;
	private static final String PICK_GAME_MENU_GAME1 = "Game 1";
	private static final String PICK_GAME_MENU_WAR_GAME = "WAR";
	private static final String PICK_GAME_MENU_GAME3 = "Game 3";
	private static final String PICK_GAME_MENU_EXIT = "Exit";
	private static final String[] PICK_GAME_MENU_OPTIONS = { PICK_GAME_MENU_GAME1, PICK_GAME_MENU_WAR_GAME, PICK_GAME_MENU_GAME3, PICK_GAME_MENU_EXIT};
	
	// instance variable
	DeckBuilder deckBuilder = new DeckBuilder();
	
//	METHODS
	public CardGamesCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		
		deckBuilder.buildListOfCards();
		deckBuilder.deckBuilder();
	
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_DECK)) {
				
				// display vending machine items
				deckBuilder.displayDeck();
				System.out.println("Here is the deck!");
			} 
			else if (choice.equals(MAIN_MENU_OPTION_PICK_GAME)) {
				System.out.println("pick a game???");
				deckBuilder.shuffleDeck();
					
					while (true) {
						
						String subChoice = (String) menu.getChoiceFromOptions(PICK_GAME_MENU_OPTIONS); 
						
						if (subChoice.equals(PICK_GAME_MENU_GAME1)) {
								//					GAME 1 HERE
							System.out.println("game2!!!!!");
						}
						else if (subChoice.equals(PICK_GAME_MENU_WAR_GAME)) {
							
							War war = new War();
							
							war.makeTwoWarDecks(deckBuilder.getDeck());
							
							war.playWar();
							
						} 
						else if (subChoice.equals(PICK_GAME_MENU_GAME3)) {
								//					  GAME 3 HERE
							System.out.println("game3!!!!!!");
						}
						else if (subChoice.equals(PICK_GAME_MENU_EXIT)) {
						break;
						}
						
					}
				}	
				
			else if (choice.equals(Main_MEN_OPTION_EXIT)) {
				System.out.println("I hope you enjoyed the WAR!");
				System.exit(1);
			}	
		}		
	}
	

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		CardGamesCLI cli = new CardGamesCLI(menu);
		cli.run();
	}
	
}
