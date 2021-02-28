package com.techelevator;

public class WarCLI {
	
	private static final String DISPLAY_DECK = "Display Cards in Deck";
	private static final String PLAY_WAR_HIT_ENTER = "Play War Interactively";
	private static final String PLAY_WAR_AUTO = "Play War Automagically";
	private static final String EXIT = "Exit";
	private static final String[] MENU_OPTIONS = {DISPLAY_DECK, PLAY_WAR_HIT_ENTER, PLAY_WAR_AUTO, EXIT};

	private Menu menu;
	private DeckBuilder deckBuilder;
	private War war;
	private WarGameInteractive warInteractive;
	
	public WarCLI(Menu menu, DeckBuilder deckBuilder, War war, WarGameInteractive warInteractive) {
		this.menu = menu;
		this.deckBuilder = deckBuilder;
		this.war = war;
		this.warInteractive = warInteractive;
	}
	
	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		DeckBuilder deckBuilder = new DeckBuilder();
		War war = new War();
		WarGameInteractive warInteractive = new WarGameInteractive();
		
		WarCLI warCLI = new WarCLI(menu, deckBuilder, war, warInteractive);
		warCLI.run();
	}
	
	public void run() {
		
		menu.displayTitleScreen();
		deckBuilder.readFileForCards();
		deckBuilder.createDeckOfCards();
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MENU_OPTIONS);
			
			if (choice.equals(DISPLAY_DECK)) {
				deckBuilder.displayDeck();
			}
			else if (choice.equals(PLAY_WAR_HIT_ENTER)) {
				System.out.println("Please hit ENTER to play");
				deckBuilder.shuffleDeck();
				warInteractive.makeTwoWarDecks(deckBuilder.getDeck());
				warInteractive.playWar();
			}
			else if (choice.equals(PLAY_WAR_AUTO)) {
				deckBuilder.shuffleDeck();
				war.makeTwoWarDecks(deckBuilder.getDeck());
				war.playWar();
			}
			else if (choice.equals(EXIT)) {
				System.out.println("I hope you enjoyed the WAR!");
				System.exit(1);
			}
		}
	}
}
