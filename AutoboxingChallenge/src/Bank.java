import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addNewCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        } else {
            System.out.println("This customer already exists in the bank data");
        }
    }

    public void addTransaction(Customer customer, double amount) {
        customer.getTransactions().add(amount);
    }

    public void printCustomer(Customer customer) {
        System.out.println(customer.toString());
    }
}
