import java.util.Arrays;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printTheParts = s -> {
            String [] parts  = s.split(" ");
            for (String part:
                 parts ) {
                System.out.println(part);
            }
        };

        printTheParts.accept("Let's split this up into an array");

        Consumer<String> printWordsForEach = s -> {
            String [] parts  = s.split(" ");
            Arrays.asList(parts).forEach(t -> System.out.println(t));
        };

        printWordsForEach.accept("Let's use for each loop in lambda");

        Consumer<String> printWordsConcise = s -> {
           Arrays.asList(s.split(" ")).forEach(t -> System.out.println(t));
        };

        printWordsConcise.accept("Let's use lambda in just one line");


       Function<String, String> everySecondChar = source -> {
           StringBuilder returnVal = new StringBuilder();
           for (int i = 0; i < source.length(); i++) {
               if (i % 2 == 1) {
                   returnVal.append(source.charAt(i));
               }
           }
           return returnVal.toString();
       };

        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondChar, "Seweryn Stawiarski"));
        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java";
        var supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        }
        public  static String everySecondCharacter(Function<String, String> function, String source) {
        return function.apply(source);
        }
    }

