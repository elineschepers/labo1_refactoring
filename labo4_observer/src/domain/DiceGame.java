package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiceGame {
    private ArrayList<Player> players;
    private Dice d1, d2;
    private Map<Integer, Player> rounds;
    private int round;
    private Player winnerRound;
    private int highestScore;

    public DiceGame() {
        rounds = new HashMap<>();
        players = new ArrayList<>();

        d1 = new Dice();
        d2 = new Dice();
    }

    public void addPlayerToGame(Player p){
        players.add(p);
    }

    public Player getSpelerBySpelersnr(int spelersnr) {
        for (Player p: players) {
            if (p.getSpelersnummer() == spelersnr) {
                return p;
            }
        }
        return null;
    }

    public int berekenPunten(Player p) {
        int rol1 = d1.RollDice();
        int rol2 = d2.RollDice();
        int score = 0;

        if (rol1 == rol2) {
            score = (rol1 + rol2) * 2;
        } /*else if (p.getVorigeBeurt() != 0) {
            if ((rol1 + rol2) == p.getVorigeBeurt()) {
                score = (rol1 + rol2) + 5;
            }
        } */else {
            score = rol1 + rol2;
        }
        return score;
    }

    public void verwerkWorp(Player p) {
        int worp = berekenPunten(p);

        p.setHuidigeBeurt(worp);
        p.setTotaalResultaat(p.getTotaalResultaat() + p.getHuidigeBeurt());
        p.setAantalBeurtenGespeeld(p.getAantalBeurtenGespeeld() + 1);
        p.notifyObservers();

        System.out.println("Worp: " + worp);
        System.out.println("Spelers nummer: " + p.getSpelersnummer());
        System.out.println("Deze Beurt: " + p.getHuidigeBeurt());
        System.out.println("Voorlopig Totaal: " + p.getTotaalResultaat());
        System.out.println("Aantal beurten gespeeld: " + p.getAantalBeurtenGespeeld());
    }
}