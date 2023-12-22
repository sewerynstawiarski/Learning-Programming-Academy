package Challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankCustomer {
    private final String name;
    private final int id;
    private final List<BankAccount> accounts;

    public BankCustomer(String name, int id, List<BankAccount> accounts) {
        this.name = name;
        this.id = id;
        List<BankAccount> copied = new ArrayList<>(accounts);
        this.accounts = copied;
    }

    public BankCustomer(String name, int id) {
        this(name, id, null);
    }

    public BankCustomer(BankCustomer customer) {
        this(customer.getName(), customer.getId(), customer.getAccounts());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<BankAccount> getAccounts() {
        List<BankAccount> copied = new ArrayList<>(accounts);

        return accounts == null ? null : copied;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", accounts=" + accounts +
                '}';
    }
}
