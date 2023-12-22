public class MainChallenge {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score =800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted,bonus);
        System.out.println("Your final score was: " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        System.out.println("Your nest final score was: " + calculateScore(gameOver, score, levelCompleted,bonus));

        displayHighScorePosition("Seweryn", calculateHighScorePosition(1500));
        displayHighScorePosition("Sanya", calculateHighScorePosition(1000));
        displayHighScorePosition("Daniel", calculateHighScorePosition(500));
        displayHighScorePosition("Maciek", calculateHighScorePosition(100));
        displayHighScorePosition("Majs", calculateHighScorePosition(25));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;

        }
        return finalScore;
    }
    public static void displayHighScorePosition ( String name, int position) {
        System.out.println(name + " managed to get into position " + position + " in the high score list.");
    }
    public static int calculateHighScorePosition (int score) {
        int position = 4;
        if (score >=1000) {
            position =1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }
        return position;
    }
}
