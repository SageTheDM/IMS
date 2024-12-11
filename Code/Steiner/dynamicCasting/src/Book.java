public class Book extends Article {
    String author;
    String title;

    public Book(String code, double price, String author, String title) {
        super(code, price);
        this.author = author;
        this.title = title;
    }

    @Override
    void print() {
        System.out.println(this.author + " - " + this.title);
        System.out.println("Code: " + super.code + "\nPrice: " + super.price);
    }
}
