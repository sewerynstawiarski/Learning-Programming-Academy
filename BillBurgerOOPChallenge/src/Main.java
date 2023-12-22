public class Main {
    public static void main(String[] args) {
        Burger burgerAW = new Burger("Cheeseburger", 12);
        Drink pepsi = new Drink("Pepsi", "Big", 5);
        SideItem nachos =  new SideItem("Nachos", 3);

Meal meal = new Meal(burgerAW, pepsi, nachos);

        System.out.println(meal);

        ExtraTopping tomato = new ExtraTopping("Tomato", 1.5);
        ExtraTopping mayo = new ExtraTopping("Mayo" , 1.7);
        ExtraTopping doubleCheese = new ExtraTopping("Double cheese", 3.4);
        ExtraTopping avocado = new ExtraTopping("Avocado", 2.5);
        ExtraTopping bacon = new ExtraTopping("Bacon", 2.3);

        burgerAW.addExtraTopping(tomato);
        burgerAW.addExtraTopping(bacon);
        burgerAW.addExtraTopping(mayo);



        meal.changeSizeOfTheDrink("Small");
        meal.totalAmount(meal);



//        System.out.println(meal.toString());

//        DeluxeBurger deluxeBurger = new DeluxeBurger();
//       Meal deluxeMeal = deluxeBurger.createDeluxeBurgerMeal(deluxeBurger);
//        deluxeBurger.addExtraTopping(mayo);
//        deluxeBurger.addExtraTopping(bacon);
//        deluxeBurger.addExtraTopping(avocado);
//        deluxeBurger.addExtraTopping(doubleCheese);
//        deluxeBurger.addExtraTopping(tomato);
//        deluxeBurger.addExtraTopping(bacon);
//
//
//        System.out.println(deluxeBurger);
//        Meal deluxeMeal = deluxeBurger.createDeluxeBurgerMeal(deluxeBurger);
//        deluxeMeal.totalAmount(deluxeMeal);


;
    }
}
