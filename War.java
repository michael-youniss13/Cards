import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class War{
	private static Deck deck = new Deck(false);
	private static Queue<Card> player1 = new LinkedList<Card>();
	private static Queue<Card> player2 = new LinkedList<Card>();
	private static int count;

	public War(){
		// Improvements to make...
	}

	public static void main(String[] args){
		System.out.println("Please Type 'play' then click enter to play.");
		count = 0;
		deck.shuffleDeck();
		deal();
		Scanner scanner = new Scanner(System.in);
		while(player1.size() != 52 && player1.size() != 0){
			String playerInput = scanner.nextLine();
			if(playerInput.equals("play")){
				play();
				count ++;
			} else {
				System.out.println("GAME OVER");
				break;
			}
			System.out.println("YOU HAVE "+ player1.size() +" CARDS");
		}
		System.out.println(count + " TURNS WERE PLAYED");
		System.out.println("YOU ENDED WITH "+ player1.size() + " CARDS : " + player1);
		if(player1.size() == 52) {
			System.out.printlng("YOU ARE THE WINNER!!");
		} else if (player1.size() == 0) {
			System.out.println("YOU LOST! BETTER LUCK NEXT TIME");
		} else {
			System.out.println("YOU GAVE UP BEFORE A WINNER WAS DETERMINED!");
		}
	}

	public static void deal(){
		Iterator<Card> itr = deck.iterator();
		boolean player1Card = true;
		while(itr.hasNext()){
			Card cardToAdd = itr.next();
			if(player1Card){
				player1.add(cardToAdd);
				player1Card = false;
			} else {
				player2.add(cardToAdd);
				player1Card = true;
			}
		}
	}

	public static void play(){
		Card player1NextCard = player1.poll();
		Card player2NextCard = player2.poll();
		compare(player1NextCard, player2NextCard, null, null);
	}

	public static void compare(Card player1NextCard, Card player2NextCard, Queue<Card> player1WarOffering, Queue<Card> player2WarOffering){
		if(player1NextCard.returnValue() > player2NextCard.returnValue()){
			player1.add(player1NextCard);
			player1.add(player2NextCard);
			addQueue(player1, player1WarOffering);
			addQueue(player1, player2WarOffering);
			System.out.println("YOU WON THE LAST HAND! YOU PLAYED A " + player1NextCard + " AND THE COMPUTER PLAYED A " + player2NextCard);
		}else if(player1NextCard.returnValue() < player2NextCard.returnValue()){
			player2.add(player2NextCard);
			player2.add(player1NextCard);
			addQueue(player2, player2WarOffering);
			addQueue(player2, player1WarOffering);
			System.out.println("YOU LOST THE LAST HAND! YOU PLAYED A " + player1NextCard + " AND THE COMPUTER PLAYED A " + player2NextCard);
		}else{
			if(player1WarOffering == null){
				player1WarOffering = new LinkedList<Card>();
			}
			if(player2WarOffering == null){
				player2WarOffering = new LinkedList<Card>();
			}
			player1WarOffering.add(player1NextCard);
			player2WarOffering.add(player2NextCard);
			handleWar(player1WarOffering, player2WarOffering);
		}
	}

	public static void addQueue(Queue<Card> player, Queue<Card> offering){
		if(offering != null){
			player.addAll(offering);
		}
	}

	public static void handleWar(Queue<Card> player1WarOffering, Queue<Card> player2WarOffering){
		if(player1.size() >= 4 && player2.size() >= 4){
			for(int i = 0; i < 3; i++){
				player1WarOffering.add(player1.poll());
				player2WarOffering.add(player2.poll());
			}
		} else if(player1.size() >= 4 && player2.size() < 4){
			for(int i = 0; i < 3; i++){
				player1WarOffering.add(player1.poll());
			}
			while(player2.size() != 1){
				player2WarOffering.add(player2.poll());
			}

		} else if(player2.size() >= 4 && player1.size() < 4){
			for(int i = 0; i < 3; i++){
				player2WarOffering.add(player2.poll());
			}
			while(player1.size() != 1){
				player1WarOffering.add(player1.poll());
			}
		} else {
			while(player1.size() != 1){
				player1WarOffering.add(player1.poll());
			}
			while(player2.size() != 1){
				player2WarOffering.add(player2.poll());
			}
		}

		Card player1NextCard = player1.poll();
		Card player2NextCard = player2.poll();
		compare(player1NextCard, player2NextCard, player1WarOffering, player2WarOffering);
	}
}
