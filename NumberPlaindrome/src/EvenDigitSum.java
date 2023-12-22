public class EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-1));
    }
    public static int getEvenDigitSum (int number) {
        if (number < 0) {
            return -1;
        }

        int digit = 0;
        int evenDigit;
        int sumOfEvenDigits = 0;

        while (number != 0) {
            digit = number % 10;
            number = number / 10;
            if (digit % 2 != 0) {
                continue;
            } else if (digit % 2 == 0) {
                evenDigit = digit;
                sumOfEvenDigits += evenDigit;
            }
        } return sumOfEvenDigits;
    }
}
