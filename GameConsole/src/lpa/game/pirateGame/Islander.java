package lpa.game.pirateGame;

import java.util.Random;

public final class Islander extends Combatant{
    public Islander(String name) {
        super(name);
        super.adjustValue("HP", 20);
        super.adjustValue("Level", 2);
    }

    public Islander() {
        super();
        super.adjustValue("HP", 30);
        super.adjustValue("Level", 2);
        super.changeWeapon(Weapon.KNIFE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
