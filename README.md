# WarCardGame

Objective: I wanted to create the logic and objects to play a game of War using OOP principles in Java. 

## How I built the game:
* I created an abstract Card.class that the Heart, Spade, Diamond, and Clubs classes inherit. 
* This allowed me to create a polymorphic List<Card> to model a deck of cards that could include all 52 standard cards from the 4 suit classes. 
* Using a CSV file, a DeckBuilder class reads the cards into the program using the Scanner class and builds the Card objects, adding them to the main deck. 
* The deck is shuffled using the Collections.shuffle method.
* Wrote the logic to play War in the WarGame class. Includes all logic needed to display each battle with name and rank of cards, settle wars, and settle wars that stem from wars. 
* Also added logic in cases where 1 player has less than the 4 normal cards used in wars, so that they are able to use as many as their deck allows.
* Created console interface in the CLI class to allow user to display the deck, play the game where the user can hit Enter to drive the gameplay, or play a war that is automagically played.
* Each round ends with a report on how many battles, rounds, wars, and double wars occured. At the end of the game a winner is crowned and options are given to play again.
