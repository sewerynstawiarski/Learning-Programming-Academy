package lpa;

public class CustomThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i<=5; i++) {
            System.out.print(" 1 ");
            try {
                Thread.sleep(500); // half second break
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
