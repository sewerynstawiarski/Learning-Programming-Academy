import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
   private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> groceriesList = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            System.out.println("-".repeat(20));
//            printActions();
            System.out.println("Available actions:\n" +
                    "0 - to shutdown\n" +
                    "1 - to add item(s) to list (comma delimited list\n" +
                    "2 - to remove and items (comma delimited list\n" +
                    "Enter a number for which action yuo want to do:");

            int inputInt = scanner.nextInt();

            if (inputInt == 0) {
                System.out.println("Your grocery lis is: " + groceriesList);
                flag = false;
            }
            if (inputInt == 1) {
                System.out.println("Enter coma delimited list of things you want to add:");
//                String input = scanner.next();
                String[] inputStrings = scanner.next().split(",");

                for (var item :
                        inputStrings) {
                    if (groceriesList.contains(item)) {
                        System.out.println( item + " is already on the list");
                    } else {
                        groceriesList.add(item);
                    }
                }
                groceriesList.sort(Comparator.naturalOrder());
                System.out.println("Current grocery list is: " + groceriesList);
            }
            if (inputInt == 2) {
                System.out.println("Enter coma delimited list of things you want to remove:");
//                String input = scanner.next();
                String[] inputStrings = scanner.next().split(",");
                for (var item :
                        inputStrings) {
                    if (!groceriesList.contains(item)) {
                        System.out.println( item + " is not on the list, so cannot be deleted");
                    } else {
                        groceriesList.remove(item);
                    }
                }
                groceriesList.sort(Comparator.naturalOrder());
                System.out.println("Current grocery list is: " + groceriesList);
            }
        }
    }
//    private static void printActions() {
//        String textBlock = """
//                Available actions:
//                0 - to shutdown
//                1 - to add item(s) to list (comma delimited list)
//                2 - to remove and items (comma delimited list)
//                Enter a number for which action yuo want to do:
//                """;
//        System.out.print(textBlock + " ");
//    }
}
