package bank;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private final int routingNumber;
    private static long lastTransactionId = 10_000_000;
    private final  Map<String, BankCustomer> customers;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }
    public boolean addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        BankCustomer bankCustomer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        if (customers.put(bankCustomer.getCustomerId(), bankCustomer) == null) return true;
        else {
            System.out.println("New customer wasn't added");
            return false;
        }
    }
    public void doTransaction(String id, BankAccount.AccountType type, double amount) {
        if (customers.get(id).getAccount(type).commitTransaction(routingNumber, lastTransactionId, id, amount)) {
            System.out.println("Transaction was successful");
        } else {
            System.out.println("Something went wrong with the transaction");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "routingNumber=" + routingNumber +
                ", customers=" + customers +
                '}';
    }
}
