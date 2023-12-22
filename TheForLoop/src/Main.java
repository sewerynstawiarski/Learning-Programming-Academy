public class Main {
    public static void main(String[] args) {
        for (int counter = 1; counter <=5; counter++) {
            System.out.println(counter);
        }
        System.out.println("10,000 at 2 interes = " +calculateInterest(10000,2.0));

        for (double rate = 2.0; rate <= 5.0; rate++) {
            double interestAmount = calculateInterest(10000, rate);
            System.out.println("10,000 at " + rate + "% interest = " + interestAmount);

            for (double rate2 = 7.5; rate2 <= 10.0; rate2+=0.25) {
                double interestAmount2 = calculateInterest(100,rate2);
                if (interestAmount2 > 8.5) {
                    break;
                }
                System.out.println("100 at " + rate2 + "% is: " +interestAmount2);

            }
        }
    }

    public static double calculateInterest (double amount, double interestRate) {
        return (amount*(interestRate/100));
    }
}
