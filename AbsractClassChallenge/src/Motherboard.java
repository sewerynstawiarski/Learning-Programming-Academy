public class Motherboard extends ProductForSale{


    public Motherboard(String type, String name, double price, String description) {
        super(type, name, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(getDescription());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
