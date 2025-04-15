import java.security.PublicKey;

public class User {
    private String Username;
    private String pin;
    private double Bank_Balance;

    public User(String Username, String pin, double Bank_Balance) {
        this.Username = Username;
        this.pin = pin;
        this.Bank_Balance = Bank_Balance;
    }

    public String getUsername() {
        return Username;
    }

    public String getpin() {
        return pin;
    }

    public double getBank_Balance() {
        return Bank_Balance;
    }

    public void deposit(double amount) {
        Bank_Balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= Bank_Balance) {
            Bank_Balance -= amount;
            return true;
        }
        return false;

    }

    public String toFileString() {
        return Username + " ' " + pin + " , " + Bank_Balance;
    }

   

   
}
