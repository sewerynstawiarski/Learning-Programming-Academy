package lpa;

import java.util.List;

public class MiniChallenges {
    public static void main(String[] args) {
        String example = "Hello, World!";
        boolean answer =  example.matches("Hello, World!");
        System.out.println(answer);

        String sentence = "The bike is red.";
        boolean answer1 = sentence.matches("(^[A-Z])(.*)[.]$");
        System.out.println(answer1);

        String solution1 = "[A-Z].*\\.";
        String solution2 = "[A-Z][a-z\\s]+[.]";

        for (String s : List.of(
                "The bike is red.",
                "I am a new student.",
                "hello world.",
                "How are you?"
        )) {
            boolean matched = s.matches(solution2);
            System.out.println(matched + ": " + s);
        }

        String answer2 = "(^[A-Z])(.*)[.?!]$";
        String solution3 = "[A-Z].+[.?!]";
        String solution4 = "^[A-Z][\\p{all}]+[.?!]$";

        for (String s : List.of(
                "The bike is red, and has flat tiers.",
                "I love being a new L.P.A. student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?",
                "how are you, Mary?",
                "How are you, Mary"
        )) {
            boolean matched = s.matches(answer2);
            System.out.println(matched + ": " + s);
        }

    }
}
