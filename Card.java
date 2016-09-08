public class Card{
	private int value;
	private String suit;

	public Card(String  suit, int value){
		this.suit = suit;
		this.value = value;
	}

	public int returnValue(){
		return this.value;
	}

	public String returnSuit(){
		return this.suit;
	}

	public String toString(){
		String stringValue = this.value + "";
		if(this.value > 10){
			if(this.value == 11){
				stringValue = "JACK";
			}else if(this.value == 12){
				stringValue = "QUEEN";
			}else if(this.value == 13){
				stringValue = "KING";
			}else if(this.value == 14){
				stringValue = "ACE";
			}
		} else if(this.value == 1){
			stringValue = "ACE";
		}
		return stringValue + " of " + this.suit;
	}
}