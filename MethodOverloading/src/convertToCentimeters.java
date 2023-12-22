public class convertToCentimeters {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5,8));
        System.out.println(convertToCentimeters(68));
    }
    public static double convertToCentimeters (int inches) {
        double inCentimeters = (inches*2.54);
        return  inCentimeters;
    }
    public static double convertToCentimeters (int heightInFeet, int remainingHeightInInches) {
        int inInches = (heightInFeet*12) + remainingHeightInInches;
        double inCentimeters = convertToCentimeters(inInches);
        return inCentimeters;
    }
}
