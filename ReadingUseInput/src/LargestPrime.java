public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
        System.out.println(getLargestPrime(2));
        System.out.println(getLargestPrime(16));


    }

    public static int getLargestPrime(int number) {
        int largestPrime = 0;
        if (number < 2) {
            return -1;
        }
        for (int i = number; i > 1; i--) {
            if (number % i == 0) {
                largestPrime = i;
                for (int j = i-1; j > 1; j--) {
               if ( i % j  == 0) {
                   largestPrime = 0;
                   break;
               }
                }
                if (largestPrime != 0) {
                    break;
                }
                }
            }
        return largestPrime;
        }
}

//    public static boolean isPrime (int number) {
//        if (number <2) {
//            return false;
//        }
//        for (int i = (number-1); i>1; i--) {
//            if (number % i == 0) {
//                return false;
//            }
//        } return true;
//    }


