import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoeWarehouse {
    public static List<String> productsList = new ArrayList<>(List.of(
            "MJ", "Galaxy", "Mars", "Pluto", "Venus", "Kobe", "Uranus"
    ));

    private LinkedList<Order> listOfOrders = new LinkedList<>();

    public ShoeWarehouse() {
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public static List<String> getProductsList() {
        return productsList;
    }

    public void setListOfOrders(LinkedList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    @Override
    public String toString() {
        return "Lis of products: " + productsList + "\n List of orders: " + listOfOrders;
    }

    public synchronized void receiveOrder(Order receivedOrder) {
        String thread = Thread.currentThread().getName();
        while (listOfOrders.size() > 1) {
            try {
                System.out.println(thread + " waiting, because maximum capacity of orders was reached!");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        listOfOrders.add(receivedOrder);
        notifyAll();
        System.out.println("Added: " + receivedOrder);
    }
    public synchronized void fulfillOrder() {
        String thread = Thread.currentThread().getName();
        while (listOfOrders.isEmpty()) {
            try {
                System.out.println(thread + " is waiting for new order to arrive");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println( thread + " is fulfilling: "  + listOfOrders.removeFirst());
        notifyAll();
    }
}
