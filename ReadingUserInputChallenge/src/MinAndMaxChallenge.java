import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean validNumber = true;
        double minNumber = Double.MAX_VALUE ;
        double maxNumber = Double.MIN_VALUE;

        try {
            do {
                System.out.println("Enter the number, or any character to exit: ");
                double number = Double.parseDouble(scanner.nextLine());
                if (minNumber == Double.MAX_VALUE && maxNumber == Double.MIN_VALUE){
                    minNumber = number;
                    maxNumber = number;
                }
                else if (number < minNumber) {
                    minNumber = number;
                } else if (number > maxNumber) {
                    maxNumber = number;
                }
                System.out.println("Current minimum values is: " + minNumber);
                System.out.println("Current maximum values is: " + maxNumber);

            } while (validNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid Number");

        }

    }

}
