public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(250.00, 500.00, "My Account");
        BankAccount account3 = new BankAccount(300.00, 600.00, "Test Account");
        BankAccount account4 = new BankAccount();
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println(account1.getAccountName());
        System.out.println("Current Balance: " + account1.getBalance("checking"));
        account1.deposit(100, "checking");
        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        //System.out.println("Current Balance: " + account1.getBalance("checking"));
        account1.withdraw(50, "checking");
        //System.out.println("New Checking Balance: " + account1.getBalance("checking"));
        // Static Test (print the number of bank accounts and the totalMoney)
        //account2.withdraw(100, "a");
        account2.withdraw(100, "savings");
        System.out.println("\n\n" + account1.getAccountDetails());
        System.out.println("\n\n" + account2.getAccountDetails());
        System.out.println("\n\n" + account3.getAccountDetails());
        System.out.println("\n\n" + account4.getAccountDetails());
        
        System.out.println("Total Money: " + BankAccount.getTotalMoney());
        System.out.println("\n\nNumber of Accounts: " + BankAccount.getAccounts());
    }
}
