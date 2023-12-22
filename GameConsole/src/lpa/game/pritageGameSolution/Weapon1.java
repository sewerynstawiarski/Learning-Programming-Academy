package lpa.game.pritageGameSolution;

import lpa.game.pirateGame.Weapon;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon1 {
    KNIFE(0, 10),
    AXE(0,30),
    MACHETE(1,40),
    PISTOL(1,50);
    private final int minLevel;
    private final int hitPoints;

    Weapon1(int minLevel, int hitPoints) {
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public static Weapon1 getWeaponByChar( char firstInitial) {
        for (Weapon1 w : values()) {
            if (w.name().charAt(0) == firstInitial) {
                return w;
            }
        }
        return values()[0];
    }
    public static List<Weapon1> getWeaponsByLevel(int levelOfPlay) {
        List<Weapon1> weapons = new ArrayList<>(EnumSet.allOf(Weapon1.class));
        weapons.removeIf(w -> (w.minLevel > levelOfPlay));
        return weapons;
    }
}
