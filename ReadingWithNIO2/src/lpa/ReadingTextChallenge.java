package lpa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReadingTextChallenge {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("challenge.txt"))) {
            var results = scanner.tokens()
                    .map(s -> s.replaceAll("\\p{Punct}", ""))
                    .toList();
//            System.out.println(results);

            Pattern pattern = Pattern.compile("[a-zA-z]{6,}");
            var results2 = results.stream()
                    .filter(s -> pattern.asPredicate().test(s))
                    .toList();
//            System.out.println(results2);

            var result3 = results.stream()
                    .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//            System.out.println(result3);

            var result4 = results2.stream()
                    .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .toList();

            System.out.println(result4);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-".repeat(50));

        Path path = Path.of("challenge.txt");

        try {
            String text = Files.readString(path);
//            System.out.println(text);

            var result = Arrays.asList(text.split("\\s"));
            List<String> betterResults = new ArrayList<>();
            result.replaceAll(s -> s.replaceAll("\\p{Punct}", ""));
            result.forEach(s -> {
                if (Pattern.compile("[a-zA-z]+").asPredicate().test(s)) {
                    betterResults.add(s);
                }
            });
            System.out.println(betterResults);

            List<String> betterResults2 = new ArrayList<>();
            betterResults.forEach(s -> {
                if (Pattern.compile("[a-zA-z]{6,}").asPredicate().test(s)) {
                    betterResults2.add(s);
                }
            });
//            System.out.println(betterResults2);

            Map<String, Long> betterResults3 = new HashMap<>();
            betterResults2.forEach(s -> {
                if (betterResults3.putIfAbsent(s, 1L) != null) {
                    betterResults3.merge(s, 1L, (oldValue, newValue) -> oldValue += newValue);
                }
            });

            System.out.println(betterResults3);


            Comparator<Map.Entry<String, Long>> com = Map.Entry.comparingByValue(Comparator.reverseOrder());
            var entries = betterResults3.entrySet();
            List<Map.Entry<String, Long>> betterEntries = new ArrayList<>(entries);
            betterEntries.sort(com);

            Map<String, Long> bettersResults4 = new LinkedHashMap<String, Long>(betterEntries.size());
            for (int i = 0; i < 10 ; i++) {
                bettersResults4.put(betterEntries.get(i).getKey(), betterEntries.get(i).getValue());
            }

            System.out.println(bettersResults4);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
