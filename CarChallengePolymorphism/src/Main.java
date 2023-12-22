public class Main {
    public static void main(String[] args) {

        Car gasPoweredCar = new GasPoweredCar("Ford", 15, 4, 89.76);
        gasPoweredCar.startEngine();
        gasPoweredCar.drive();


        Car electricCar = new ElectricCar("Tesla", 900, 360);
        electricCar.startEngine();
        electricCar.drive();


       Car hybridCar = new HybridCar("Toyota", 8.5, 300, 200, 4, 90);

        hybridCar.startEngine();
        hybridCar.drive();

        Car car = new Car("Polonez");
        car.startEngine();
        car.drive();


    }
}
