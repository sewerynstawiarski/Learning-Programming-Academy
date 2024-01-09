package challenge;


import java.util.concurrent.TimeUnit;

class First extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = 0;
    for (int i = 1; count < 5; i++) {
        if (i % 2 == 0) {
            count++;
            System.out.print(" " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("\n" + threadName + " Successfully interrupted");
                return;
            }
        }
    }
    }
}
public class ThreadChallenge {
    public static void main(String[] args) {

        Thread second = new Thread(() -> {
        String threadName =  Thread.currentThread().getName();
            int count = 0;
            for (int i = 1; count < 5; i++) {
                if (i % 2 != 0) {
                    count++;
                    System.out.print(" " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("\n" + threadName + " Successfully interrupted");
                        return;
                    }
                }
            }
        }, "second");

        First firstThread = new First();
        firstThread.setName("First");
        second.setName("Second");
        firstThread.start();
        second.start();

        if (second.isAlive()) {
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!second.isInterrupted()) {
                second.interrupt();
            }
        }

    }
}
