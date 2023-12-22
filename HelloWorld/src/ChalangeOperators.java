public class ChalangeOperators {
    public static void main(String[] args) {
        double firstValue = 20.00d;
        double secondValue = 80.00d;
        double addidtion = (firstValue + secondValue)*100.00d;
        double rest = addidtion%40.00d;
        boolean isZero = (rest == 0.0) ? true : false;



        System.out.println(addidtion);
        System.out.println(rest);
        System.out.println(isZero);

        if (!isZero) {
            System.out.println("Got some reminder");
        }
    }
}
