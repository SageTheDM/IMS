public abstract class Card {
    private String cardName;
    private String cardDescription;

    public Card(String cardName, String cardDescription) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public abstract void activate();
}