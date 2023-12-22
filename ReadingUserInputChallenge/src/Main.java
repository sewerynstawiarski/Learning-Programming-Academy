import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numbersSum = 0;
        int numberCount = 1;

            do {
                {
                    try {
                        System.out.println("Enter number #" + numberCount + ":");
                        double number = Double.parseDouble(scanner.nextLine());
                        numbersSum += number;
                        numberCount++;
                    }
                    catch (NumberFormatException badNumberFormat) {
                            System.out.println("Invalid Number");
                        }
                }
            } while (numberCount <= 5);


        System.out.println("The sum of all numbers is: " + numbersSum);
    }

}
