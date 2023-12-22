public class SecondChallenge {
    public static void main(String[] args) {
    printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);
    }
    public static long toMilesPerHour(double kilometersPerHour) {
        long toMilesPerHour = (kilometersPerHour < 0) ? -1 : (Math.round(kilometersPerHour / 1.609));
        return toMilesPerHour;
    }
    public static void printConversion (double kilometersPerHour){
        System.out.println((kilometersPerHour < 0) ? "Invalid Value" :  + kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
    }
}
