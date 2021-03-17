package wargame;

public abstract class Card {
	
//	private members/ instance vars
	private String suit;
	private int rank;
	private String name;
	private boolean faceUp;
	private int quantity;
	
//	getters
	
	public String getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getCardName() {
		String cardName = "the " + getName() + " of " + getSuit();
		return cardName;
	}
	
//	constructor
	public Card (int rank, String suit, String name) {
		this.suit = suit;
		this.rank = rank;
		this.name = name;
		this.faceUp = false;
		this.quantity = 1;
	}
}
