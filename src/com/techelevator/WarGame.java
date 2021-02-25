package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WarGame {

	// instance variables
	List<Card> playerDeck;
	List<Card> computerDeck;
	List<Card> playerWinDeck;
	List<Card> computerWinDeck;
	List<Card> warWinDeck;
	int turns = 0;
	int iValue = 0;
	int playerScore = 0;
	int computerScore= 0;
	int wars = 0;
	int rounds = 0;

	public void playWar() {

		playerWinDeck = new ArrayList<>();
		computerWinDeck = new ArrayList<>();
		warWinDeck = new ArrayList<>();
		int smallestDeck;
		Scanner hitReturn = new Scanner(System.in);

		while (playerDeck.size() > 0 && computerDeck.size() > 0) {

			if (playerDeck.size() <= computerDeck.size()) {
				smallestDeck = playerDeck.size();
			} else {
				smallestDeck = computerDeck.size();
			}

			for (int i=0; i<smallestDeck; i++) {
				turns++;
				Object playerTopCardValue = playerDeck.get(i).getRank();
				Object computerTopCardValue = computerDeck.get(i).getRank();
				iValue = i;
				hitReturn.nextLine();
				while (playerTopCardValue == computerTopCardValue) {
					System.out.println("WAR!");
					System.out.println("Computer has " + computerDeck.get(i).getCardName());
					System.out.println("Player has " + playerDeck.get(i).getCardName());

					if (smallestDeck - i >= 5 ) {

						int playerWarCard = playerDeck.get(i+4).getRank();
						int computerWarCard = computerDeck.get(i+4).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(playerDeck.get(i+3));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i+3));

						System.out.println();

						if (playerWarCard > computerWarCard) {
							System.out.println("Player wins the WAR with " + playerDeck.get(i+4).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+4).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 4;
							playerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else if (playerWarCard < computerWarCard) {
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+4).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+4).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 4;
							computerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else if (playerWarCard == computerWarCard){
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							i += 4;
							computerScore++;
							playerScore++;
							wars++;
						}

					} else if  (smallestDeck - i >= 4) {

						int playerWarCard = playerDeck.get(i+3).getRank();
						int computerWarCard = computerDeck.get(i+3).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));

						System.out.println();

						if (playerWarCard > computerWarCard) {
							System.out.println("Player wins the WAR with " + playerDeck.get(i+3).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+3).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 3;
							playerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else if (playerWarCard < computerWarCard) {
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+3).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+3).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 3;
							computerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else {
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							i += 3;
							computerScore++;
							playerScore++;
							wars++;
						}

					} else if (smallestDeck - i >= 3) {
						int playerWarCard = playerDeck.get(i+2).getRank();
						int computerWarCard = computerDeck.get(i+2).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));

						System.out.println();

						if (playerWarCard > computerWarCard) {
							System.out.println("Player wins the WAR with " + playerDeck.get(i+2).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+2).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 2;
							playerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else if (playerWarCard < computerWarCard) {
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+2).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+2).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i += 2;
							computerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else {
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							i += 2;
							computerScore++;
							playerScore++;
							wars++;
						}
					} else if (smallestDeck - i >= 2) {
						int playerWarCard = playerDeck.get(i+1).getRank();
						int computerWarCard = computerDeck.get(i+1).getRank();

						warWinDeck.add(playerDeck.get(i));						
						warWinDeck.add(computerDeck.get(i));

						System.out.println();

						if (playerWarCard > computerWarCard) {
							System.out.println("Player wins the WAR with " + playerDeck.get(i+1).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+1).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i++;
							playerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else if (playerWarCard < computerWarCard) {
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+1).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+1).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();
							i++;
							computerScore++;
							wars++;
							playerTopCardValue = null;
							computerTopCardValue = 0;
						} else {
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							i++;
							wars++;
							computerScore++;
							playerScore++;
						}

					} else {
						System.out.println("Player and computer triggered WAR on the last card!");
						playerScore++;
						computerScore++;
						playerWinDeck.add(playerDeck.get(i));
						computerWinDeck.add(computerDeck.get(i));
						wars++;
						playerTopCardValue = null;
						computerTopCardValue = 0;
					}
				}

				// NON WAR GAME PLAY
				if (playerTopCardValue != null) {
					int playerTopCardValueInt = (int) playerTopCardValue;
					int computerTopCardValueInt = (int) computerTopCardValue;
					if (playerTopCardValueInt > computerTopCardValueInt) {
						System.out.println("Player wins with " + playerDeck.get(i).getCardName());
						System.out.println("Computer lost with " + computerDeck.get(i).getCardName());
						System.out.println();
						playerScore++;
						playerWinDeck.add(playerDeck.get(i));
						playerWinDeck.add(computerDeck.get(i));
					} else if (computerTopCardValueInt > playerTopCardValueInt) {
						System.out.println("Computer wins with " + computerDeck.get(i).getCardName());
						System.out.println("Player lost with " + playerDeck.get(i).getCardName());
						System.out.println();
						computerScore++;
						computerWinDeck.add(playerDeck.get(i));
						computerWinDeck.add(computerDeck.get(i));
					}
				}

			}
			//			if (playerDeck.size() > computerDeck.size()) {
			//				for (int j = iValue + 1; j < playerDeck.size(); j++) {
			//					playerWinDeck.add(playerDeck.get(j));
			//				}  
			//			} else if (playerDeck.size() < computerDeck.size()) {
			//				for (int j = iValue + 1; j < computerDeck.size(); j++) {
			//					computerWinDeck.add(computerDeck.get(j));
			//				}
			//			} 
			rounds++;
			playerDeck = playerWinDeck;
			computerDeck = computerWinDeck;
			System.out.println("**************************************");
			System.out.println("Round: " + rounds);
			System.out.println("**************************************");
			System.out.println("Player Score: " + playerScore);
			System.out.println("Player Cards: " + playerDeck.size());
			System.out.println("Computer Score: " + computerScore);
			System.out.println("Computer Cards: " + computerDeck.size());
			System.out.println("Wars: " + wars);
			System.out.println("**************************************");
			Collections.shuffle(playerDeck);
			Collections.shuffle(computerDeck);
		} System.out.println("This game took " + turns + " battles!" );
	}


	public void makeTwoWarDecks(List<Card> shuffledDeck) {
		playerDeck = new ArrayList<>();
		computerDeck = new ArrayList<>();
		int i=1;
		for (Card thiscard : shuffledDeck) {
			if (i % 2 == 0) {
				playerDeck.add(thiscard);
				i++;
			} else {
				computerDeck.add(thiscard);
				i++;
			}
		}
	}

	public List<Card> getPlayerDeck() {
		return playerDeck;
	}

	public List<Card> getComputerDeck() {
		return computerDeck;
	}

	public void showDeck(List<Card> deckToShow) {
		for (Card thisCard : deckToShow) {
			System.out.println(thisCard.getName() + ", " + thisCard.getSuit() + " Quantity: " + thisCard.getQuantity());
		}
	}

	public void playCards() {
		while (playerDeck.size() > 0 && computerDeck.size() > 0) {
			int smallestDeck;
			if (playerDeck.size() <= computerDeck.size()) {
				smallestDeck = playerDeck.size();
			} else {
				smallestDeck = computerDeck.size();
			}
			playerWinDeck = new ArrayList<>();
			computerWinDeck = new ArrayList<>();
			for (int i=0; i<smallestDeck; i++) {
				turns++;
				int playerTopCardValue = playerDeck.get(i).getRank();
				int computerTopCardValue = computerDeck.get(i).getRank();
				iValue = i;
				if (playerTopCardValue > computerTopCardValue) {
					System.out.println("Player wins with " + playerDeck.get(i).getCardName());
					System.out.println("Computer lost with " + computerDeck.get(i).getCardName());
					System.out.println();
					playerScore++;
					playerWinDeck.add(playerDeck.get(i));
					playerWinDeck.add(computerDeck.get(i));
				} else if (computerTopCardValue > playerTopCardValue) {
					System.out.println("Computer wins with " + computerDeck.get(i).getCardName());
					System.out.println("Player lost with " + playerDeck.get(i).getCardName());
					System.out.println();
					computerScore++;
					computerWinDeck.add(playerDeck.get(i));
					computerWinDeck.add(computerDeck.get(i));
				} else if (playerTopCardValue == computerTopCardValue) {
					System.out.println("WAR!");
					System.out.println("Computer has " + computerDeck.get(i).getCardName());
					System.out.println("Player has " + playerDeck.get(i).getCardName());
					System.out.println();
					wars++;
					playerScore++;
					computerScore++;
					playerWinDeck.add(playerDeck.get(i));
					computerWinDeck.add(computerDeck.get(i));
				}
			} 
			if (playerDeck.size() > computerDeck.size()) {
				for (int j = iValue + 1; j < playerDeck.size(); j++) {
					playerWinDeck.add(playerDeck.get(j));
				}  
			} else if (playerDeck.size() < computerDeck.size()) {
				for (int j = iValue + 1; j < computerDeck.size(); j++) {
					computerWinDeck.add(computerDeck.get(j));
				}
			} rounds++;
			playerDeck = playerWinDeck;
			computerDeck = computerWinDeck;
			System.out.println("**************************************");
			System.out.println("Round: " + rounds);
			System.out.println("**************************************");
			System.out.println("Player Score: " + playerScore);
			System.out.println("Player Cards: " + playerDeck.size());
			System.out.println("Computer Score: " + computerScore);
			System.out.println("Computer Cards: " + computerDeck.size());
			System.out.println("Wars: " + wars);
			System.out.println("**************************************");
			Collections.shuffle(playerDeck);
			Collections.shuffle(computerDeck);
		} System.out.println("This game took " + turns + " battles!" );
	}

}
