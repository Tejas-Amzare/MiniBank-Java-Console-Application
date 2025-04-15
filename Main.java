import java.util.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.loadUsers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n ====== Welcome to MiniBank ======");
            System.out.println("1.  Create Account");
            System.out.println("2.  Login");
            System.out.println("3.  Exit");
            System.out.println("Enter here your choice :- ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bank.CreateAccount();
                case 2 -> bank.login();
                case 3 -> {
                    System.out.println("Thank you for using Mini_Bank !.");
                    bank.saveUsers();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
            

        }
    }

}
