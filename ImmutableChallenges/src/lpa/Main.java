package lpa;

import bank.Bank;
import bank.BankAccount;
import bank.BankCustomer;
import devDTO.Transaction;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

//        BankCustomer joe = new BankCustomer("Joe", 500.00,1000.00);
//        System.out.println(joe);

//        List<BankAccount> accounts = joe.getAccounts();
//        accounts.clear();
//        System.out.println(joe);
        Bank myBank = new Bank(001);
        System.out.println(myBank.addCustomer("Joe", 100, 500));
        myBank.addCustomer("Jenny", 200, 450);
        myBank.addCustomer("Danny", 10000, 50000);
        System.out.println(myBank);

        myBank.doTransaction("000000010000000", BankAccount.AccountType.CHECKING, 200);
        myBank.doTransaction("000000010000002", BankAccount.AccountType.SAVINGS, -50);
        myBank.doTransaction("000000010000001", BankAccount.AccountType.CHECKING, -99);

        System.out.println(myBank);
        BankCustomer bankCustomer = myBank.getCustomer("000000010000000");
        System.out.println(bankCustomer);

        Map<Long, String> transactions = bankCustomer.getAccount(BankAccount.AccountType.CHECKING).getTransactions();
//        transactions.put(10000000L, new Transaction(001,000000010000000, 10101, 50));
        System.out.println(transactions);
        System.out.println("-".repeat(50));

//        for (var tx :
//                transactions.values()) {
//            tx.setCustomerId(2);
//            tx.setTransactionAmount(1000);
//        }
//        System.out.println(transactions);

        bankCustomer.getAccount(BankAccount.AccountType.CHECKING).getTransactions().clear();
        System.out.println("-".repeat(50));

        bankCustomer.getAccount(BankAccount.AccountType.CHECKING).getTransactions().forEach(((k, v) -> System.out.println(k + ": " + v)));

    }
}
