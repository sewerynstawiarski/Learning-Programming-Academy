import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
    Course jmc = new Course("jmc101", "Java Maste Class", "Java");
    Course python = new Course("pyt101", "Python Master Class", "Python");

    addPurchase("Mary Martin", jmc, 129.99);
    addPurchase("Andy Martin", jmc, 139.99);
    addPurchase("Mary Martin", python, 149.99);
    addPurchase("Joe Jones", jmc, 149.99);
    addPurchase("Bill Brown", python, 119.99);
    addPurchase("Chuck Cheese", python, 119.99);
    addPurchase("Davey Jones", jmc, 139.99);
    addPurchase("Eva East", python, 139.99);
    addPurchase("Fred Forker", jmc, 139.99);
    addPurchase("Greg Brady", python, 129.99);

    purchases.forEach((k, v) -> System.out.println(k + ": " + v));
    System.out.println("-".repeat(30));
    students.forEach((k, v) -> System.out.println(k + "; " + v));

    NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
    for (Purchase p : purchases.values()) {
        datedPurchases.compute(p.purchaseDate(),
                (pdate, plist) -> {
            List<Purchase> list  = (plist == null) ? new ArrayList<>() : plist;
            list.add(p);
            return list;
                });
    }
    datedPurchases.forEach((k , v) -> System.out.println(k + ": " + v));

    int currentYear = LocalDate.now().getYear();

    LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
    LocalDate week1 = firstDay.plusDays(7);
    Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
    Map<LocalDate, List<Purchase>> week2Purchasses = datedPurchases.tailMap(week1);

//    System.out.println("-".repeat(50));
//    week1Purchases.forEach((k, v) -> System.out.println(k + ": " + v));
//    System.out.println("-".repeat(50));
//    week2Purchasses.forEach((k, v) -> System.out.println(k + ": " + v));

        displayStats(1, week1Purchases);
        displayStats(2, week2Purchasses);

        System.out.println("-".repeat(50));

        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        while (previousEntry != null) {
            List<Purchase> lastDaysData = previousEntry.getValue();
            System.out.println(lastDate + " purchases: " + lastDaysData.size());

            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = prevDate;
        }

        System.out.println("-".repeat(50));
        var reversed = datedPurchases.descendingMap();

        LocalDate firstDate = reversed.firstKey();
//        var nextEntry = reversed.firstEntry();
        var nextEntry = reversed.pollFirstEntry();

        while (nextEntry != null) {
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases: " + lastDaysData.size());

            LocalDate nextDate = reversed.higherKey(firstDate);
//            nextEntry = reversed.higherEntry(firstDate);
            nextEntry = reversed.pollFirstEntry();
            firstDate = nextDate;
        }
        System.out.println("-".repeat(50));

        datedPurchases.forEach((k, v) -> System.out.println(k + ": " + v));
    }
    private static void addPurchase(String name, Course course, double price) {
        Student existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1,15);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase =  new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData) {
        System.out.println("-".repeat(50));
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        periodData.forEach((k, v) -> {
            System.out.println(k + ": " + v);
            for (Purchase p : v) {
                weeklyCounts.merge(p.courseId(), 1, (prev, current) -> {
                    return prev + current;
                });
            }
        });
        System.out.printf("Week %d Purchases = %s%n", period, weeklyCounts);
    }
}
