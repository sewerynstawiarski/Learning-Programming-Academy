package lpa.game.pirateGame;

public enum Weapon {
    AXE(3, 10),
    WAND(8,25),
    SWORD(4,15),
    STICK(1,1),
    KNIFE(2,5);
    private int minLevel;
    private int hitPoints;

    Weapon(int minLevel, int hitPoints) {
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return super.toString() + " - Min Level = " + minLevel + " hitPoints: " + hitPoints;
    }
}
