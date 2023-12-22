package lpa.game.pritageGameSolution;

public enum Feature1 {
    ALLIGATOR(-45),
    ALOE(5),
    JELLYFISH(-10),
    PINEAPPLE(10),
    SNAKE(-25),
    SPRING (25),
    SUN_POISON(-15);
    private final int healthPoint;

    Feature1(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
}
