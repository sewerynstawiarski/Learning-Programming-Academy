package lpa.game.pirateGame;

import lpa.game.Player;

import java.util.*;

public sealed abstract class Combatant implements Player permits Islander, Pirate, Soldier {
    private Map<String, Integer> gameData = new HashMap<>();
    private final String name;
    private Weapon currentWeapon;

    public Combatant(String name) {
        this.name = name;
        this.currentWeapon = Weapon.STICK;
    }

    public Combatant() {
        this.name = this.getClass().getSimpleName();
        if (this instanceof Soldier) {
            this.currentWeapon = Weapon.SWORD;
        } else if (this instanceof Islander) {
            this.currentWeapon = Weapon.KNIFE;
        }
    }

    public Map<String, Integer> getGameData() {
        return gameData;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name();
    }

    public boolean setLevel(int level) {
        if (level < 1 || level > 8) {
            System.out.println("Minimal level is 1, max level is 8!");
        } else {
            System.out.println("Your level was set from " + gameData.put("Level", level) + " to " + level);
            gameData.put("Level", level);
            switch (level) {
                case 2 -> gameData.put("HP", 60);
                case 3 -> gameData.put("HP", 70);
                case 4 -> gameData.put("HP", 80);
                case 5 -> gameData.put("HP", 90);
                case 6 -> gameData.put("HP", 100);
                case 7 -> gameData.put("HP", 110);
                case 8 -> gameData.put("HP", 120);
            }
        }
        return false;
    }
    public boolean hit(Combatant anotherPlayer) {
        boolean hitGo = new Random().nextBoolean();
        if (anotherPlayer != null && hitGo) {
            int dps = currentWeapon.getHitPoints();
            int newHP = anotherPlayer.gameData.get("HP") - dps;
            if (newHP > 0) {
                anotherPlayer.gameData.put("HP", newHP);
                System.out.println("You have dealt " + dps + " to " + anotherPlayer.name + "!");
            } else {
                System.out.println("You killed " + anotherPlayer.name + "!!!");
                anotherPlayer.gameData.put("HP", 0);
                int levelNow = gameData.get("Level");
                if (levelNow < 8) {
                    this.gameData.put("Level", levelNow + 1);
                    System.out.println("Level Up! Congratulations! You are now on " + (levelNow + 1) + " level.");
                } else {
                    System.out.println("You are already on max level!");
                }

            }
        } else {
            System.out.println("You missed!");
        }
        return false;
    }
    boolean changeWeapon(Weapon weapon) {
        if (! (this instanceof Pirate)) {
            currentWeapon = weapon;
            return false;
        }
        if (gameData.get("Level") < weapon.getMinLevel()) {
            System.out.println("Sorry, you level is not enough!");
            return false;
        } else {
            currentWeapon = weapon;
            System.out.println("Your new weapon is " + weapon);
            return false;
        }
    }
    public void adjustValue(String value, int newValue) {
        if (value == null) {
            return;
        }
        gameData.put(value, newValue);
    }
    public boolean hitPlayer(Pirate player) {
        boolean go = new Random().nextBoolean();
        if (go) {
            if (player != null) {
                System.out.println(this + " hits " + player.name());
                int hp = (player.getGameData().get("HP")) - (this.getCurrentWeapon().getHitPoints());
                if (hp < 0) {
                    System.out.println(player + " was killed! THE END!");
                    return true;
                } else {
                    System.out.println(this + " deals " + this.getCurrentWeapon().getHitPoints() + " dmg to " + player.name());
                    player.getGameData().put("HP", hp);
                    return false;
                }
            }
        } else {
            System.out.println(this + " has missed!");
            return false;
        }
        return false;
    }
}
