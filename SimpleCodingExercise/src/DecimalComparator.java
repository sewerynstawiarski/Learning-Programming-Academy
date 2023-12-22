public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces((-3.1756), (-3.175)));
        System.out.println(areEqualByThreeDecimalPlaces((3.175), (3.176)));
        System.out.println(areEqualByThreeDecimalPlaces((3.0), (3.0)));
        System.out.println(areEqualByThreeDecimalPlaces((-3.123), (3.123)));
    }
    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {
        int firstNumber = (int) (first * 1000);
        int secondNumber = (int) (second * 1000);

        if (firstNumber == secondNumber) {
            return true;
        } else return false;
    }
}
