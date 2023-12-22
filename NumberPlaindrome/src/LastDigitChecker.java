public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(isValid(10));
        System.out.println(isValid(1051));
        System.out.println(hasSameLastDigit(41,22,71));
        System.out.println(hasSameLastDigit(23,32,42));
        System.out.println(hasSameLastDigit(9,99,999));
    }
    public static boolean isValid (int number) {
        if (number >= 10 && number <= 1000) {
            return true;
        } else return false;
    }
    public static boolean hasSameLastDigit (int number1, int number2, int number3) {
        if (!isValid(number1) || !isValid(number2) || !isValid(number3)) {
            return false;
        }
        int parameter1 = number1 % 10;
        int parameter2 = number2 % 10;
        int parameter3 = number3 % 10;


        for (int i =1; i <= 3; i++) {
            if (parameter1 == parameter2) {
                return true;
            } else if (parameter1 == parameter3) {
               return true;
            } else if (parameter3 == parameter2) {
               return true;
            }
            else return false;
        }
        return false;
    }
}
