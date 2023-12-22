public class HybridCar extends Car {

    private double avgKmPerLitre;
    private double avgKmPerCharge;
    private int batterySize;

    private int cylinders;

    private double tankSize;

    public HybridCar(String description, double avgKmPerLitre, double avgKmPerCharge, int batterySize, int cylinders, double tankSize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
        this.tankSize = tankSize;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf("let's use this battery os size %d and %d cylinders to get you to your destination!%n" , batterySize, cylinders);
    }

    @Override
    public void drive() {
        super.drive();
        double gasRange = tankSize * avgKmPerLitre;

        System.out.printf("Thanks to advance hybrid technology %s can go %.2f KM only on fuel or %.2f KM only with electric power which combains gives us %.2f KM !!%n" , super.getDescription(), gasRange, avgKmPerCharge, (gasRange+avgKmPerCharge) );
    }


}
