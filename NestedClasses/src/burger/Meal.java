package burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Item burger;
    private Item drink;
    private Item side;
    private double conversionRate;




    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }
    public Meal(double conversionRate, List<String> toppings) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular", "burger", toppings);
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }
    public Meal(List<String> toppings) {
        this.conversionRate = 1;
        burger = new Burger("regular", "burger", toppings);
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }
    public double getTotal() {
        double toppingsPrice = 0;
        if (this.burger instanceof Burger b) {
            for (int i = 0; i < b.toppings.size(); i++) {
                toppingsPrice += b.toppings.get(i).price;
            }
        }
        double total = burger.price + drink.price + side.price + toppingsPrice;
        return Item.getPrice(total, conversionRate);
    }
    @Override
    public String toString() {
        if (this.burger instanceof Burger b) {
            return "%s%n%s%n%s%n%26s$%.2f".formatted(b.toString(), drink, side, "Total Due: ", getTotal());
        } else {
            return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ", getTotal());
        }
    }


    private class Item {
        private String name;
        private String type;
        private double price;
        public Item(String name, String type) {
          this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }
        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class  Burger extends Item {

        private List<Item> toppings;


        public Burger(String name, String type, List<String> toppings) {
            super(name, type);
            this.toppings = new ArrayList<>();
            for (String t :
                    toppings) {
                String nameOfTopping = t.toUpperCase();
                switch (nameOfTopping) {
                    case "MAYO" -> this.toppings.add(new Item("Mayonnaise", "Topping"));
                    case "KETCHUP" -> this.toppings.add(new Item("Ketchup", "Topping"));
                    case "MUSTARD" -> this.toppings.add(new Item("Mustard", "Topping"));
                    case "AVOCADO" -> this.toppings.add(new Item("Avocado", "Topping", 1.5));
                    case "EXTRA CHEESE" -> this.toppings.add(new Item("Extra cheese", "Topping", 2));
                    case "GARLIC SAUCE" -> this.toppings.add(new Item("Garlic Sauce", "Topping", 0.75));
                }
            }
        }

        public Burger(String name, String type, double price, List<String> toppings) {
            super(name, type, price);
            this.toppings = new ArrayList<>();
            for (String t :
                    toppings) {
                String nameOfTopping = t.toUpperCase();
                switch (nameOfTopping) {
                    case "MAYO" -> this.toppings.add(new Item("Mayonnaise", "Topping"));
                    case "KETCHUP" -> this.toppings.add(new Item("Ketchup", "Topping"));
                    case "MUSTARD" -> this.toppings.add(new Item("Mustard", "Topping"));
                    case "AVOCADO" -> this.toppings.add(new Item("Avocado", "Topping", 1.5));
                    case "EXTRA CHEESE" -> this.toppings.add(new Item("Extra cheese", "Topping", 2));
                    case "GARLIC SAUCE" -> this.toppings.add(new Item("Garlic Sauce", "Topping", 0.75));
                }
            }
        }
        public String toppingsToString(List<Item> toppings) {
            toppings =  this.toppings;
            StringBuilder sToReturn = new StringBuilder();
            for (Item i :
                    toppings) {
                String s = i.toString() + "\n";
                sToReturn.append(s);
            }
            return sToReturn.toString();
        }

        @Override
        public String toString() {
        StringBuilder itemized = new StringBuilder(super.toString());
        for (Item topping : toppings) {
        itemized.append("\n");
        itemized.append(topping);
 }
        return itemized.toString();
        }

        public List<Item> getToppings() {
            return toppings;
        }
    }
}
