public class Customer {

    private String name;
    private int creditLimit;
    private String emailAdress;

    public Customer(String name, int creditLimit, String emailAdress) {

        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAdress = emailAdress;
        System.out.println("Regular constructor called");
    }
    public Customer (String name, String emailAdress) {
        this(name, 0, emailAdress);
        System.out.println("Two arg constructor called");
    }
    public Customer() {
        this("Default name","email unknown");
        System.out.println("No arg constructor called");
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

}
