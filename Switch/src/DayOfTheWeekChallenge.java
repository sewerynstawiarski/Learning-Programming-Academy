public class DayOfTheWeekChallenge {
    public static void main(String[] args) {
        printDayOfWeek(0);
        printDayOfWeek(2);
        printDayOfWeek(3);
        printDayOfWeek(4);
        printDayOfWeek(5);
        printDayOfWeek(6);
        printDayOfWeek(7);

        printWeekDay(0);
        printDayOfWeek(7);
    }

    public static void printDayOfWeek(int day) {
        String nameOfTheWeek = "";
        switch (day) {
            case 0 -> nameOfTheWeek = "Sunday";
            case 1 -> nameOfTheWeek = "Monday";
            case 2 -> nameOfTheWeek = "Tuesday";
            case 3 -> nameOfTheWeek = "Wednesday";
            case 4 -> nameOfTheWeek = "Thursday";
            case 5 -> nameOfTheWeek = "Friday";
            case 6 -> nameOfTheWeek = "Saturday";
            default -> nameOfTheWeek = "Invalid Day";
        }
        System.out.println(day + " is " + nameOfTheWeek);
    }

    public static void printWeekDay(int day) {
        String nameOfTheDay = "";
        if (day == 0) {
            nameOfTheDay = "Sunday";
        } else if (day == 1) {
            nameOfTheDay = "Monday";
        } else if (day == 2) {
            nameOfTheDay = "Tuesday";
        } else if (day == 3) {
            nameOfTheDay = "Wednesday";
        } else if (day == 4) {
            nameOfTheDay = "Thursday";
        } else if (day == 5) {
            nameOfTheDay = "Friday";
        } else if (day == 6) {
            nameOfTheDay = "Saturday";
        } else nameOfTheDay = "Invalid Day";
        System.out.println(day + " is " + nameOfTheDay);

    }
}
