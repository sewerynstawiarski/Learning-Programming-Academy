public class Main {
    public static void main(String[] args) {
    System.out.println(isOdd(4));
       System.out.println(sumOdd(1,100));
        System.out.println(sumOdd(-1,100));
        System.out.println(sumOdd(0,0));
    }
    public static boolean isOdd (int number) {
        if (number <= 0) {
            return false;
        } else if (number%2 != 0) {
            return true;
        } else return false;
    }
    public static int sumOdd (int start, int end) {
        if (end < start) {
            return -1;
        } else if (start < 0) {
            return -1;
        }
        int sumOfOddNumbers = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sumOfOddNumbers+=i;
            }
        }
        return sumOfOddNumbers;
    }
}
