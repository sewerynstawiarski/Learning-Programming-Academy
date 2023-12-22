package lpa.game.pirateGame;

import java.util.Random;

public final class Soldier extends Combatant{
    public Soldier(String name) {
        super(name);
        super.adjustValue("HP", 20);
        super.adjustValue("Level", 6);
    }

    public Soldier() {
        super();
        super.adjustValue("HP", 20);
        super.adjustValue("Level", 6);
        super.changeWeapon(Weapon.SWORD);
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
