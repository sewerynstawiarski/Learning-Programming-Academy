import java.util.*;

public class Main {
    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {
        List<WeekDay> annsWorksDay = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        var annsDaySet = EnumSet.copyOf(annsWorksDay);
        System.out.println(annsDaySet.getClass().getSimpleName());
        annsDaySet.forEach(System.out::println);

        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(70));
        allDaysSet.forEach(System.out::println);

        Set<WeekDay> newPersonsDays = EnumSet.complementOf(annsDaySet);
        System.out.println("-".repeat(70));
        newPersonsDays.forEach(System.out::println);

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaySet);
        System.out.println("-".repeat(70));
        anotherWay.forEach(System.out::println);

        Set<WeekDay> bussinesDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(70));
        bussinesDays.forEach(System.out::println);
        System.out.println("-".repeat(70));

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);

        employeeMap.put(WeekDay.FRIDAY, new String[] {"Ann", "Mary", "Boc"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});

        employeeMap.forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
    }
}
