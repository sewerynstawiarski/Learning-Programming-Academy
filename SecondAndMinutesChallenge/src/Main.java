public class Main {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(65, 145));
        System.out.println(getDurationString(-3945));

    }
    //XXh YYm ZZs
    public static String getDurationString (int seconds) {
       if (seconds >= 0) {
           int toMinutes = seconds/60;
           return   getDurationString( toMinutes, (seconds%60));
       } else return "Invalid question";
    }
    public static String getDurationString (int minutes, int seconds) {
    if ( minutes >= 0 && seconds >= 0 && seconds <= 59) {
        int toHours = minutes/60;
        return toHours + "h " + (minutes % 60) + "m " + seconds + "s";
    } else return "Invalid question";
    }
}
