import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();
        Random random = new Random();

        Thread Producer =  new Thread(() -> {
            List<String> shoesTypes = new ArrayList<>(ShoeWarehouse.productsList);
            List<Order> orders =  new ArrayList<>();
            for ( int i = 0; i < 10; i++) {
                Order newOrder = new Order(i, shoesTypes.get(random.nextInt(0, shoesTypes.size())),
                        random.nextInt(1,10));
                orders.add(newOrder);
            }

            orders.forEach(order -> {
                try {
                    Thread.sleep(random.nextInt(200, 300));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shoeWarehouse.receiveOrder(order);
            });
        });

        Runnable consumer = () -> {
            try {
                for ( int i = 0; i < 5; i++) {
                    Thread.sleep(random.nextInt(5000, 7000));
                    shoeWarehouse.fulfillOrder();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread Consumer1 = new Thread(consumer);
        Thread Consumer2 = new Thread(consumer);

        Producer.setName("Producer");
        Consumer1.setName("Consumer1");
        Consumer2.setName("Consumer2");

        Producer.start();
        Consumer1.start();
        Consumer2.start();

    }
}
