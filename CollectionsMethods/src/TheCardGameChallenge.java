import java.util.*;

public class TheCardGameChallenge {
    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Collections.shuffle(deck);

        Card.printDeck(deck, "Shuffle: ", 4);

        List<Card> player1 = getPlayerHand(deck, 7);
        List<Card> player2 = getPlayerHand(deck, 7);
        List<Card> player3 = getPlayerHand(deck, 7);
        List<Card> player4 = getPlayerHand(deck, 7);


        Card.printDeck(player1, "Player 1 deck: ", 1);
        Card.printDeck(player2, "Player 2 deck: ", 1);
        Card.printDeck(player3, "Player 3 deck: ", 1);
        Card.printDeck(player4, "Player 4 deck: ", 1);

        gameOfRankPoint(player1,player2,player3,player4);
    }

    private static List<Card> getPlayerHand (List<Card> deck, int numberOfCards) {
        Random random = new Random();
        List<Card> playerDeck = new ArrayList<>(numberOfCards);
       int index = numberOfCards -1;

       while (index > -1) {
           Card nextCard = deck.get(random.nextInt(0,deck.size()));
           playerDeck.add(nextCard);
           deck.remove(nextCard);
               index--;
           }
        return playerDeck;
       }


    private static void  gameOfRankPoint(List<Card>... players) {
    List<Integer> results = new ArrayList<>(players.length);
        for (List<Card> p :
                players) {
            int result = 0;
            for (Card card : p) {
                result = result + card.rank();
            }
            results.add(result);

        }
        System.out.println(results);
        int winner = Collections.max(results);

        if (Collections.frequency(results, winner) > 1) {
        int indexOfFirst = results.indexOf(winner);
        int indexOfLast = results.lastIndexOf(winner);

        var comparingRankCards = Comparator.comparing(Card::rank);
        List<Card> player11 = players[indexOfFirst];
        List<Card> player22 = players[indexOfLast];

        player11.sort(comparingRankCards.reversed());
        player22.sort(comparingRankCards.reversed());

        if (player11.get(0).rank() > player22.get(0).rank()) {
            System.out.println("The Winner is player number: " + (indexOfFirst + 1)  + " thanks to " + player11.get(0).toString()
                    + " over " + player22.get(0).toString());
        } else if (player22.get(0).rank() > player11.get(0).rank()) {
            System.out.println("The Winner is player number: " + (indexOfLast + 1) + " thanks to " + player22.get(0).toString()
                    + " over " + player11.get(0).toString());
        } else {
            System.out.println("It's just a f**king tie. O.K.?");
        }
        } else {

            System.out.println("The Winner is player number: " + (results.indexOf(winner) + 1) + " with " + winner + " points");
        }


    }
}
