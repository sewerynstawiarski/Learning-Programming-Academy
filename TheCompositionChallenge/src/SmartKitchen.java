public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public void addWater() {
        brewMaster.setHasWorkToDo(true);
    }
    public void pourMilk() {
        iceBox.setHasWorkToDo(true);
    }
    public void loadDishwasher(){
        dishWasher.setHasWorkToDo(true);
    }
    public void setKitchenState(boolean coffeeFlag, boolean fridgeFlag, boolean dishwasherFlag) {

            brewMaster.setHasWorkToDo(coffeeFlag);
            iceBox.setHasWorkToDo(fridgeFlag);
            dishWasher.setHasWorkToDo(dishwasherFlag);

    }

    public void doKitchenWork() {
    brewMaster.brewCoffee();
    iceBox.orderFood();
    dishWasher.doDishes();
    }
}

