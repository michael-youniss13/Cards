# War
##by Michael Youniss

## How to play

  Download Card.java, Deck.java and War.java and put them in the same directory.<br>
  Open up a terminal and run `javac War.java` then `java War`. Then type `play` and hit enter to play. Enjoy!

### Card
  Card is the lowest level class built. Each instance of a Card class creates one Card object. Each Card object, like a normal playing card, has a value and suit. The Card class exposes three functions: `returnSuit()`, `returnValue()` and `toString()`.
  The first two methods are trivial, the final method formats a string for printing out a card during game play.

### Deck
  The Deck class is the next highest level class. A Deck object is a queue of 52 Cards, just like a normal deck of playing cards. Deck allows for either Ace High or Ace Low style game play. It exposes a `shuffle()` function to mix up the cards. Deck also exposes a `toString()` method so users can see a visualization of the deck.

### War
  The War class is the highest level class. The War class creates a game play environment. The War object will deal the cards out and wait for user input to play. The War class has methods that will compare cards and handle War situations. It might take a while, but the  War class will recognize a winner as well.
