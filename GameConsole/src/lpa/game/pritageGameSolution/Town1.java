package lpa.game.pritageGameSolution;

import lpa.game.pirateGame.Loot;

import javax.swing.event.MenuKeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public record Town1(String name, String island, int level, List<Loot1> loot, List<Feature1> features, List<Combatant1> opponents) {
    public Town1 {
        loot = randomReduced(new ArrayList<>(EnumSet.allOf(Loot1.class)), level +2);
        features = randomReduced(new ArrayList<>(EnumSet.allOf(Feature1.class)), level +3);
        opponents = new ArrayList<>();
        if (level == 0) {
            opponents.add(new Islander1("Joe", Weapon1.KNIFE));
        } else {
            opponents.add(new Islander1("Joe", Weapon1.MACHETE));
            opponents.add(new Islander1("John", Weapon1.PISTOL));
        }
    }

    public Town1(String name, String island, int level) {
        this(name, island, level, null, null, null);
    }

    private <T> List<T> randomReduced(List<T> list, int size) {
        Collections.shuffle(list);
        return list.subList(0, size);
    }

    @Override
    public String toString() {
        return name + ", " + island;
    }
    public String information() {
        return "Town: " + this + "\n\tloot=" + loot +
                "\n\tfeatures=" + features +
                "\n\topponents=" + opponents;
    }
    public List<Loot1> loot() {
        return (loot == null) ? null : new ArrayList<>(loot);
    }
    public List<Combatant1> opponents() {
        return (opponents == null) ? null : new ArrayList<>(opponents);
    }
    public List<Feature1> features() {
        return (features == null) ? null : new ArrayList<>(features);
    }
}
