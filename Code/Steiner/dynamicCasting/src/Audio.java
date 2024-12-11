public abstract class Audio extends Article {
    String title;

    public Audio(String code, double price, String title) {
        super(code, price);
        this.title = title;
    }

    abstract void print();

}
