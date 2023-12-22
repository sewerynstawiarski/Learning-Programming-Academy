package com.HighLand;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ćwiczenie {
    String smash;
    Ćwiczenie() {
        String[] smashWords = new String[] { "Bilal", "Djaghout"};
        Stream<String> stream = Arrays.stream(smashWords);


        stream.forEach(str -> System.out.print(str + " "));
        for (String smashWord : smashWords) {
            if (smashWord != smashWords.length-1) {
                String smash = smashWord + " ";
                System.out.print(smash);
            }
            else System.out.print(smash);
        }





    }
}
