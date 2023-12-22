public class DeluxeBurger extends Burger{



    public DeluxeBurger() {
        super("DeluxeBurger", 100);
    }

    @Override
    public void addExtraTopping(ExtraTopping extraTopping) {
       if (super.getExtraToppingAvailable() > 0){
           super.setType(String.format(getType() + " + %s ", extraTopping.getType()));
           super.setExtraToppingAvailable(getExtraToppingAvailable()-1);
       } else {
           System.out.println("Max amount of toppings reached");
       }
    }
    public Meal createDeluxeBurgerMeal(DeluxeBurger deluxeBurger) {
        Drink deluxeDrink = new Drink("AllYouCanDrink", "Normal", 0);
        SideItem deluxeSideItem = new SideItem("AllYouCanEat", 0);
        return new Meal(deluxeBurger, deluxeDrink, deluxeSideItem);
    }

}
