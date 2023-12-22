import java.util.*;

public class Theatre {
private String theatreName;
private int seatInARow;
private TreeSet<Seat> seats;

    public Theatre(String theatreName, int seatInARow, int numberOfSeats) {
        this.theatreName = theatreName;
        this.seatInARow = seatInARow;
        int numberOfRows = (numberOfSeats / seatInARow);
        if (numberOfRows > 26) {
            numberOfRows = 26;
            System.out.println("Number of rows should not exceed 26");
        }
        this.seats = populateRows(numberOfRows, seatInARow);
    }
    private static TreeSet<Seat> populateRows(int numberOfRows, int seatInARow) {
        TreeSet<Seat> seatsSet = new TreeSet<>();
        for (int i = 65; i <= (65 + numberOfRows); i++) {
            for (int j = 1; j <= seatInARow; j++) {
                seatsSet.add(new Seat((char) i, j));
            }
        }
        return seatsSet;
    }

    @Override
    public String toString() {
        return "%s%n%d%n%s".formatted(theatreName, seatInARow, seats);
    }

    public void printSeatMap(Seat... reserved) {
        int numberOfRows = (seats.size()/seatInARow);
        int charNumber = 65;

        for (Seat s :
                reserved) {
            seats.ceiling(s).setReserved(true);
        }
    for (int i = 0; i < numberOfRows; i++ ) {
        Seat firstSeat = new Seat((char) charNumber, 1);
        Seat lastSeat = new Seat((char) charNumber, seatInARow);
        System.out.println(seats.subSet(firstSeat, true, lastSeat, true));
        charNumber++;
    }
    }
    public void printSeatMap() {
        int numberOfRows = (seats.size() / seatInARow);
        int charNumber = 65;
        for (int i = 0; i < numberOfRows; i++ ) {
            Seat firstSeat = new Seat((char) charNumber, 1);
            Seat lastSeat = new Seat((char) charNumber, seatInARow);
            System.out.println(seats.subSet(firstSeat, true, lastSeat, true));
            charNumber++;
        }
    }
        public void extraReservation (int numberOfTickets, char from, char to, int[] rangeOfSeats){
            if (rangeOfSeats[0] < 1 || rangeOfSeats[1] > seatInARow) {
                System.out.println("Need number over 0 and less than or equal   " + seatInARow);
            }
            NavigableSet<Seat> rangeSeat = new TreeSet<>();
        for (int i = from; i <= to; i++) {
            rangeSeat.addAll(seats.subSet(new Seat((char)i, rangeOfSeats[0]), true, new Seat((char)i, rangeOfSeats[1]), true));
        }
            for (Seat s :
                    rangeSeat) {
                if (!s.isReserved()) {
                    if (numberOfTickets > 0) {
                        rangeSeat.ceiling(s).setReserved(true);
                        numberOfTickets--;
                    }
                }
                }

//            SortedSet<Seat> reservedRange = seats.subSet(new Seat(from, rangeOfSeats[0]), new Seat(to, rangeOfSeats[1]));
//            NavigableSet<Seat> reservedTree = new TreeSet<>(reservedRange);
//            for (Seat s :
//                    reservedRange) {
//                if (!s.isReserved()) {
//                    if (numberOfTickets > 0) {
//                        reservedTree.ceiling(s).setReserved(true);
//                        numberOfTickets--;
//                    }
//                }
//            }
            seats.addAll(rangeSeat);
            System.out.println("Number of tickets that couldn't be reserved " + numberOfTickets);
        }


    static class Seat implements Comparable<Seat> {
        private char row;
        private int seatNumber;

        private boolean reserved;

        public Seat(char row, int seatNumber) {
            this.row = row;
            this.seatNumber = seatNumber;
            this.reserved = false;
        }

        @Override
        public String toString() {
            return "%c%03d %s".formatted(row, seatNumber, reserved ? "R" : "F");
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        public char getRow() {
            return row;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            int result = Integer.compare(row, (o.getRow()));
            if (result != 0) {
                return  result;
            } else {
                return Integer.compare(seatNumber, o.getSeatNumber());
            }
        }
    }
}
