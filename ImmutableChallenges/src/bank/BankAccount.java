package bank;

import devDTO.Transaction;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {


    public enum AccountType {CHECKING, SAVINGS}

    ;
    private final AccountType accountType;
    private double balance;

    private Map<Long, Transaction> transactions;

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
        this.transactions =  new HashMap<>();
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Long, String> getTransactions() {
        if (transactions != null) {
            Map<Long, String> txMap = new LinkedHashMap<>();
            for (var tx :
                    transactions.entrySet()) {
                txMap.put(tx.getKey(), tx.getValue().toString());
            }
            return txMap;
        } else {
            System.out.println("transactions are null");
            return null;
        }
    }


    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }
  protected boolean commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
         boolean deposit = amount >= 0;
         if(deposit) {
             if (transactions.put(transactionId,
                     new Transaction(routingNumber, Integer.parseInt(customerId), transactionId, amount)) == null) {
                    balance += amount;
                    return true;
             }  else {
                 System.out.println("There is other value under this key: " + transactionId);
                 return false;
             }
         } else {
             if (transactions.put(transactionId,
                     new Transaction(routingNumber, Integer.parseInt(customerId), transactionId, amount)) == null) {
                if ((balance + amount) >= 0) {
                  balance+=amount;
                  return true;
              } else {
                  System.out.println("Not enough money!");
                  return false;
              }
             }
             else {
                 System.out.println("There is other value under this key: " + transactionId);
                 return false;
             }
         }
  }
}
