import java.util.*;

public class Main {
    public static void main(String[] args) {
//it would be better to use record instead of new class
        LinkedList<Place> placesToVisit = new LinkedList<>();
        placesToVisit.addFirst(new Place("Sydney", 0));
        addPlace(placesToVisit, "Adelaide", 1374);
        addPlace(placesToVisit, "Alice Springs", 2771);
        addPlace(placesToVisit, "Brisbane", 917);
        addPlace(placesToVisit, "Darwin", 3972);
        addPlace(placesToVisit, "Melbourne", 877);
        addPlace(placesToVisit, "Perth", 3923);

        System.out.println(placesToVisit);

        menu(placesToVisit);
    }

    public static void addPlace(LinkedList<Place> list, String name, int distance) {
        boolean flag = false;
        for (Place p :
                list) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println(name + " is already on the list. Duplicates not allowed");
                flag = true;
            }
            }
        if (!flag) {
            int matchedIndex = 0;
            for (var listPlace :
                    list) {
                if (distance < listPlace.getDistance()) {
                    list.add(matchedIndex, new Place(name, distance));
                    return;
                }
                matchedIndex++;
                }

            list.add(new Place(name, distance));
        }
    }

    public static void menu(LinkedList<Place> list) {
        boolean flag = true;
        boolean forward = true;
        Scanner scanner = new Scanner(System.in);
        ListIterator iterator = list.listIterator();
        System.out.println("""
                    Available actions (select word or letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");
        while (flag) {
            if (!iterator.hasPrevious()) {
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }
            switch (scanner.nextLine().toUpperCase().charAt(0)) {
                case 'F' -> {
                    if (!forward) { // reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next(); // adjusting position
                        }
                    }
                    System.out.println("Next stop is " + iterator.next());
                }
                case 'B' -> {
                    if (forward) { // reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous(); // adjusting position
                        }
                    }
                    System.out.println("Previous stop is " + iterator.previous());
                }
                case 'L' -> {
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
                case 'M' -> {
                    System.out.println("""
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit
                            """);
                }
                case 'Q' -> {
                    System.out.println("Quiting");
                    flag = false;
                }
            }
        }
    }
}

class Place {
    private String name;
    private int distance;

    public Place(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
