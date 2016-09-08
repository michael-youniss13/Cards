import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Deck implements Iterable<Card>{
	private List<Card> deck = new ArrayList<Card>();

	public Deck(boolean aceLow){
		//add spades to the deck
		String[] suitNames  = {"SPADE", "HEART", "CLUB", "DIAMOND"};
		if(aceLow){
			for(String suit : suitNames){
				for(int i = 1; i <= 13; i++){
					Card cardToAdd = new Card(suit, i);
					deck.add(cardToAdd);
				}
			}
		} else {
			for(String suit : suitNames){
				for(int i = 2; i <= 14; i++){
					Card cardToAdd = new Card(suit, i);
					deck.add(cardToAdd);
				}
			}
		}
	}

	public void printDeck(){
		for(Card c: deck){
			System.out.println(c);
		}
	}

	public void shuffleDeck(){
		for(int i = 1; i < deck.size(); i++){
			Card cardAt_i = deck.get(i);
			int indexToSwitch = (int) Math.round(i*Math.random());
			Card cardToSwitch = deck.get(indexToSwitch);
			deck.set(i, cardToSwitch);
			deck.set(indexToSwitch, cardAt_i);
		}
	}

	public Iterator<Card> iterator(){
		return deck.iterator();
	}
}