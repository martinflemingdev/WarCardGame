package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class War {

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
				System.out.println("Battle:" + (i+1) );
				Object playerTopCardValue = playerDeck.get(i).getRank();
				Object computerTopCardValue = computerDeck.get(i).getRank();
				iValue = i;
				turns++;
				while (playerTopCardValue == computerTopCardValue) {
					System.out.println("WAR!");
					System.out.println("Player has " + playerDeck.get(i).getCardName());
					System.out.println("Computer has " + computerDeck.get(i).getCardName());
					System.out.println();
					if (smallestDeck - i > 4 ) {

						int playerWarCard = playerDeck.get(i+4).getRank();
						int computerWarCard = computerDeck.get(i+4).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(playerDeck.get(i+3));
						warWinDeck.add(playerDeck.get(i+4));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i+3));
						warWinDeck.add(computerDeck.get(i+4));

						wars++;

						System.out.println("Are you ready for the final card?");
						hitReturn.nextLine();

						if (playerWarCard > computerWarCard) {

							System.out.println("Player wins the WAR with " + playerDeck.get(i+4).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+4).getCardName());
							System.out.println();
							System.out.println("Player kept the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player kept the " + playerDeck.get(i+2).getCardName());
							System.out.println("Player kept the " + playerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Computer lost the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer lost the " + computerDeck.get(i+2).getCardName());
							System.out.println("Computer lost the " + computerDeck.get(i+3).getCardName());

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							playerScore++;
							i += 4;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else if (playerWarCard < computerWarCard) {

							System.out.println("Computer wins the WAR with " + computerDeck.get(i+4).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+4).getCardName());
							System.out.println();
							System.out.println("Computer kept the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer kept the " + computerDeck.get(i+2).getCardName());
							System.out.println("Computer kept the " + computerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Player lost the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player lost the " + playerDeck.get(i+2).getCardName());
							System.out.println("Player lost the " + playerDeck.get(i+3).getCardName());

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							computerScore++;
							i += 4;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else {
							System.out.println("ANOTHER WAR!");
							i += 4;
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							hitReturn.nextLine();

						}

					} else if  (smallestDeck - i > 3) {

						int playerWarCard = playerDeck.get(i+3).getRank();
						int computerWarCard = computerDeck.get(i+3).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(playerDeck.get(i+3));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i+3));

						wars++;

						System.out.println("Are you ready for the final card?");
						hitReturn.nextLine();

						if (playerWarCard > computerWarCard) {

							System.out.println("Player wins the WAR with " + playerDeck.get(i+3).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Player kept the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player kept the " + playerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Computer lost the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer lost the " + computerDeck.get(i+2).getCardName());

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							playerScore++;
							i += 3;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else if (playerWarCard < computerWarCard) {

							System.out.println("Computer wins the WAR with " + computerDeck.get(i+3).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Computer kept the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer kept the " + computerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Player lost the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player lost the " + playerDeck.get(i+2).getCardName());


							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							computerScore++;
							i += 3;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else {
							System.out.println("ANOTHER WAR!");
							i += 3;
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							hitReturn.nextLine();
						}

					} else if (smallestDeck - i > 2) {
						int playerWarCard = playerDeck.get(i+2).getRank();
						int computerWarCard = computerDeck.get(i+2).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));

						wars++;

						System.out.println("Are you ready for the final card?");
						hitReturn.nextLine();

						if (playerWarCard > computerWarCard) {

							System.out.println("Player wins the WAR with " + playerDeck.get(i+2).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Player kept the " + playerDeck.get(i+1).getCardName());
							System.out.println();
							System.out.println("Computer lost the " + computerDeck.get(i+1).getCardName());


							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							playerScore++;
							i += 2;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else if (playerWarCard < computerWarCard) {

							System.out.println("Computer wins the WAR with " + computerDeck.get(i+2).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Computer kept the " + computerDeck.get(i+1).getCardName());
							System.out.println();
							System.out.println("Player lost the " + playerDeck.get(i+1).getCardName());


							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							computerScore++;
							i += 2;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else {
							System.out.println("ANOTHER WAR!");
							i += 2;
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							hitReturn.nextLine();
						}
					} else if (smallestDeck - i > 1) {
						int playerWarCard = playerDeck.get(i+1).getRank();
						int computerWarCard = computerDeck.get(i+1).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));		
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));

						wars++;

						System.out.println("Are you ready for the final card?");
						hitReturn.nextLine();

						if (playerWarCard > computerWarCard) {

							System.out.println("Player wins the WAR with " + playerDeck.get(i+1).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+1).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							playerScore++;
							i++;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else if (playerWarCard < computerWarCard) {

							System.out.println("Computer wins the WAR with " + computerDeck.get(i+1).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+1).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							hitReturn.nextLine();
							warWinDeck = new ArrayList<>();
							computerScore++;
							i++;
							playerTopCardValue = null;
							computerTopCardValue = 0;

						} else {
							System.out.println("ANOTHER WAR!");
							i++;
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							
							hitReturn.nextLine();
						}

					} else {
						System.out.println("Player and computer triggered WAR on the last card! RETREAT!");
						playerWinDeck.add(playerDeck.get(i));
						System.out.println("Player keeps the " + playerDeck.get(i).getCardName());
						computerWinDeck.add(computerDeck.get(i));
						System.out.println("Computer keeps the " + computerDeck.get(i).getCardName());
						wars++;
						hitReturn.nextLine();
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
						hitReturn.nextLine();
						playerScore++;
						playerWinDeck.add(playerDeck.get(i));
						playerWinDeck.add(computerDeck.get(i));
					} else if (computerTopCardValueInt > playerTopCardValueInt) {
						System.out.println("Computer wins with " + computerDeck.get(i).getCardName());
						System.out.println("Player lost with " + playerDeck.get(i).getCardName());
						hitReturn.nextLine();
						computerScore++;
						computerWinDeck.add(playerDeck.get(i));
						computerWinDeck.add(computerDeck.get(i));
					}
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
			} 


			rounds++;
			List<Card> playerTransfer = new ArrayList<>();
			List<Card> computerTransfer = new ArrayList<>();

			playerTransfer = playerWinDeck;
			computerTransfer = computerWinDeck;
			playerWinDeck = new ArrayList<>();
			computerWinDeck = new ArrayList<>();
			playerDeck = new ArrayList<>();
			computerDeck = new ArrayList<>();
			playerDeck = playerTransfer;
			computerDeck = computerTransfer;
			//				playerWinDeck = playerDeck;
			//				computerWinDeck = computerDeck;
			//				playerDeck = playerWinDeck;
			//				computerDeck = computerWinDeck;


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

	//	public void playCards() {
	//		while (playerDeck.size() > 0 && computerDeck.size() > 0) {
	//			int smallestDeck;
	//			if (playerDeck.size() <= computerDeck.size()) {
	//				smallestDeck = playerDeck.size();
	//			} else {
	//				smallestDeck = computerDeck.size();
	//			}
	//			playerWinDeck = new ArrayList<>();
	//			computerWinDeck = new ArrayList<>();
	//			for (int i=0; i<smallestDeck; i++) {
	//
	//				int playerTopCardValue = playerDeck.get(i).getRank();
	//				int computerTopCardValue = computerDeck.get(i).getRank();
	//				iValue = i;
	//				if (playerTopCardValue > computerTopCardValue) {
	//					System.out.println("Player wins with " + playerDeck.get(i).getCardName());
	//					System.out.println("Computer lost with " + computerDeck.get(i).getCardName());
	//					System.out.println();
	//					playerScore++;
	//					playerWinDeck.add(playerDeck.get(i));
	//					playerWinDeck.add(computerDeck.get(i));
	//				} else if (computerTopCardValue > playerTopCardValue) {
	//					System.out.println("Computer wins with " + computerDeck.get(i).getCardName());
	//					System.out.println("Player lost with " + playerDeck.get(i).getCardName());
	//					System.out.println();
	//					computerScore++;
	//					computerWinDeck.add(playerDeck.get(i));
	//					computerWinDeck.add(computerDeck.get(i));
	//				} else if (playerTopCardValue == computerTopCardValue) {
	//					System.out.println("WAR!");
	//					System.out.println("Computer has " + computerDeck.get(i).getCardName());
	//					System.out.println("Player has " + playerDeck.get(i).getCardName());
	//					System.out.println();
	//					wars++;
	//					playerScore++;
	//					computerScore++;
	//					playerWinDeck.add(playerDeck.get(i));
	//					computerWinDeck.add(computerDeck.get(i));
	//				}
	//			} 
	//			if (playerDeck.size() > computerDeck.size()) {
	//				for (int j = iValue + 1; j < playerDeck.size(); j++) {
	//					playerWinDeck.add(playerDeck.get(j));
	//				}  
	//			} else if (playerDeck.size() < computerDeck.size()) {
	//				for (int j = iValue + 1; j < computerDeck.size(); j++) {
	//					computerWinDeck.add(computerDeck.get(j));
	//				}
	//			}
	//
	//			
	//			System.out.println("**************************************");
	//			System.out.println("Round: " + rounds);
	//			System.out.println("**************************************");
	//			System.out.println("Player Score: " + playerScore);
	//			System.out.println("Player Cards: " + playerDeck.size());
	//			System.out.println("Computer Score: " + computerScore);
	//			System.out.println("Computer Cards: " + computerDeck.size());
	//			System.out.println("Wars: " + wars);
	//			System.out.println("**************************************");
	//			Collections.shuffle(playerDeck);
	//			Collections.shuffle(computerDeck);
	//		} System.out.println("This game took " + turns + " battles!" );
	//	}

}
