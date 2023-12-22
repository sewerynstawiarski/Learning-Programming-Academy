import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Movie theMovie = Movie.getMovie("Sience", "Staw Wars");
//theMovie.watchMovie();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter type ( A for Adventure, C for Comedy, S for SienceFiction, or Q for Quit: ");
            String type = s.nextLine();
            if ("Qq".contains(type)) {
                break;
            }
            System.out.println("Enter movie title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
