package lpa.game.pirateGame;

import lpa.game.Player;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public non-sealed class Pirate extends Combatant implements Player {
//    private Map<String, Integer> gameData = new HashMap<>();
//    private final String name;

    private Set<Town> townsVisited = new LinkedHashSet<>();
//    private Weapon currentWeapon;

    {
        super.adjustValue("HP", 50);
        super.adjustValue("Level", 1);
        super.adjustValue("Score", 0);
//        gameData.put("HP", 50);
//        gameData.put("Level", 1);
//        gameData.put("Score", 0);
        townsVisited.add(new Town("Start Location", false, 0));
    }

    public Pirate(String name) {
        super(name);
    }

    public Set<Town> getTownsVisited() {
        return townsVisited;
    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public String toString() {
        return name() + " " + "HP: "  + getGameData().get("HP") + " Score: " +  getGameData().get("Score") + townsVisited.toString();
    }

//    public boolean setLevel(int level) {
//        if (level < 1 || level > 8) {
//            System.out.println("Minimal level is 1, max level is 8!");
//        } else {
//            System.out.println("Your level was set from " + gameData.put("Level", level) + " to " + level);
//            gameData.put("Level", level);
//            switch (level) {
//                case 2 -> gameData.put("HP", 60);
//                case 3 -> gameData.put("HP", 70);
//                case 4 -> gameData.put("HP", 80);
//                case 5 -> gameData.put("HP", 90);
//                case 6 -> gameData.put("HP", 100);
//                case 7 -> gameData.put("HP", 110);
//                case 8 -> gameData.put("HP", 120);
//            }
//        }
//        return false;
//    }
//    public boolean hit(Pirate anotherPlayer) {
//        if (anotherPlayer != null) {
//            int dps = currentWeapon.getHitPoints();
//            int newHP = anotherPlayer.gameData.get("HP") - dps;
//            if (newHP > 0) {
//                anotherPlayer.gameData.put("HP", newHP);
//                System.out.println("You have dealt " + dps + " to " + anotherPlayer.name + "!");
//            } else {
//                System.out.println("You killed " + anotherPlayer.name + "!!!");
//                anotherPlayer.gameData.put("HP", 0);
//                int levelNow = gameData.get("Level");
//                if (levelNow < 8) {
//                    this.gameData.put("Level", levelNow + 1);
//                    System.out.println("Level Up! Congratulations! You are now on " + (levelNow + 1) + " level.");
//                } else {
//                    System.out.println("You are already on max level!");
//                }
//
//            }
//        }
//        return false;
//    }
//    boolean changeWeapon(Weapon weapon) {
//        if (gameData.get("Level") < weapon.getMinLevel()) {
//            System.out.println("Sorry, you level is not enough!");
//            return false;
//        } else {
//            currentWeapon = weapon;
//            System.out.println("Your new weapon is " + weapon);
//            return false;
//        }
//    }

    boolean moveTo(Town place) {
        Town locationNow = (Town) townsVisited.toArray()[townsVisited.size()-1];
        if (locationNow.loots().isEmpty()) {
            Town[] placesVisited = new Town[townsVisited.size()];
            placesVisited = townsVisited.toArray(placesVisited);
            Town lastPlace = placesVisited[placesVisited.length -1];
            townsVisited.add(place);
            System.out.println("You move from " + lastPlace + " to " + place);
        } else {
            System.out.println("You still have loot to gather in " + locationNow);
        }
        return false;

    }
    boolean FindLoot() {

        Town locationNow = (Town) townsVisited.toArray()[townsVisited.size()-1];
        if (locationNow.loots().isEmpty()) {
            System.out.println("There is nothing more to find for you here! Go to next city");
            return false;
        }
        Loot lootNow = (Loot) locationNow.loots().toArray()[0];
        System.out.println("You found " + lootNow);
        if (lootNow != null) {
            int newScore = (super.getGameData().get("Score")) + lootNow.getPoints();
            super.getGameData().put("Score", newScore);
            System.out.println("You new score is: " + super.getGameData().get("Score"));
        }
        locationNow.loots().remove(lootNow);
        return false;
    }
    boolean ExperienceTown() {
        Town locationNow = (Town) townsVisited.toArray()[townsVisited.size()-1];
        if (locationNow.features().isEmpty()) {
            System.out.println("There is nothing more to do for you here! Go to next city");
            return false;
        }
        Feature featureNow = (Feature) locationNow.features().toArray()[0];
        System.out.println("You encounte " + featureNow);
        if (featureNow != null) {
            int newHP = (super.getGameData().get("HP")) + featureNow.getHpPoints();
            super.getGameData().put("HP", newHP);
            System.out.println("You new HP is: " + super.getGameData().get("HP"));
            if (newHP <= 0) {
                System.out.println("You have died! THE END");
                return true;
            }
        }
        locationNow.features().remove(featureNow);
        return false;
        }
    }
