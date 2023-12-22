package lpa.game.pirateGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Loot {
    GOLD(60),
    SILVER(40),
    WINE(5),
    NECKLACE(30),
    RING(35),
    PIECE_OF_PAPER(1),
    TREASURE_MAP(100),
    APPLE(5),
    MEAT(8),
    BREAD(2);

private final int points;

    Loot(int points) {
        this.points = points;
    }
    public static List<Loot> getRandomLoot(int number) {
        Random random = new Random();
        List<Loot> listOfLoot =  new ArrayList<>();
        for (int i = 0; i < number; i++) {
            listOfLoot.add(Loot.values()[random.nextInt(0, Loot.values().length)]);
        }
        return listOfLoot;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Loot{" +
                "points=" + points +
                "} " + super.toString();
    }
}
