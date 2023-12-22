import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Employee jane = new Employee("Jane", ZoneId.of("America/New_York"));
        Employee joe = new Employee("Joe", ZoneId.of("Australia/Sydney"));

        var todayNY = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0)), jane.zoneId());
        var todaySY = todayNY.toInstant().atZone(joe.zoneId());
        var lastPossible = todayNY.plusDays(10);
        Locale locale = Locale.US;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, d LLLL yyyy, hh:mm a ", locale);

        while (todayNY.getDayOfMonth() < lastPossible.plusDays(1).getDayOfMonth()) {
            todayNY = todayNY.plusDays(1);
            todaySY = todaySY.plusDays(1);
            if (todayNY.getDayOfWeek() == DayOfWeek.SATURDAY || todayNY.getDayOfWeek() == DayOfWeek.SUNDAY || todayNY.getDayOfWeek() == DayOfWeek.FRIDAY) {
                continue;
            }
            LocalTime stop = LocalTime.of(23, 0);
            while (todayNY.toLocalTime().isBefore(stop)) {
                todayNY =  todayNY.plusHours(1);
                todaySY =  todaySY.plusHours(1);
                if ((todayNY.toLocalTime().isAfter(LocalTime.of(6,0)) && todayNY.toLocalTime().isBefore(LocalTime.of(21, 0))) &&
                        (todaySY.toLocalTime().isAfter(LocalTime.of(6,0)) && todaySY.toLocalTime().isBefore(LocalTime.of(21, 0)))) {
                    System.out.println(jane + " : " + todayNY.format(dtf) + " <--> " + joe + " : " + todaySY.format(dtf));
                }
            }
            todayNY = todayNY.minusHours(23);
            todaySY =  todaySY.minusHours(23);

        }
    }
}
