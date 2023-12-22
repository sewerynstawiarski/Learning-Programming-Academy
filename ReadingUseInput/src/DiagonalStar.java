public class DiagonalStar {
    public static void main(String[] args) {
        printSquareStar(70);

    }
    public static void printSquareStar (int number) {


        if (number > 4) {
            for (int currentRow = 1; currentRow <= number; currentRow++) {
                for (int currentColumn = 1; currentColumn <= number; currentColumn++) {
                    if (currentColumn == number) {
                        System.out.println("*");
                    } else if (currentRow == 1) {
                        System.out.print("*");
                    } else if (currentColumn == 1) {
                        System.out.print("*");
                    } else if (currentRow == number) {
                        System.out.print("*");
                    } else if (currentColumn == currentRow) {
                        System.out.print("*");
                    } else if (currentColumn == ((number - currentRow) + 1)) {
                        System.out.print("*");
                    } else System.out.print(" ");
                }
            }
        } else System.out.println("Invalid Value");
    }
}
