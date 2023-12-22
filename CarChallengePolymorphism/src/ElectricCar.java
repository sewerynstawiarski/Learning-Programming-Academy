public class ElectricCar extends Car {
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf("Ai says \" We have a battery of size: %d, to drive you wherever you want \"%n", batterySize);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("Only on one charge %s can go for %.2f KM !%n" , super.getDescription(), avgKmPerCharge);
    }

    }


