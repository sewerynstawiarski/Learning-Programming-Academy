public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(1000));
        System.out.println(sumDigits(4));
        System.out.println(sumDigits(1234));
        System.out.println(sumDigits(-3));
        System.out.println(sumDigits(32123));
    }
    public static int sumDigits (int number) {
        if (number < 0) {
            return -1;
        }
//        } else if (number < 10) { // to moje roziązanie, też poprawne
//            return number;
//        }
//        int sum = 0;
//       for (int i = 0; i < number; i++) {
//           sum += number % 10;
//           number = number /10;
//           if (number < 10) {
//               sum += number;
//               break;
//           }
        int sum = 0;
        while (number >9) {
            sum += number % 10;
            number = number / 10;
        }
        sum += number;
        return sum;
    }
}
