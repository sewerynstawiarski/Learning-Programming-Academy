package lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ProducerThreadFactory implements ThreadFactory {
    public ProducerThreadFactory() {
    }

    @Override
    public Thread newThread(Runnable r) {
       Thread producer = new Thread(r);
       producer.setName("\u001B[34mProducer");
       return producer;
    }
}
public class Main {
    public static void main(String[] args) {
        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();
        Random random = new Random();

        var producerExecutor = Executors.newSingleThreadExecutor(new ProducerThreadFactory());
        producerExecutor.execute(() -> {
            List<String> shoesTypes = new ArrayList<>(ShoeWarehouse.productsList);
            List<Order> orders =  new ArrayList<>();
            for ( int i = 0; i < 15; i++) {
                Order newOrder = new Order(i, shoesTypes.get(random.nextInt(0, shoesTypes.size())),
                        random.nextInt(1,10));
                orders.add(newOrder);
            }
            orders.forEach(order -> {
//                try {
//                    Thread.sleep(random.nextInt(0, 100));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                shoeWarehouse.receiveOrder(order);
            });
        });
        var consumerExecutor =  shoeWarehouse.getConsumerThreads();

        for (int i = 0; i < 15; i++) {
            consumerExecutor.execute(() -> {
                shoeWarehouse.fulfillOrder();
            });
        }
        producerExecutor.shutdown();
        consumerExecutor.shutdown();
    }
}
