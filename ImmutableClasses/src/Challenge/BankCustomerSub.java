package Challenge;

import java.util.List;

public class BankCustomerSub extends BankCustomer {
    public BankCustomerSub(String name, int id) {
        super(name, id, List.of(new BankAccount(BankAccount.Type.CHECKING, 100)));

    }

    public BankCustomerSub(BankCustomer customer) {
        super(customer);
    }

    public BankCustomerSub(String name, int id, List<BankAccount> accounts) {
        super(name, id, accounts);
    }

    public void addAccount(BankAccount newAccount) {
        if (this.getAccounts() != null) {
            this.getAccounts().add(newAccount);
        }
    }
}
