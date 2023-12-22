import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }
    private Branch findBranch(String nameofBranch) {
        for (var branch :
                branches) {
            if (branch.getName().equalsIgnoreCase(nameofBranch)) {
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String nameOfBranch) {
        if (findBranch(nameOfBranch) == null) {
            branches.add(new Branch(nameOfBranch));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {
            if (findBranch(nameOfBranch) == null) {
    return  false;
        }
            if (findBranch(nameOfBranch) != null) {
                for (int i = 0; i < branches.get(branches.indexOf(findBranch(nameOfBranch))).getCustomers().size(); i++) {
                    if (branches.get(branches.indexOf(findBranch(nameOfBranch))).getCustomers().get(i).getName().equalsIgnoreCase(nameOfCustomer)) {
                        return false;
                    }
                }
                branches.get(branches.indexOf(findBranch(nameOfBranch))).newCustomer(nameOfCustomer, initialTransaction);
            }
        return true;
        }
    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
        if (findBranch(nameOfBranch) == null) {
            return false;
        }
        if (findBranch(nameOfBranch) != null) {
            for (int i = 0; i < branches.get(branches.indexOf(findBranch(nameOfBranch))).getCustomers().size(); i++) {
                if (branches.get(branches.indexOf(findBranch(nameOfBranch))).getCustomers().get(i).getName().equalsIgnoreCase(nameOfCustomer)) {
                    branches.get(branches.indexOf(findBranch(nameOfBranch))).addCustomerTransaction(nameOfCustomer, transaction);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
        if (findBranch(nameOfBranch) == null) {
            return false;
        }
        Branch branch = findBranch(nameOfBranch);
        if (printTransactions) {
            System.out.println("Customer details for branch " + branch.getName());
            int index = 1;
            for (var customer :
                    branch.getCustomers()) {
                System.out.println("Customer: " + customer.getName() + "[" + index + "]\n" + "Transactions");
                index++;
                for (int i = 0;  i <  customer.getTransactions().size(); i++) {
                    System.out.println("[" + (i+1) +"]  Amount " + customer.getTransactions().get(i));
                }
            }
            return true;
        }
            if (!printTransactions) {
                System.out.println("Customer details for branch " + branch.getName());
                int index2 = 1;
                for (var customer :
                        branch.getCustomers()) {
                    System.out.println("Customer: " + customer.getName() + "[" + index2 + "]");
                    index2++;
                }
                return true;
            }
            return false;
        }
    }
