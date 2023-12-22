package lpa.game.pritageGameSolution;

import lpa.game.Player;
import lpa.game.pirateGame.Combatant;
import lpa.game.pirateGame.Weapon;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.*;

public final class Pirate1 extends Combatant1 {


    private final List<Town1> townsVisited = new LinkedList<>();
    private List<Loot1> loot;
    private List<Combatant1> opponents;
    private List<Feature1> features;

    public Pirate1(String name) {
        super(name, Map.of("level", 0, "townIndex", 0));
        visitTown();
    }

    boolean useWeapon() {
        int count = opponents.size();
        if (count > 0) {
            int opponentsIndex = count -1;
            if (count > 1) {
                opponentsIndex = new Random().nextInt(count + 1);
            }
            Combatant1 combatant = opponents.get(opponentsIndex);
            if (super.useWeapon(combatant)) {
                opponents.remove(opponentsIndex);
            } else {
                return combatant.useWeapon(this);
            }
        }
        return false;
    }
    boolean visitTown() {
        List<Town1> levelTowns = PirateGame1.getTowns(value("level"));
        if (levelTowns == null) return true;
        Town1 town = levelTowns.get(value("townIndex"));
        if (town != null) {
            townsVisited.add(town);
            loot = town.loot();
            opponents = town.opponents();
            features = town.features();
            return false;
        }
        return true;

    }
    boolean hasExperiences() {
        return (features != null && features.size() > 0);
    }
    boolean hasOpponents() {
        return (opponents != null && opponents.size() > 0);
    }

    public String information() {
        var current  = ((LinkedList<Town1>)townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).name());
        return "-->" + current +
                "\n" + super.information() +
                "\n\ttownsVisited =" + Arrays.toString(simpleNames);
    }
    boolean findLoot() {
        if (loot.size() > 0) {
            Loot1 item = loot.remove(0);
            System.out.println("Found " + item + "!");
            adjustValue("score", item.getWorth());
            System.out.println(name() + "'s score is now " + value("score"));
        }
        if (loot.size() == 0) {
            return visitNextTown();
        }
        return false;
    }
    boolean experienceFeature() {
        if (features.size() > 0) {
            Feature1 item = features.remove(0);
            System.out.println("Ran into " + item + "!");
            adjustHealth(item.getHealthPoint());
            System.out.println(name() + "'s health is now " + value("health"));
        }
        return (value("health") <= 0);
    }
    private boolean visitNextTown() {
        int townIndex = value("townIndex");
        var towns = PirateGame1.getTowns(value("level"));
        if (towns == null) return true;
        if (townIndex >= (towns.size() -1)) {
            System.out.println("Leveling up! Bonus: 500 points");
            adjustValue("score", 500);
            adjustValue("level", 1);
            setValue("townIndex",0);
        } else {
            System.out.println("Sailing to next town! bonus: 50 points");
            adjustValue("townIndex", 1);
            adjustValue("score", 50);
        }
        return visitTown();
    }
}
