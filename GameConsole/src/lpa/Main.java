package lpa;

import lpa.game.GameConsole;
import lpa.game.ShooterGame;
import lpa.game.pirateGame.Loot;
import lpa.game.pirateGame.PirateGame;
import lpa.game.pirateGame.Town;
import lpa.game.pritageGameSolution.Pirate1;
import lpa.game.pritageGameSolution.PirateGame1;
import lpa.game.pritageGameSolution.Town1;
import lpa.game.pritageGameSolution.Weapon1;

public class Main {
    public static void main(String[] args) {

//    var console =  new GameConsole<>(new ShooterGame("The ShootOut Game"));
//    int playerIndex = console.addPlayer();
//    console.playGame(playerIndex);
//
//        int len = Loot.values().length;
//        System.out.println(len);
//
//        var pirateConsole = new GameConsole<>(new PirateGame("Pirate Game"));
//        int playerIndex =  pirateConsole.addPlayer();
//        pirateConsole.playGame(playerIndex);

//        Weapon1 weapon1 = Weapon1.getWeaponByChar('P');
//        System.out.println("weapon = " + weapon1 + ", hitPoints=" + weapon1.getHitPoints() + ", minLevel" + weapon1.getMinLevel());
//
//        var list = Weapon1.getWeaponsByLevel(1);
//        list.forEach(System.out::println);
//        Pirate1 tim = new Pirate1("Tim");
//        System.out.println(tim);
//
//        PirateGame1.getTowns(0).forEach(t -> System.out.println(t.information()));
//        System.out.println("-".repeat(50));
//        PirateGame1.getTowns(1).forEach(t -> System.out.println(t.information()));



        var console = new GameConsole<>(new PirateGame1("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
