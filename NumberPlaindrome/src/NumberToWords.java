public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));
        numberToWords(123);
        numberToWords(1010);
        numberToWords(100);
        numberToWords(-12);
    }
    public static int reverse (int number) {
        int digit = 0;
        int original = number;
        int reminderNumber = 0;
        if (number < 0) {
            number = number * (-1);
        }

        while (number > 0) {
            reminderNumber = number % 10;
            number = number /10;
            digit = digit*10;
            digit += reminderNumber;

        }
        if (original < 0 ) {
            digit = digit *(-1);
        }
        return digit;
    }
    public static int getDigitCount (int number) {
        if (number < 0) {
            return -1;
        } else if ( number < 10) {
            return 1;
        }
        int counter = 0;
        while (number > 0) {
            counter++;
            number = number /10;
        } return counter;
    }
    public static void numberToWords (int number) {
        if (number<0) {
            System.out.println("Invalid Value");
        }
        int extractedNumber = 0;
        int numberOfDigits = getDigitCount(number);
        number = reverse(number);
        while (numberOfDigits > 0) {
            extractedNumber = number % 10;
            switch (extractedNumber) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            number =number /10;
            numberOfDigits--;
        }
    }
}
