package wargame;

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

	int playerScore;
	int computerScore;
	int smallestDeck;

	int turns;
	int iValue;
	int rounds;

	int wars;
	int doubleWars;
	boolean doublewar;
	boolean doublewarRetreat;

	Scanner hitReturn = new Scanner(System.in);

	public void playWar() {

		playerWinDeck = new ArrayList<>();
		computerWinDeck = new ArrayList<>();
		warWinDeck = new ArrayList<>();

		while (playerDeck.size() > 0 && computerDeck.size() > 0) {

			if (playerDeck.size() <= computerDeck.size()) {
				smallestDeck = playerDeck.size();
			} else {
				smallestDeck = computerDeck.size();
			}

			for (int i = 0; i < smallestDeck; i++) {
				
				System.out.println("Battle:" + (i+1));
				Object playerTopCardValue = playerDeck.get(i).getRank();
				Object computerTopCardValue = computerDeck.get(i).getRank();
				iValue = i;
				turns++;

				while (playerTopCardValue == computerTopCardValue) {
					if (!doublewar || (doublewar && i == 0)) {
						System.out.println(" __          __     _____  _ \r\n" + 
								" \\ \\        / /\\   |  __ \\| |\r\n" + 
								"  \\ \\  /\\  / /  \\  | |__) | |\r\n" + 
								"   \\ \\/  \\/ / /\\ \\ |  _  /| |\r\n" + 
								"    \\  /\\  / ____ \\| | \\ \\|_|\r\n" + 
								"     \\/  \\/_/    \\_\\_|  \\_(_)\n");
						System.out.println("Player has " + playerDeck.get(i).getCardName());
						System.out.println("Computer has " + computerDeck.get(i).getCardName());
						System.out.println();
					} else if (doublewar && i != 0) {
						System.out.println(" __          __     _____  _ \r\n" + 
								" \\ \\        / /\\   |  __ \\| |\r\n" + 
								"  \\ \\  /\\  / /  \\  | |__) | |\r\n" + 
								"   \\ \\/  \\/ / /\\ \\ |  _  /| |\r\n" + 
								"    \\  /\\  / ____ \\| | \\ \\|_|\r\n" + 
								"     \\/  \\/_/    \\_\\_|  \\_(_)\n");
						System.out.println("Player has " + playerDeck.get(i-1).getCardName());
						System.out.println("Computer has " + computerDeck.get(i-1).getCardName());
						System.out.println();
					}
					doublewar = false;

					// War with 5: card that triggered + 3 face-down + card that decides war
					if (smallestDeck - i > 4 ) {
						wars++;
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

						System.out.println("Are you ready for the final card?" + "\n");

						if (playerWarCard > computerWarCard) {
							playerScore++;
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
							System.out.println();

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i += 4;
							iValue +=4;
							playerTopCardValue = null;

						} else if (playerWarCard < computerWarCard) {
							computerScore++;
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
							System.out.println();

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i += 4;
							iValue +=4;
							playerTopCardValue = null;

						} else {
							doublewar=true;
							doubleWars++;
							System.out.println("The final card triggers another WAR!!" + "\n");
							System.out.println("Player's final card was the " + playerDeck.get(i+4).getCardName());
							System.out.println("Computer's final card was the " + computerDeck.get(i+4).getCardName());
							System.out.println("");
							System.out.println("Player pushes the " + playerDeck.get(i).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+2).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+3).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+4).getCardName());
							System.out.println("");
							System.out.println("Computer pushes the " + computerDeck.get(i).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+2).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+3).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+4).getCardName());
							System.out.println("");

							i += 4;
							iValue += 4;
							if (i<smallestDeck) {
								i++;
								iValue++;
								if (i == smallestDeck){
									iValue--;
									break;
								}
							}
							System.out.println("-----------ANOTHER-----------");
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							doublewarRetreat=true;
						}

						// War with 4: card that triggered + 2 face-down + card that decides war
					} else if  (smallestDeck - i > 3) {
						wars++;
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

						System.out.println("Are you ready for the final card?" + "\n");

						if (playerWarCard > computerWarCard) {
							playerScore++;
							System.out.println("Player wins the WAR with " + playerDeck.get(i+3).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Player kept the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player kept the " + playerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Computer lost the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer lost the " + computerDeck.get(i+2).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i += 3;
							iValue +=3;
							playerTopCardValue = null;

						} else if (playerWarCard < computerWarCard) {
							computerScore++;
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+3).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+3).getCardName());
							System.out.println();
							System.out.println("Computer kept the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer kept the " + computerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Player lost the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player lost the " + playerDeck.get(i+2).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i += 3;
							iValue +=3;
							playerTopCardValue = null;

						} else {
							doublewar=true;
							doubleWars++;
							System.out.println("The final card triggers another WAR!!" + "\n");
							System.out.println("Player's final card was the " + playerDeck.get(i+3).getCardName());
							System.out.println("Computer's final card was the " + computerDeck.get(i+3).getCardName());
							System.out.println("");
							System.out.println("Player pushes the " + playerDeck.get(i).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+2).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+3).getCardName());
							System.out.println("");
							System.out.println("Computer pushes the " + computerDeck.get(i).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+2).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+3).getCardName());
							System.out.println("");

							i +=3;
							iValue +=3;
							if (i<smallestDeck) {
								i++;
								iValue++;
								if (i == smallestDeck){
									iValue--;
									break;
								}
							}
							System.out.println("-----------ANOTHER-----------");
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							doublewarRetreat=true;
						}

						// War with 3: card that triggered + 1 face-down + card that decides war
					} else if (smallestDeck - i > 2) {
						wars++;
						int playerWarCard = playerDeck.get(i+2).getRank();
						int computerWarCard = computerDeck.get(i+2).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));
						warWinDeck.add(playerDeck.get(i+2));
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));
						warWinDeck.add(computerDeck.get(i+2));

						System.out.println("Are you ready for the final card?" + "\n");

						if (playerWarCard > computerWarCard) {
							playerScore++;
							System.out.println("Player wins the WAR with " + playerDeck.get(i+2).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Player kept the " + playerDeck.get(i+1).getCardName());
							System.out.println();
							System.out.println("Computer lost the " + computerDeck.get(i+1).getCardName());
							System.out.println();
							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							}
							warWinDeck = new ArrayList<>();

							i += 2;
							iValue +=2;
							playerTopCardValue = null;

						} else if (playerWarCard < computerWarCard) {
							computerScore++;
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+2).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+2).getCardName());
							System.out.println();
							System.out.println("Computer kept the " + computerDeck.get(i+1).getCardName());
							System.out.println();
							System.out.println("Player lost the " + playerDeck.get(i+1).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i += 2;
							iValue +=2;
							playerTopCardValue = null;

						} else {
							doublewar=true;
							doubleWars++;
							System.out.println("The final card triggers another WAR!!" + "\n");
							System.out.println("Player's final card was the " + playerDeck.get(i+2).getCardName());
							System.out.println("Computer's final card was the " + computerDeck.get(i+2).getCardName());
							System.out.println("");
							System.out.println("Player pushes the " + playerDeck.get(i).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+1).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+2).getCardName());
							System.out.println("");
							System.out.println("Computer pushes the " + computerDeck.get(i).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+1).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+2).getCardName());
							System.out.println("");

							i += 2;
							iValue+=2;
							if (i<smallestDeck) {
								i++;
								iValue++;
								if (i == smallestDeck){
									iValue--;
									break;
								}
							}
							System.out.println("-----------ANOTHER-----------");
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							doublewarRetreat=true;
						}

						// War with 2: card that triggered + card that decides war
					} else if (smallestDeck - i > 1) {
						wars++;
						int playerWarCard = playerDeck.get(i+1).getRank();
						int computerWarCard = computerDeck.get(i+1).getRank();

						warWinDeck.add(playerDeck.get(i));
						warWinDeck.add(playerDeck.get(i+1));		
						warWinDeck.add(computerDeck.get(i));
						warWinDeck.add(computerDeck.get(i+1));

						System.out.println("Are you ready for the final card?" + "\n");

						if (playerWarCard > computerWarCard) {
							playerScore++;
							System.out.println("Player wins the WAR with " + playerDeck.get(i+1).getCardName());
							System.out.println("Computer lost with " + computerDeck.get(i+1).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								playerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i++;
							iValue ++;
							playerTopCardValue = null;

						} else if (playerWarCard < computerWarCard) {
							computerScore++;
							System.out.println("Computer wins the WAR with " + computerDeck.get(i+1).getCardName());
							System.out.println("Player lost with " + playerDeck.get(i+1).getCardName());
							System.out.println();

							for (Card card : warWinDeck) {
								computerWinDeck.add(card);
							} 
							warWinDeck = new ArrayList<>();

							i++;
							iValue ++;
							playerTopCardValue = null;

						} else {
							doublewar=true;
							doubleWars++;
							System.out.println("The final card triggers another WAR!!" + "\n");
							System.out.println("Player's final card was the " + playerDeck.get(i+1).getCardName());
							System.out.println("Computer's final card was the " + computerDeck.get(i+1).getCardName());
							System.out.println("");
							System.out.println("Player pushes the " + playerDeck.get(i).getCardName());
							System.out.println("Player pushes the " + playerDeck.get(i+1).getCardName());
							System.out.println("");
							System.out.println("Computer pushes the " + computerDeck.get(i).getCardName());
							System.out.println("Computer pushes the " + computerDeck.get(i+1).getCardName());
							System.out.println("");

							i++;
							iValue ++;
							if (i<smallestDeck) {
								i++;
								iValue ++;
								if (i == smallestDeck){
									iValue--;
									break;
								}
							}
							System.out.println("-----------ANOTHER-----------");
							playerTopCardValue = playerWarCard;
							computerTopCardValue = computerWarCard;
							doublewarRetreat=true;
						}

						// War with 1: card that triggered is returned
					} else {
						wars++;
						System.out.println("Player and computer triggered WAR on the last card! RETREAT!\n");
						if (doublewarRetreat) {
							playerWinDeck.add(playerDeck.get(i));
							System.out.println("Player keeps the " + playerDeck.get(i-1).getCardName());
							computerWinDeck.add(computerDeck.get(i));
							System.out.println("Computer keeps the " + computerDeck.get(i-1).getCardName());
							System.out.println();
						} else {
							playerWinDeck.add(playerDeck.get(i));
							System.out.println("Player keeps the " + playerDeck.get(i).getCardName());
							computerWinDeck.add(computerDeck.get(i));
							System.out.println("Computer keeps the " + computerDeck.get(i).getCardName());
							System.out.println();
						}
						doublewarRetreat=false;
						playerTopCardValue = null;
					}
				}

				// NON WAR GAME PLAY
				if (playerTopCardValue != null) {

					int playerTopCardValueInt = (int) playerTopCardValue;
					int computerTopCardValueInt = (int) computerTopCardValue;

					if (playerTopCardValueInt > computerTopCardValueInt) {
						playerScore++;
						System.out.println("Player wins with " + playerDeck.get(i).getCardName());
						System.out.println("Computer lost with " + computerDeck.get(i).getCardName());
						System.out.println();
						playerWinDeck.add(playerDeck.get(i));
						playerWinDeck.add(computerDeck.get(i));
					} else if (computerTopCardValueInt > playerTopCardValueInt) {
						computerScore++;
						System.out.println("Computer wins with " + computerDeck.get(i).getCardName());
						System.out.println("Player lost with " + playerDeck.get(i).getCardName());
						System.out.println();
						computerWinDeck.add(playerDeck.get(i));
						computerWinDeck.add(computerDeck.get(i));
					}
				}
			}
			// add remaining cards of larger deck into their win deck
			if (playerDeck.size() > computerDeck.size()) {
				for (int j = iValue + 1; j < playerDeck.size(); j++) {
					playerWinDeck.add(playerDeck.get(j));
				}  
			} else if (playerDeck.size() < computerDeck.size()) {
				for (int j = iValue + 1; j < computerDeck.size(); j++) {
					computerWinDeck.add(computerDeck.get(j));
				}
			} 

			// in case any wars end with a double war triggered on the last card
			// of a deck, the accumulated warDeck is divided evenly among both players.
			// Super rare, but possible the game ends when 1 player runs out of cards 
			// triggering a double war with their last card... or should they lose?

			if (warWinDeck.size() != 0) {
				Collections.shuffle(warWinDeck);
				for (int k = 0 ; k < warWinDeck.size(); k++) {
					if (k % 2 == 0) {
						playerWinDeck.add(warWinDeck.get(k));
					} else {
						computerWinDeck.add(warWinDeck.get(k));
					}
				}
			}
			warWinDeck = new ArrayList<>();
			doublewarRetreat=false;
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

			System.out.println("**************************************");
			System.out.println("Round: " + rounds);
			System.out.println("**************************************");
			System.out.println("Player Score: " + playerScore);
			System.out.println("Player Cards: " + playerDeck.size());
			System.out.println("Computer Score: " + computerScore);
			System.out.println("Computer Cards: " + computerDeck.size());
			System.out.println("Wars: " + wars);
			System.out.println("Double Wars: " + doubleWars);
			System.out.println("**************************************");
			System.out.println();
			Collections.shuffle(playerDeck);
			Collections.shuffle(computerDeck);
		} 
		if (playerDeck.size() > 0) {
			System.out.println("PLAYER has won the WAR!\n");
		} else {
			System.out.println("COMPUTER has won the WAR!\n");
		}
		System.out.println("This WAR game took " + turns + " battles!" );
	}
	

	public void makeTwoWarDecks(List<Card> shuffledDeck) {
		playerDeck = new ArrayList<>();
		computerDeck = new ArrayList<>();
		int i = 1;
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
}
