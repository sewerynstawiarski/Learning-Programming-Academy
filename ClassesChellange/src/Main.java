import java.lang.reflect.AccessibleObject;

public class Main {
    public static void main(String[] args) {
//   BankAccount bankAccount = new BankAccount("Seweryn", 666050334, 1001, 10000, "sewek151@gmail.com");
        BankAccount bankAccount = new BankAccount();
//    bankAccount.setCustomerName("Seweryn");
//    bankAccount.setCustomerPhoneNumber(666050334);
//    bankAccount.setAccountNumber(1001);
//    bankAccount.setAccountBalance(10000);
//    bankAccount.setCustomerEmail("sewek151@gmail.com");

        System.out.println(bankAccount.getAccountNumber());
        System.out.println(bankAccount.getAccountBalance());

    bankAccount.deposit(300);
    bankAccount.withdraw(300);
    bankAccount.withdraw(11000);
    bankAccount.withdraw(45.34);
    bankAccount.withdraw(9954.66);

    BankAccount bankAccount1 = new BankAccount("Daniel", "daniek@wp.pl", 123456789);

        System.out.println("Account number: " + bankAccount1.getAccountNumber() + "; name " +  bankAccount1.getCustomerName() + " and balance is " + bankAccount1.getAccountBalance());
        System.out.println();

        Customer bob = new Customer("Bob", 500, "bob@wp.pl");
        Customer anna = new Customer();
        Customer yuki = new Customer("Yuki", "yuki@wp.pl");

        System.out.println("New customer is: " + bob.getName() + " with credit limit of " + bob.getCreditLimit() + " and emaill adress: " + bob.getEmailAdress());
        System.out.println("New customer is: " + anna.getName() + " with credit limit of " + anna.getCreditLimit() + " and emaill adress: " + anna.getEmailAdress());
        System.out.println("New customer is: " + yuki.getName() + " with credit limit of " + yuki.getCreditLimit() + " and emaill adress: " + yuki.getEmailAdress());

    }
}
