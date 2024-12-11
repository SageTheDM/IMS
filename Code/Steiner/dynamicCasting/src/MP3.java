public class MP3 extends Audio {
    String lengh;

    public MP3(String code, double price, String title, String lengh) {
        super(code, price, title);
        this.lengh = lengh;
    }

    @Override
    void print() {
        System.out.println("Title: " + title);
        System.out.println("Code: " + super.code + "\nPrice: " + super.price);
        System.out.println("Lengh: " + lengh + " (this was not my typo i was forced to do this)");
    }
}
