public class Customer {
    private String forname;
    private String surname;
    private String user;
    private String password;

    // Constructor
    public Customer(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // Login method: use .equals() for string comparison
    public boolean login(String user, String pass) {
        return this.user.equals(user) && this.password.equals(pass);
    }

    // #region Setter and Getters
    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
