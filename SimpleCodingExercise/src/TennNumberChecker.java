public class TennNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(9,99,19));
        System.out.println(hasTeen(23,15,42));
        System.out.println(hasTeen(22,23,34));
        System.out.println(isTeen(9));
        System.out.println(isTeen(13));
    }
    public static boolean hasTeen ( int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber >= 13 && firstNumber <= 19) {
            return true;
        } else if (secondNumber >= 13 && secondNumber <= 19) {
            return true;
        } else if (thirdNumber >=13 && thirdNumber <= 19) {
            return true;
        } else return false;
    }
    public static boolean isTeen (int age) {
        if (age >= 13 && age <= 19) {
            return true;
        } else return false;
    }
}
