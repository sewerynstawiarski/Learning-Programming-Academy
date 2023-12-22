public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,13));
    }
    public static boolean hasSharedDigit (int number1 , int number2) {
        if ((number1 < 10 || number1 > 99) || (number2 < 10 || number2 > 99)) {
            return false;
        }

        int comparingDigit;
        boolean hasShareDigits = false;
        int counter = 2;
        while (counter >0) {
            counter--;
            comparingDigit = number1 % 10;
            if (number1 > 9) {
                number1 = number1 /10;
            } else number1 = comparingDigit;
            for (int i = 0; i <2; i++){
                int extractedDigit = number2 % 10;
                if (number2 > 9) {
                    number2 = number2/10;
                } else number2 = extractedDigit;
                if (comparingDigit == extractedDigit) {
                    hasShareDigits = true;
                    break;
                }
            }
        } return hasShareDigits;
    }
}
