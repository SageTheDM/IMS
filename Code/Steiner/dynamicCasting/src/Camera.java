public class Camera extends Article {
    String brand;

    public Camera(String code, double price, String brand) {
        super(code, price);
        this.brand = brand;
    }

    @Override
    void print() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Code: " + super.code + "\nPrice: " + super.price);
    }
}
