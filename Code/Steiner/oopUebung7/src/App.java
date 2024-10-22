public class App {
    public static void main(String[] args) throws Exception {
        Person myPerson1 = new Person("Hans", 200);
        myPerson1.validTransaction(500);
        System.out.println(myPerson1.getBalance());
        myPerson1.setName("Luca");
        System.out.println(myPerson1.getName());
    }
}