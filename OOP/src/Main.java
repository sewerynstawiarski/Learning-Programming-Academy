public class Main {
    public static void main(String[] args) {
    Car car = new Car();
    car.setMake("Porsche");
    car.setModel("Carrera");
    car.setDoors(2);
    car.setConvertible(true);
    car.setColor("Red");

//        System.out.println("make = "  + car.getMake());
//        System.out.println("model " + car.getModel());
//        System.out.println("color " + car.getColor());
    car.describeCar();

    Car targa = new Car();
        targa.setMake("Porsche");
        targa.setModel("Targa");
        targa.setDoors(2);
        targa.setConvertible(false);
        targa.setColor("Black");

        targa.describeCar();
    }
}
