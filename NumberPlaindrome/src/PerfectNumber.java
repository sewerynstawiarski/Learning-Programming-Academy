public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }
    public static boolean isPerfectNumber (int number) {
        if (number < 1) {
            return false;
        }
        int sumOfDigits = 0;
        int original = number;

        while (number > 1) {
            number--;
            if ( original % number == 0) {
                sumOfDigits+=number;
            }

        }
        if (sumOfDigits == original) {
            return true;
        } else return false;
    }
}
