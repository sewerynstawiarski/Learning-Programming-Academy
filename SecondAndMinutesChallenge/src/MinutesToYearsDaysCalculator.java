public class MinutesToYearsDaysCalculator {
    public static void main(String[] args) {
    //XX min = YY y and ZZ d
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
        printYearsAndDays(-500000);
    }
    public static void printYearsAndDays (long minutes) {
        if (minutes < 0)  {
            System.out.println("Invalid Value");
        } else if (minutes >= 0) {
            int toYears = (int) ((minutes / 60) / 24) / 365;
            int toDays = (int) (((minutes / 60) / 24) % 365);
            System.out.println(minutes + " min = " + toYears + " y and " + toDays + " d");
        }
    }
}
