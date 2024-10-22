public class Person {
    private String name;
    private double balance;

    Person(String person, double money) {
        name = person;
        balance = money;
    }

    boolean validTransaction(double money) {
        if (balance + money >= 0) {
            balance += money;
            return true;
        } else
            return false;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    double getBalance() {
        return balance;
    }
}