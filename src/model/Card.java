package termproj;

public class Card {
    String cardType;

    //Constructor
    Card(String cardType) {
	    setCardType(cardType);
    }

    Card() {
	cardType = "";
    }

    //getter
    String getCardType() {
	    return cardType;
    }

    //setter
    void setCardType(String cardType) {
	    this.cardType = cardType;
    }
}
