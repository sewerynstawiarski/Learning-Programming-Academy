import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


record OrderItem(int quantity, ProductForSale productForSale) {
    @Override
    public String toString() {
        return String.format("%d %s: %.2f%n", quantity, productForSale.type, productForSale.getPrice());
    }
}


public class Store {
    public static void main(String[] args) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        ArrayList<ProductForSale> productForSales =new ArrayList<>();

        Motherboard AsusMotherboard = new Motherboard("Motherboard", "Asus", 200, "Perfect motherboard for your home office!");
        GraphicCard GeForceGraphicCard = new GraphicCard("GraphicCard", "GTX3060", 1500, "The most effective graphic card for gamers!");
        Headphones HiFiManHeadphones = new Headphones("Heaphones", "Sundara", 1000, "The cleanest sound ever!");

        productForSales.addAll(List.of(GeForceGraphicCard, HiFiManHeadphones,AsusMotherboard));

        OrderItem motherboardOrder = new OrderItem(1, AsusMotherboard);
        OrderItem headphonesOrder = new OrderItem(2, HiFiManHeadphones);

        orderItems.addAll(List.of(motherboardOrder, headphonesOrder));

        printOrderedItems(orderItems);

addItemToTheOrder(orderItems, GeForceGraphicCard, 5);

printOrderedItems(orderItems);
ListOfProductsForSale(productForSales);

    }
    private static void addItemToTheOrder(ArrayList<OrderItem> orderItems, ProductForSale productForSale, int quantity) {
        for (var item :
                orderItems) {
            if (item.productForSale().type.equalsIgnoreCase(productForSale.type)) {
                return;
            }
            }
        orderItems.add(new OrderItem(quantity, productForSale));
    }

    private static void printOrderedItems(ArrayList<OrderItem> orderItems) {
        System.out.println("Ordered items list: ");
        System.out.println("-".repeat(10));
        double sumPrice = 0;
        for (var item :
                orderItems) {
            item.productForSale().printPricedLine(item.quantity());
            sumPrice = sumPrice + item.productForSale().getPrice();
        }
        System.out.println("-".repeat(10));
        System.out.println("TOTAL: " + sumPrice);

    }

    private static void ListOfProductsForSale(ArrayList<ProductForSale> listOfProductsForSale) {
        for (var item : listOfProductsForSale
                ) {
            System.out.println(item.toString());
            item.showDetails();
        }
    }
}
