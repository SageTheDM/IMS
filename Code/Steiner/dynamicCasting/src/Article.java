public abstract class Article {
    String code;
    double price;

    public Article(String code, double price) {
        this.code = code;
        this.price = price;
    }

    boolean available() {
        boolean maybe = true;
        return maybe;
    }

    abstract void print();
}
