public class Burger {
    private String type;
    private double price;
    private int extraToppingAvailable;

    public Burger() {
    }

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
        if (type.equals("DeluxeBurger")) {
            this.extraToppingAvailable = 5;
        }
        else {
            this.extraToppingAvailable = 3;
        }
    }

    public void addExtraTopping(ExtraTopping extraTopping) {
        if (extraToppingAvailable > 0){
            type = String.format(type + " for %.2f + %s %.2f", price, extraTopping.getType(), extraTopping.getPrice());
            price = price + extraTopping.getPrice();
            extraToppingAvailable -= 1;
        } else {
            System.out.println("Maximum topping elements reached");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getExtraToppingAvailable() {
        return extraToppingAvailable;
    }

    public void setExtraToppingAvailable(int extraToppingAvailable) {
        this.extraToppingAvailable = extraToppingAvailable;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", extraToppingAvailable=" + extraToppingAvailable +
                '}';
    }
}
