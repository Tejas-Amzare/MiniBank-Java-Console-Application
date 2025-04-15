import java.io.*;
import java.util.*;

public class Bank {

    private Map<String, User> users = new HashMap<>();
    private final String FILE_PATH = "user.txt";
    private Scanner scanner = new Scanner(System.in);

    public void CreateAccount() {
        System.out.println("Enter Username :- ");
        String Username = scanner.next();
        if (users.containsKey(Username)) {
            System.out.println("User already exist. ");
            return;
        }
        System.out.println("Set 4-digite PIN :- ");
        String pin = scanner.next();
        if (pin.length() != 4) {
            System.out.println("PIN must be 4 digits. ");
            return;
        }
        User user = new User(Username, pin, 0.0);
        users.put(Username, user);
        System.out.println("Account created succesfully! ");
    }

    public void login() {
        System.out.println("Enter Username :- ");
        String Username = scanner.next();
        System.out.println("Enter PIN :- ");
        String pin = scanner.next();

        if (users.containsKey(Username)) {
            User user = users.get(Username);
            if (user.getpin().equals(pin)) {
                userDashboard(user);
            } else {
                System.out.println("Incorect PIN .");
            }
        } else {
            System.out.println("User not found. ");
        }
    }

    private void userDashboard(User user) {
        while (true) {
            System.out.println("\n--- Welcome, " + user.getUsername() + " ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter amount to deposit :- ");
                    double amount = scanner.nextDouble();
                    user.deposit(amount);
                    System.out.println("Deposited ₹" + amount);
                }
                case 2 -> {
                    System.out.println("Enter amount to withdraw:- ");
                    double amount = scanner.nextDouble();
                    if (user.withdraw(amount)) {
                        System.out.println("Withdraw Rs." + amount);
                    } else {
                        System.out.println("Insufficient Balence.");
                    }
                }
                case 3 -> System.out.println("Balance out."+user.getBank_Balance());
                case 4 -> {
                    System.out.println("Logged out.");
                    return;
                }

                default -> System.out.println("Invalid options.");

            }

        }
    }

    public void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists())
            return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String Username = parts[0];
                    String pin = parts[1];
                    double Balance = Double.parseDouble(parts[2]);
                    users.put(Username, new User(Username, pin, Balance));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data. ");
        }

    }

    public void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users.values()) {
                bw.write(user.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }
}