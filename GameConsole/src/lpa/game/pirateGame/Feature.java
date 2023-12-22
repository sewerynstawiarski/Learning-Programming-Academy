package lpa.game.pirateGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Feature {
    BEING_ROBBED(-40),
    TAVERN(10),
    PANDEMIC(-30),
    SPRING_FESTIVAL(70),
    FOUND_FREE_BEER(5),
    SAVE_PEASANT_FROM_ROBBERY(30),
    MET_BEAUTIFUL_GIRL(20),
    WAS_IGNORED_BY_THE_GIRL(-20);

    private final int hpPoints;

    Feature(int hpPoints) {
        this.hpPoints = hpPoints;
    }
    public static List<Feature> getRandomLFeature(int number) {
        Random random = new Random();
        List<Feature> listOfFeatures =  new ArrayList<>();
        for (int i = 0; i < number; i++) {
            listOfFeatures.add(Feature.values()[random.nextInt(0, Feature.values().length)]);
        }
        return listOfFeatures;
    }

    public int getHpPoints() {
        return hpPoints;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "hpPoints=" + hpPoints +
                "} " + super.toString();
    }
}
