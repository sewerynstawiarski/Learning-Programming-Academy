public class Main {
    public static void main(String[] args) {


        System.out.println("New score is " + calculateScore("tim", 500));
        System.out.println("New score is " + calculateScore(10));
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        return calculateScore("Annonymous", 100);
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }
}
