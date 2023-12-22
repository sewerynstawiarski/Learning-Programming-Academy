public class Car {
    private String description;

    public String getDescription() {
        return description;
    }

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.printf(getClass().getSimpleName() +  " makes sound of %s %n" ,
                switch (getClass().getSimpleName().charAt(0)) {
            case 'G' -> "Broom Broom";
            case 'E' -> "AI welcoming sound";
            case 'H' -> "Ai doing brom brom";
                    default -> "Key sound";
                });
    }

    public void drive() {
        runEngine();
        System.out.println("Car goes forward");
    }

    protected void runEngine() {
        System.out.println("Engine is working");
    }


}
