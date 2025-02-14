import java.util.Scanner;

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int correctPIN = 1234;
        double balance = 3000;
        
        try {
            System.out.print("Please enter your PIN: ");
            int enteredPIN = scanner.nextInt();
            
            if (enteredPIN != correctPIN) {
                throw new SecurityException("Oops! Incorrect PIN.");
            }

            System.out.print("How much would you like to withdraw? ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Sorry, you don't have enough funds. Current balance: " + balance);
            }

            balance -= withdrawAmount;
            System.out.println("Withdrawal successful! Your remaining balance is: " + balance);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again.");
        } finally {
            System.out.println("Your current balance is: " + balance);
            scanner.close();
        }
    }
}
