public class GasPoweredCar extends Car {

    private double avgKmPerLitre;
    private int cylinders;
    private double tankSize;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders, double tankSize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.tankSize = tankSize;
    }
    @Override
    public void startEngine() {
        super.startEngine();
        String info = String.format("We are going to use %.2f and we have  %d to do it!%n", avgKmPerLitre, cylinders );
        System.out.println(info);
    }
@Override
public void drive() {
        super.drive();
 double kilometersWeCanGo = (tankSize * avgKmPerLitre);
    System.out.printf("With full tank %s can go for about %.2f KM%n", super.getDescription(), kilometersWeCanGo );
}
}
