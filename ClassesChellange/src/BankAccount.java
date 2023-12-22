public class BankAccount {

    private int accountNumber;
    private double accountBalance;
    private String customerName = "";
    private String customerEmail = "";
    private int customerPhoneNumber;

    public BankAccount() {
        this("Unknown", 000000000, 0000, 0, "Unknown");
        System.out.println("Empty constructor called");
    }
    public BankAccount (String customerName, int customerPhoneNumber, int accountNumber, double accountBalance,  String customerEmail) {
        System.out.println("Account contstructor with parameters called");

        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerEmail = customerEmail;

    }


    public BankAccount(String customerName, String customerEmail, int customerPhoneNumber) {
        this(customerName, customerPhoneNumber, 9999, 100000, customerEmail);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void deposit (double depositAmount ) {
        if (depositAmount <= 0) {
            System.out.println("Invalid Number");
        }
        accountBalance = accountBalance + depositAmount;
        System.out.println("Thank you, " + customerName + "! You deposited: " + depositAmount + ". Your new account balance is: " + accountBalance + ". Have a nice day!");
    }
    public void withdraw (double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid number");
        }
        if (accountBalance - withdrawAmount < 0) {
            System.out.println("You don't have enough money to withdraw: " + withdrawAmount + " ! Your current account balance is: " + accountBalance);
        } else {
            accountBalance = accountBalance - withdrawAmount;
            System.out.println("Thank you, " + customerName + "! You withdrew: " + withdrawAmount + ". Your new account balance is: " + accountBalance + ". Have a nice day!");
        }
    }
}
