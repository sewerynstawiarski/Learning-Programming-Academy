package com.HighLand;

import java.util.Random;

public class DiceRoller {
    //Random random; to jest druga metoda, tutaj deklarujesz zmienne jako global dla całej klasy, więc później metoda utworzona poza DiceRoller (tutaj był to roll) też to widzi,
    //int number;

    DiceRoller() {
        Random random = new Random();
        int number = 0;
        roll(random, number);
    }
    void roll(Random random, int number) {
        number=random.nextInt(6)+1;
        System.out.println(number);
    }
}


