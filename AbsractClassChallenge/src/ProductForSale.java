public abstract class ProductForSale {
    protected String type;

    private String name;
    private double price;
    private String description;

    public ProductForSale(String type,String name, double price, String description) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity*price;
    }
    public void printPricedLine(int quantity) {
        System.out.printf("%s %s:  %2d -  $%.2f%n", type, name, quantity, getPrice());
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public abstract void showDetails();

    @Override
    public String toString() {
        return String.format("%s -> %s: %.2f", type, name, price);
    }
}
