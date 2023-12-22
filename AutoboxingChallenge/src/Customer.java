import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public String getName() {
        return name;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + ": \n" + transactions;
    }
}
