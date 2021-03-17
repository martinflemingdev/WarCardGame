package wargame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeckBuilder {

	//instance variables
	List <String []> listOfCards = new ArrayList<>(); 
	List <Card> deck = new ArrayList<>();

	String filePath = "cardDeck.csv";
	File cardDeckFile = new File (filePath);

	// Methods

	public List <String []> readFileForCards() {
		try(Scanner FileScanner = new Scanner(cardDeckFile))
		{
			while (FileScanner.hasNextLine()) {
				String line = FileScanner.nextLine();
				String [] cards = line.split("\\|");
				listOfCards.add(cards);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listOfCards;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void displayDeck() {
		for (Card thisCard : deck) {
			System.out.println(thisCard.getCardName());
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public List <Card> createDeckOfCards(){
		for (String[] listElement : listOfCards) {

			if (listElement[1].equalsIgnoreCase("Hearts")){

				if (listElement[0].equalsIgnoreCase("Jack")) {
					Hearts thisHeart = new Hearts(11, listElement[1], "Jack" );
					deck.add(thisHeart);
				}
				else if (listElement[0].equalsIgnoreCase("Queen")) {
					Hearts thisHeart = new Hearts(12, listElement[1], "Queen");
					deck.add(thisHeart);
				}
				else if (listElement[0].equalsIgnoreCase("King")) {
					Hearts thisHeart = new Hearts(13, listElement[1], "King");
					deck.add(thisHeart);
				}
				else if (listElement[0].equalsIgnoreCase("Ace")) {
					Hearts thisHeart = new Hearts(14, listElement[1], "Ace");
					deck.add(thisHeart);
				} 
				else {
					Hearts thisHeart = new Hearts(Integer.parseInt(listElement[0]), listElement[1], listElement[0]);
					//				myHeart = (2, 'heart', '2')
					deck.add(thisHeart);
				}

			}
			if (listElement[1].equalsIgnoreCase("Clubs")){

				if (listElement[0].equalsIgnoreCase("Jack")) {
					Clubs thisClub = new Clubs (11, listElement[1], "Jack");
					deck.add(thisClub);
				}
				else if (listElement[0].equalsIgnoreCase("Queen")) {
					Clubs thisClub = new Clubs (12, listElement[1], "Queen");
					deck.add(thisClub);
				}
				else if (listElement[0].equalsIgnoreCase("King")) {
					Clubs thisClub = new Clubs (13, listElement[1], "King");
					deck.add(thisClub);
				}
				else if (listElement[0].equalsIgnoreCase("Ace")) {
					Clubs thisClub = new Clubs (14, listElement[1], "Ace");
					deck.add(thisClub);
				} 
				else {
					Clubs thisClub = new Clubs (Integer.parseInt(listElement[0]), listElement[1], listElement[0]);
					deck.add(thisClub);
				}
			}
			if (listElement[1].equalsIgnoreCase("Diamonds")){

				if (listElement[0].equalsIgnoreCase("Jack")) {
					Diamonds thisDiamond = new Diamonds (11, listElement[1], "Jack");
					deck.add(thisDiamond);
				}
				else if (listElement[0].equalsIgnoreCase("Queen")) {
					Diamonds thisDiamond = new Diamonds (12, listElement[1], "Queen");
					deck.add(thisDiamond);
				}
				else if (listElement[0].equalsIgnoreCase("King")) {
					Diamonds thisDiamond = new Diamonds (13, listElement[1], "King");
					deck.add(thisDiamond);
				}
				else if (listElement[0].equalsIgnoreCase("Ace")) {
					Diamonds thisDiamond = new Diamonds (14, listElement[1], "Ace");
					deck.add(thisDiamond);
				} 
				else {
					Diamonds thisDiamond = new Diamonds (Integer.parseInt(listElement[0]), listElement[1], listElement[0]);
					deck.add(thisDiamond);
				}
			}
			if (listElement[1].equalsIgnoreCase("Spades")){

				if (listElement[0].equalsIgnoreCase("Jack")) {
					Spades thisSpade = new Spades (11, listElement[1], "Jack"); 
					deck.add(thisSpade);
				}
				else if (listElement[0].equalsIgnoreCase("Queen")) {
					Spades thisSpade = new Spades (12, listElement[1], "Queen");
					deck.add(thisSpade);
				}
				else if (listElement[0].equalsIgnoreCase("King")) {
					Spades thisSpade = new Spades (13, listElement[1], "King");
					deck.add(thisSpade);
				}
				else if (listElement[0].equalsIgnoreCase("Ace")) {
					Spades thisSpade = new Spades (14, listElement[1], "Ace");
					deck.add(thisSpade);
				} 
				else {
					Spades thisSpade = new Spades (Integer.parseInt(listElement[0]), listElement[1], listElement[0]);
					deck.add(thisSpade);
				}
			}
		}
		return deck;
	}

}