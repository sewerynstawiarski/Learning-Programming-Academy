public class Main {
    public static void main(String[] args) {
Refrigerator refrigerator = new Refrigerator(false);
DishWasher dishWasher = new DishWasher(false);
CoffeeMaker coffeeMaker =new CoffeeMaker(false);

SmartKitchen smartKitchen = new SmartKitchen(coffeeMaker, dishWasher, refrigerator);

smartKitchen.addWater();
smartKitchen.getBrewMaster().brewCoffee();
smartKitchen.pourMilk();
smartKitchen.loadDishwasher();
smartKitchen.getIceBox().orderFood();
smartKitchen.getDishWasher().doDishes();
        System.out.println();
        smartKitchen.setKitchenState(true, false, true);
smartKitchen.doKitchenWork();


    }
}
