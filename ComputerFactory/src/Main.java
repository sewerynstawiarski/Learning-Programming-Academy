public class Main {
    public static void main(String[] args) {
    ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor =  new Monitor("27inch Beast", "Acer",27, "2540x1440");
        Motherboard theMotherBoard = new Motherboard("BJ-200", "Asus", 4,6,"v2.44");

        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherBoard );

//        thePC.getMonitor().drawPixelAt(10,10, "blue");
//        thePC.getMotherboard().loadProgram("Windows OS");
//        thePC.getComputerCase().pressPowerButton();

        thePC.powerUp();
    }

}
