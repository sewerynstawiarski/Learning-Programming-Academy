public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }
    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.printf(title + "is a " + instanceType + " film\n");
    }
    public static Movie getMovie(String type, String title) {
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new SienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something bad happens"
        );
    }
    public void watchAdventure() {
        System.out.println("Watching and Adventure");
    }
}

    class Comedy extends Movie {
        public Comedy(String title) {
            super(title);
        }

        @Override
        public void watchMovie() {
            super.watchMovie();
            System.out.printf(".. %s%n".repeat(3),
                    "Something funny happens",
                    "Something even funnier happens",
                    "Happy Ending"
            );
        }
        public void watchComedy() {
            System.out.println("Watching a Comedy");
        }
    }

    class SienceFiction extends Movie {
        public SienceFiction(String title) {
            super(title);
        }

        @Override
        public void watchMovie() {
            super.watchMovie();
            System.out.printf(".. %s%n".repeat(3),
                    "Aliens do bad stuff",
                    "Space guys chase them",
                    "Death Star blows up"
            );
        }
        public void watchScienceFiction() {
            System.out.println("Watching and Science Fiction");
        }
    }

