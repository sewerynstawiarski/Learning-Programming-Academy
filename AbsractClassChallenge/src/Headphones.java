public class Headphones extends ProductForSale{


    public Headphones(String type, String name, double price, String description) {
        super(type, name, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(getDescription());
    }
}
