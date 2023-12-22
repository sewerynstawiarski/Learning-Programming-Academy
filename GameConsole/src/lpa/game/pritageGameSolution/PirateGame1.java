package lpa.game.pritageGameSolution;

import lpa.game.Game;
import lpa.game.GameAction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PirateGame1 extends Game<Pirate1> {
    private static final List<List<Town1>> levelMap;

    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading Data...");
        loadData();

        if (levelMap.size() == 0) {
            throw new RuntimeException("Could not load data, try later");
        }
        System.out.println("Finished Loading Data  ");
    }

    public PirateGame1(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate1 createNewPlayer(String name) {
        return new Pirate1(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Pirate1 pirate1 = getPlayer(playerIndex);
        System.out.println(pirate1);
        List<Weapon1> weapons = Weapon1.getWeaponsByLevel(pirate1.value("level"));

        Map<Character, GameAction> map = new LinkedHashMap<>();
        if (pirate1.hasOpponents()) {
            for (Weapon1 weapon : weapons) {
                char init = weapon.name().charAt(0);
                map.put(init, new GameAction(init, "Use " + weapon, this::useWeapon));
            }
        }
        map.put('F', new GameAction('F', "Find Loot", this::findLoot));
        if (pirate1.hasExperiences()) {
            map.put('X', new GameAction('X', "Experience Town Feature", this::experienceFeature));
        }
        map.putAll(getStandardActions());
        return map;
    }

    private static void loadData() {
        // Level 1 Towns
        levelMap.add(new ArrayList<>(List.of(
new Town1("Bridgetown", "Barbados", 0),
                new Town1("Fitts Village", "Barbados", 0),
                new Town1("Holetown", "Barbados", 0)

        )));
        // Level 2 Towns
        levelMap.add(new ArrayList<>(List.of(
                new Town1("Fort-de-France", "Martinique", 1),
                new Town1("Sainte-Anne", "Martinique", 1),
                new Town1("Le Vauelin", "Martinique", 1)

        )));
    }
    public static List<Town1> getTowns(int level) {
        if (level <= (levelMap.size() -1)) {
            return levelMap.get(level);
        }
        return null;
    }

    private boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon();
    }

    @Override
    public boolean executeGameAction(int player, GameAction action) {
        getPlayer(player).setCurrentWeapon(Weapon1.getWeaponByChar(action.key()));
        return super.executeGameAction(player, action);
    }

    @Override
    public boolean printPlayer(int playerIndex) {
        System.out.println(getPlayer(playerIndex).information());
        return false;
    }
    private boolean findLoot(int indexPlayer) {
        return getPlayer(indexPlayer).findLoot();
    }
    private boolean experienceFeature(int playerIndex) {
        return getPlayer(playerIndex).experienceFeature();
    }
}
