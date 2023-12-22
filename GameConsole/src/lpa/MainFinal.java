package lpa;

import lpa.game.Game;
import lpa.game.GameAction;
import lpa.game.GameConsole;
import lpa.game.Player;
import lpa.game.pritageGameSolution.PirateGame1;
import lpa.game.pritageGameSolution.Weapon1;

import java.util.function.Predicate;

// class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>> {
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}
public class MainFinal {
    public static void main(String[] args) {
 GameConsole game = new GameConsole<>(new PirateGame1("Pirate Game"));
    }
}
