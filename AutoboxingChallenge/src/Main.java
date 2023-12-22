public class Main {
    public static void main(String[] args) {
Customer customer = new Customer("Adam");
Bank bank = new Bank("Oleole");

bank.addNewCustomer(customer);

bank.addTransaction(customer, 100);
        bank.addTransaction(customer, 67);
        bank.addTransaction(customer, -43);
        bank.addTransaction(customer, 76.99);
        bank.addTransaction(customer, 1.44);
        bank.addTransaction(customer, -5.45);
        bank.addTransaction(customer, 76);
        bank.addTransaction(customer,  0.12);

       bank.printCustomer(customer);

    }
}
