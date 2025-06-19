import java.util.Scanner;

// Class for Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double bal) {
        balance = bal;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposited: " + amt);
        } else {
            System.out.println("Invalid deposit.");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else if (amt > balance) {
            System.out.println("Not enough balance.");
        } else {
            System.out.println("Invalid withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Class for ATM machine
class ATM {
    BankAccount acc;

    public ATM(BankAccount a) {
        acc = a;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Balance: " + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    acc.deposit(d);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    acc.withdraw(w);
                    break;
                case 4:
                    System.out.println("Thanks for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (ch != 4);

        sc.close();
    }
}

// Main class with main method
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount(1000); // starting with 1000
        ATM atm = new ATM(myAcc);
        atm.menu();
    }
}

