package lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ConsumerThreadFactory implements ThreadFactory {
    private static int id = 1;
    public ConsumerThreadFactory() {
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread consumer = new Thread(r);
        consumer.setName("\u001B[31mConsumer " + id++);
        return consumer;
    }
}
public class ShoeWarehouse {
    public static List<String> productsList = new ArrayList<>(List.of(
            "MJ", "Galaxy", "Mars", "Pluto", "Venus", "Kobe", "Uranus"
    ));

    private LinkedList<Order> listOfOrders;
    private ExecutorService consumerThreads;

    public ShoeWarehouse() {
        listOfOrders = new LinkedList<>();
        consumerThreads = Executors.newFixedThreadPool(3, new ConsumerThreadFactory());
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

    public ExecutorService getConsumerThreads() {
        return consumerThreads;
    }

    @Override
    public String toString() {
        return "Lis of products: " + productsList + "\n List of orders: " + listOfOrders;
    }

    public synchronized void receiveOrder(Order receivedOrder) {
        String thread = Thread.currentThread().getName();
        while (listOfOrders.size() > 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(thread + " waiting, because maximum capacity of orders was reached!");
        }
        listOfOrders.add(receivedOrder);
        notifyAll();
        System.out.println(thread + " Added: " + receivedOrder);
    }

    public synchronized void fulfillOrder() {
        String thread = Thread.currentThread().getName();
        Random random = new Random();

        while (listOfOrders.isEmpty()) {
            try {
                System.out.println(thread + " is waiting for new order to arrive");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(thread + " is fulfilling: " + listOfOrders.removeFirst());
        notifyAll();

    }
}
