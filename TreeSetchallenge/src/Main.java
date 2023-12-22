public class Main {
    public static void main(String[] args) {
    Theatre myOwn = new Theatre("MyOwnTheatre", 5, 50);
      //  myOwn.printSeatMap();
    myOwn.printSeatMap(new Theatre.Seat((char)65, 1),
            new Theatre.Seat((char)66, 1));
    int[] wanted = {2,3};
        System.out.println("-".repeat(30));
    myOwn.extraReservation(7, 'E', 'F', wanted);
    myOwn.printSeatMap();

        int[] wanted1 = {1,5};
        System.out.println("-".repeat(30));
        myOwn.extraReservation(5, 'E', 'F', wanted1);
        myOwn.printSeatMap();
    }
}
