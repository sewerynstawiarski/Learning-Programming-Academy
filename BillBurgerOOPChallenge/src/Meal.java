public class Meal {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

   public  Meal() {
        this.burger = new Burger("Basic", 5);
        this.drink = new Drink("Cola", "Normal", 5);
        this.sideItem = new SideItem("Fries" ,  1.5);
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", sideItem=" + sideItem +
                '}';
    }

    public void totalAmount(Meal meal) {
        System.out.printf("List of items: %n" +
                "%s : %.2f %n" +
                "%s of size %s: %.2f %n" +
                "%s: %.2f %n " +
                        "Total amount is: %.2f", meal.burger.getType(), meal.burger.getPrice(), meal.drink.getType(), meal.drink.getSize(), meal.drink.getPrice(),
                meal.sideItem.getType(), meal.sideItem.getPrice(),
                (meal.burger.getPrice() + meal.drink.getPrice() + meal.sideItem.getPrice())
                );
    }
    public void changeSizeOfTheDrink(String size) {
       drink.setSize(size);
       drink.setPrice(
               switch (size) {
                   case "Normal" -> drink.getPrice() ;
                   case "Small" -> drink.getPrice() * 0.8;
                   case "Big" -> drink.getPrice() * 1.2;

                   default -> throw new IllegalStateException("Unexpected value: " + size);
               }
       );
    }
}
