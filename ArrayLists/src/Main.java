import java.util.ArrayList;
import java.util.Arrays;

record GroceryItems (String name, String type, int count) {
    public GroceryItems(String name) {
        this(name, "Dairy", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}


public class Main {
    public static void main(String[] args) {

        GroceryItems[] groceryArray = new GroceryItems[3];
        groceryArray[0] = new GroceryItems("milk");
        groceryArray[1] = new GroceryItems("apples", "Produce", 6);
        groceryArray[2] = new GroceryItems("oranges", "produce", 5);
        System.out.println(Arrays.toString(groceryArray));


        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItems("butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItems> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItems("butter"));
        groceryList.add(new GroceryItems("Milk"));
        groceryList.add(new GroceryItems("Oranges"));
        groceryList.set(0, new GroceryItems("apples", "Produce", 5));
        groceryList.remove(1);
        System.out.println(groceryList);
    }
}
