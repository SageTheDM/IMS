public class App {
    public static void main(String[] args) throws Exception {
        Person.counter = 10;
        Person p1 = new Person("Peter");
        Person p2 = new Person("Hanna");

        Person.tuWas();

        System.out.println(Math.sin(45));
    }
}
