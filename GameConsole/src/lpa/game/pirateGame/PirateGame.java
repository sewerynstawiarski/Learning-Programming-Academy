package lpa.game.pirateGame;

import lpa.game.Game;
import lpa.game.GameAction;
import lpa.game.Player;

import java.lang.reflect.Array;
import java.util.*;

public class PirateGame extends Game<Pirate> {
    static List<List<Town>> levelMap = new ArrayList<>();

    private List<Pirate> players = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    {
        levelMap.add(new ArrayList<>(List.of(new Town("Mappa", false, 0), new Town("Skelige",false, 0),
                new Town("Oxenfurd", true, 0))));
        levelMap.add(new ArrayList<>(List.of(new Town("Novigrad", false, 1), new Town("Luxon", true, 1))));
        players.add(new Pirate("Keves"));
        players.add(new Pirate("Daniek"));
    }
    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        var map = new LinkedHashMap<>(Map.of(
                'H', new GameAction('H', "Hit Someone", this::hitSomeone),
                'S',
                new GameAction('S', "Set level", this::setLevel),
                'W', new GameAction('W', "Change Weapon", this::changeWeapon),
                'C', new GameAction('C', "Change location", this::moveTo),
                'F', new GameAction('F', "Find Loot", this::FindLoot),
                'E', new GameAction('E', "Experience Town", this::ExperienceTown),
                'D', new GameAction('D', "Hit Opponent in the City", this::HitOpponent)
        )
        );
        map.putAll(getStandardActions());
        return map;
    }

    public boolean setLevel(int playerIndex) {
        System.out.println("Put in level. Max = 8 Min 1: ");
        boolean good = true;
        while (true) {
            int level =  scanner.nextInt();
            if (level > 0 && level < 9) {
                return getPlayer(playerIndex).setLevel(level);
            } else {
                System.out.println("Only number between 1-8!");
            }
        }
    }
    public boolean hitSomeone(int playerIndex) {
        System.out.println("Choose who " +  getPlayer(playerIndex). name() + " is hitting.\n You can choose number of player 0 to "
        + players.size() + " :");
        while (true) {
            int otherPlayer = scanner.nextInt();
            if (otherPlayer >= 0 && otherPlayer < (players.size())) {
                return getPlayer(playerIndex).hit(players.get(otherPlayer));
            } else {
                System.out.println("Only number between 0 - " + players.size() + "!");
            }
        }
    }
    public boolean changeWeapon(int indexPlayer) {
        System.out.println("Choose number of weapon you want to use: ");
        List<Weapon> weapons = new ArrayList<>(Arrays.asList(Weapon.values()));
        int index = 0;
        for (Weapon w :
                weapons) {
            System.out.println(index + ": " + w);
            index++;
        }
        int chosenWeapon =  scanner.nextInt();
        Weapon newWeapon = weapons.get(chosenWeapon);
        return getPlayer(indexPlayer).changeWeapon(newWeapon);
    }
    public boolean moveTo(int indexPlayer) {
        System.out.println("Choose level and place you want to go to: ");
        int level;
    while (true) {
        int index = 0;
        for (List<Town> list :
                levelMap) {
            System.out.println("Level " + index + ": ");
            index++;
            }
        level = scanner.nextInt();
        if (level > -1 && level < levelMap.size()) {
            List<Town> places = levelMap.get(level);
            int index2 = 0;
            for (var s :
                    places) {
                System.out.println(index2 + ": " + s);
                index2++;
            }
            int nextPlace = scanner.nextInt();
            if (nextPlace > -1 && nextPlace < places.size()) {
                return getPlayer(indexPlayer).moveTo(places.get(nextPlace));
        } else {
                System.out.println("Incorrect number!");
            }
        } else {
            System.out.println("Incorrect number of location!");
        }
    }
    }
    public boolean FindLoot (int indexPlayer) {
       return getPlayer(indexPlayer).FindLoot();
    }
    public boolean ExperienceTown(int indexPlayer) {
        return getPlayer(indexPlayer).ExperienceTown();
    }
    public boolean HitOpponent(int indexPlayer) {
       Town locationNow = (Town) getPlayer(indexPlayer).getTownsVisited().toArray()[getPlayer(indexPlayer).getTownsVisited().toArray().length -1];
       List<Combatant> opponents = new ArrayList<>(locationNow.opponents());
       if (!opponents.isEmpty()) {
           Combatant opponent = opponents.get(0);
           getPlayer(indexPlayer).hit(opponent);
           if (opponent.getGameData().get("HP") <= 0) {
               locationNow.opponents().remove(opponent);
           } else {
               return opponent.hitPlayer(getPlayer(indexPlayer));
           }
       } else {
           System.out.println("Town cleared of opponents!");
       }
       return false;
    }
}

