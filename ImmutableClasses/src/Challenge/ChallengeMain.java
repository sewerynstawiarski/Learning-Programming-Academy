package Challenge;

import java.util.List;

public class ChallengeMain {
    public static void main(String[] args) {
        BankCustomer eddie = new BankCustomer("Ediie", 1, List.of(new BankAccount(BankAccount.Type.CHECKING, 100),
                new BankAccount(BankAccount.Type.SAVINGS, 200)));
        System.out.println(eddie);

        List<BankAccount> newList = eddie.getAccounts();
        newList.add(new BankAccount(BankAccount.Type.CHECKING, -100));
        System.out.println(eddie);

        BankCustomerSub subCustomer =  new BankCustomerSub(eddie);
        System.out.println(subCustomer);

        BankCustomerSub ron = new BankCustomerSub("Ron", 2, eddie.getAccounts());
        List<BankAccount> rons = ron.getAccounts();
        rons.add(new BankAccount(BankAccount.Type.SAVINGS, -1000));
        System.out.println(ron);
        System.out.println(eddie);
        BankAccount hacked = new BankAccount(BankAccount.Type.SAVINGS, -1000);
     ron.addAccount(hacked);
        System.out.println(ron);
        System.out.println(eddie);

    }
}
