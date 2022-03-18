package com.HighLand;
enum Planets {
    MERKURY(1),
    WENUS(2),
    ZIEMIA(3),
    MARS(4),
    JOWISZ(5),
    SATURN(6),
    URAN(7),
    PLUTON(8);

    int number;

    Planets(int number) {
        this.number = number;
    }
} // Enum = zwykle zapisujemy z dużych liter
public class Enum {

    public static void main(String[] args) {
        Planets myPlanet = Planets.ZIEMIA; // tak się przywołuje enum do projektu

        canILiveHere(myPlanet);

    }
    static void canILiveHere(Planets myPlanet) {
        switch (myPlanet) {
            case ZIEMIA:
                System.out.println("You can live here!");
                System.out.println("This is planet #" + myPlanet.number);
                break;
            default:
                System.out.println("You can't live here :(");
                System.out.println("This is planet #" + myPlanet.number);
                break;

        }
    }
}
