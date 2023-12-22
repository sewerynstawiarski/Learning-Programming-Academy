import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
  inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long average = 0;
        int loopCount = 1;

        try {
            while (true) {
                    int number = Integer.parseInt(scanner.nextLine());
                    sum += number;
                    average = Math.round( ((double) sum / loopCount));
                    loopCount++;
                }


        } catch (NumberFormatException nfe) {
            System.out.println("SUM = " + sum + " AVG = " + average);
        }
    }
}
