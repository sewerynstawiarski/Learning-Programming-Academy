package burger;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal USRegularMeal =  new Meal(0.68);
        System.out.println(USRegularMeal);

        Meal toppingsBurger = new Meal(0.5, addTopping("Mayo", "Garlic Sauce", "Extra Cheese", "Ketchup"));
        System.out.println(toppingsBurger);



    }
    public static List<String> addTopping(String... args) {
        List<String> toppings = new ArrayList<>();
        for (String s :
                args) {
            toppings.add(s);
        }
        return toppings;
    }
}
