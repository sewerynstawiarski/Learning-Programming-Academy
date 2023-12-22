package challenge;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> bees = List.of(numberFrom(1));
        var B = bees.stream()
                .map(i -> "B" + i);

        Integer[] iees = numberFrom(16);
        var I = Arrays.stream(iees)
                .map(i -> "I" + i);


        var N = Stream.of(numberFrom(31))
                .map(i -> "N" + i);

        var G = Stream.iterate(46, i -> i <= 60, i -> i+1)
                .map(n -> "G" + n);

        var O = Stream.iterate(61, n -> n +1)
                .limit(15)
                .map(n -> "O" + n);


        var firstStep = Stream.concat(B,I);
        var secondStep = Stream.concat(firstStep, N);
        var thirdStep =  Stream.concat(secondStep, G);
        Stream.concat(thirdStep, O)
                .forEach(s -> System.out.println(s + " "));


    }
    public static Integer[] numberFrom(int startNumber) {
        Integer[] numbers = new Integer[15];
        Arrays.setAll(numbers, i -> i + startNumber);
        return numbers;
    }
}
