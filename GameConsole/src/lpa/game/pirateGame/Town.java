package lpa.game.pirateGame;

import java.util.*;

public record Town(String name, boolean island, int level,
                   Set<Loot> loots, Set<Feature> features, List<Combatant> opponents) {

    public Town {
       loots = new LinkedHashSet<>(Loot.getRandomLoot(3));
       features = new LinkedHashSet<>(Feature.getRandomLFeature(3));
       opponents = new ArrayList<>();
       opponents.add(new Soldier());
       opponents.add(new Islander());

    }

    public Town(String name, boolean island, int level) {
        this(name, island, level, null, null, null);
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                '}';
    }
}
