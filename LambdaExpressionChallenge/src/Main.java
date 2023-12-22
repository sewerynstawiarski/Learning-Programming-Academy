import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Kendrick", "Severus", "Bob", "Harry", "Ginny", "Hermiona", "Albus"};

        Arrays.asList(names).replaceAll(s -> s.toUpperCase());
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        Arrays.asList(names).replaceAll(s -> s + " " + (char) (new Random().nextInt(65, 91)) + ".");
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        Arrays.asList(names).replaceAll(s -> {
            String[] split = s.split(" ");
            StringBuilder reversedString = new StringBuilder();
            return split[0] + " " + split[1] +  " " + reversedString.append(split[0]).reverse();
        });
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        List<String> arrayListNames = new ArrayList<>(List.of(names));
        arrayListNames.removeIf( (s) -> {
            String[] seperate = s.split(" ");
            if (seperate[0].equals(seperate[2])) {
                return true;
            } else {
                return false;
            }
        } );
        arrayListNames.forEach(s -> System.out.println(s));

    }
}
