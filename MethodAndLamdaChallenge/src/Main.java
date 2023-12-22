import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    private record Person(String first){
        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }
    public static void main(String[] args) {


        String[] names = {"Godryk", "helga", "Salazar", "rovenna", "Albus", "TOM"};
        Person tim = new Person("Tim");
        UnaryOperator<String> reverseFunction = s -> {
            String[] string = s.split(" ");
            StringBuilder reverseString = new StringBuilder(string[0]);
            return s + reverseString.reverse();

        };

        List<UnaryOperator<String>> functions = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s + " " + (char) new Random().nextInt(63, 91) + ". ",
                reverseFunction,
                String::toLowerCase,
               // s -> new String("Aha " + s),
                tim::last,
                (new Person("Mary"))::last
        ));


        System.out.println(Arrays.toString(names));
        System.out.println("-".repeat(40));
        allInOne(names, functions);
    }

    public static void allInOne(String[] names, List<UnaryOperator<String>> functions) {
        List<String> backedByArray = Arrays.asList(names);
        for (var function :
                functions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }

    }
}

