public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }
    public static boolean isPalindrome (int number) {

        if (number < 0) {
            number = number*(-1);
        }

        int parameter = number;
        int reverse = 0;
        int lasDigit = 0;
        boolean isPalindrome = false;



        while (number > 0) {
            lasDigit = number % 10;
            reverse = reverse * 10;
            reverse += lasDigit;
            number = number / 10;
        }
        if (parameter == reverse) {
            isPalindrome = true;
        } return isPalindrome;
        }
    }

