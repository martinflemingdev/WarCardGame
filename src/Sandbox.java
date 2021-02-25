import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.techelevator.Card;

public class Sandbox {
	
	// instance variables
	List<Card> playerDeck;
	List<Card> computerDeck;
	List<Card> playerWinDeck;
	List<Card> computerWinDeck;
	int turns = 0;
	int iValue = 0;
	int playerScore = 0;
	int computerScore= 0;
	int wars = 0;
	int rounds = 0;
	

	
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
					//					playerScore++;
					//					computerScore++;
					//					playerWinDeck.add(playerDeck.get(i));
					//					computerWinDeck.add(computerDeck.get(i));
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
	public List<Card> getPlayerDeck() {
		return playerDeck;
	}

	public List<Card> getComputerDeck() {
		return computerDeck;
	}
}
