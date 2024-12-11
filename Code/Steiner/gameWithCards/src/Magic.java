public abstract class Magic extends Card {
    private int cost;

    public Magic(String cardName, String cardDescription, int cost) {
        super(cardName, cardDescription);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public abstract void activate();
}