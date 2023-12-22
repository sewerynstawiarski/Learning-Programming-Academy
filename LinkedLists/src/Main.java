import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Hokkaido");
        placesToVisit.add(0, "Niigata");

        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);

        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//
//        System.out.println(placesToVisit);
//        gettingElements(placesToVisit);
//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);
     }

     private static void addMoreElements(LinkedList<String> placesToVisit) {
        placesToVisit.addFirst("Osaka");
        placesToVisit.addLast("Okinawa");
        //queque methods
         placesToVisit.offer("Tochigi");
         placesToVisit.offerFirst("Nagoya");
         placesToVisit.offerLast("Kumamoto");
         //stack methods
         placesToVisit.push("Hiroshima");

     }
     private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Okinawa");

         System.out.println(list);
         String s1 = list.remove(); // remove first element
         System.out.println(s1 + " was removed");

         String s2 = list.removeFirst(); // remove first element
         System.out.println(s2 + " was removed");

         String s3 = list.removeLast(); // remove last element
         System.out.println(s3 + " was removed");
         // Queque.Deque poll methods
         String p1 = list.poll(); // remove first element
         System.out.println(p1 + " was removed");

         String p2 = list.pollFirst(); // remove first element
         System.out.println(p2 + " was removed");

         String p3 = list.pollLast(); // remove last element
         System.out.println(p3 + " was removed");

         list.push("Tokyo Disneyland");
         list.push("Nikko");
         list.push("Kanagawa");

         System.out.println(list);

         String p4 = list.pop(); //remove first element
         System.out.println(p4 + " was removed");


     }

     private static void gettingElements(LinkedList<String> list) {
         System.out.println("Retrieved element is: " + list.get(4));
         System.out.println("First Element is: " + list.getFirst());
         System.out.println("Last element is: " + list.getLast());

         System.out.println("Position of Osaka is: " + list.indexOf("Osaka"));
         System.out.println("Position of Nagoya is: " + list.lastIndexOf("Nagoya"));
         //Queque retrieval method
         System.out.println("Element from element() is: " + list.element());
         //Stack retrieval methods
         System.out.println("Element from peek() is: " + list.peek());
         System.out.println("Element from peekFirst() is: " + list.peekFirst());
         System.out.println("Element from peekLast() is: " + list.peekLast());
     }
     public static void printItinerary(LinkedList<String> list) {
         System.out.println("Trip starts at " + list.getFirst());
         for (int i = 1; i < list.size(); i++) {
             System.out.println("-> From " + list.get(i - 1) + " to " + list.get(i));
         }
         System.out.println("Trip ends at: " + list.getLast());
     }
    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town :
                list) {
            System.out.println("-> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at: " + list.getLast());
    }
    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("-> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at: " + list.getLast());
    }
    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Niigata")) {
                iterator.add("Odaiba");
            }
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.previous());
    }
}
