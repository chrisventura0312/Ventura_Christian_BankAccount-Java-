import java.util.Locale;
import java.text.NumberFormat;

public class BankAccount {
    public static final String CHECKING_ACCOUNT = "checking";
    public static final String SAVINGS_ACCOUNT = "savings";

    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney;
    private String accountName;
    private Long accountNumber;

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountName = "Account " + (accounts + 1);
        this.accountNumber = generateAccountNumber() ;
        accounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance, String accountName) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountName = accountName;
        this.accountNumber = generateAccountNumber();
        accounts++;
        totalMoney += checkingBalance + savingsBalance;
    }

    // getters 
    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public String getAccountName() {
        return this.accountName;
    }

    // setters
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // methods
        private Long generateAccountNumber() {
    return (long) (Math.random() * 1000000000);
    }

    public void deposit(double amount, String account) {
        if (account.equals(CHECKING_ACCOUNT)) {
            this.checkingBalance += amount;
            totalMoney += amount;
            System.out.println("\n" + accountName + "\n" + "Deposited $" + amount + " into checking account");
            System.out.println("New Checking Balance: " + formatBalance(this.checkingBalance));
        } else if (account.equals(SAVINGS_ACCOUNT)) {
            this.savingsBalance += amount;
            totalMoney += amount;
            System.out.println( "\n" + accountName + "\n" + "Deposited $" + amount + " into savings account");
            System.out.println("New Savings Balance: " + formatBalance(this.checkingBalance));
        } else {
            System.out.println("Invalid account type");
        }
    }

    public void withdraw(double amount, String account) {
        if (account.equals(CHECKING_ACCOUNT)) {
            if (this.checkingBalance < amount) {
                System.out.println("Insufficient funds");
                return;
            } else {
                this.checkingBalance -= amount;
                totalMoney -= amount;
                System.out.println( "\n" + accountName + "\n" + "Withdrew $" + amount + " from checking account");
                System.out.println("New Checking Balance: " + formatBalance(this.checkingBalance));
            }
        } else if (account.equals(SAVINGS_ACCOUNT)) {
            if (this.savingsBalance < amount) {
                System.out.println("Insufficient funds");
                return;
            } else {
                this.savingsBalance -= amount;
                totalMoney -= amount;
                System.out.println("\n" + accountName + "\nWithdrew $" + amount + " from savings account");
                System.out.println("New Savings Balance: " + formatBalance(this.savingsBalance));
            }
        } else {
            System.out.println("Invalid account type");
        }
    }
    

    public String getBalance(String account) {
        if (account.equals(CHECKING_ACCOUNT)) {
            return formatBalance(this.checkingBalance);
        } else if (account.equals(SAVINGS_ACCOUNT)) {
            return formatBalance(this.savingsBalance);
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
    }

    private static String formatBalance(double balance) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(balance);
    }

    public String getAccountDetails() {
        return String.format("Account Name: %s\nChecking Balance: %s\nSavings Balance: %s\nAccount Number: %d\n", this.accountName, formatBalance(this.checkingBalance), formatBalance(this.savingsBalance), this.accountNumber);
    }
}

