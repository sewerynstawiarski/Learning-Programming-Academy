import java.util.*;
import java.util.stream.Collectors;

public class MainRandomizationChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        List<Integer> firstDices = rollDices(5);
        System.out.println("You're dice are: " + firstDices);
        List<Integer> numbers = new ArrayList<>(firstDices);

        while (true)  {
            System.out.println("Press Enter to Score.");
            System.out.println("Type \"ALL\" to re-roll all the dice.");
            System.out.println("List number (separated by spaces) to re-roll selected dice");
            var input = scanner.nextLine().split(" ");

            if (Objects.equals(input[0], "")) {
                break;
            }

            List<String> inputNumber = new ArrayList<>(Arrays.asList(input));

        if (inputNumber.get(0).equals("ALL")) {
          numbers = new ArrayList<>(rollDices(5));
            System.out.println("Your dices are: " + numbers);
            } else {
            for (String s : inputNumber) {
                for (Integer i :
                        numbers) {
                    if (Integer.valueOf(s) == i) {
                        numbers.remove(i);
                        break;
                    }
                    }
            }
          System.out.println("Keeping: " + numbers);
            numbers.addAll(rollDices(input.length));
            System.out.println("Your dices are: " + numbers);
        }
        }
        for (Integer i :
                numbers) {
            score += i;
        }
        System.out.println("Your score is: " + score);
    }

    private static List<Integer> rollDices(int numberOfDices) {
        Random random =  new Random();
        List<Integer> dices = random.ints(numberOfDices, 1, 7).boxed().toList();
        return dices;
    }
}
