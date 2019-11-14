package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiceGame {
    private ArrayList<Player> players;
    private Dice d1, d2;
    private Map<Integer, Player> rounds;
    private int round;
    // TODO: 7/11/2019  //soeler aan de buurt
    private Player winnerTotal, winnerRound, p1, p2, p3;
    private int highestScore;

    public DiceGame() {
        rounds = new HashMap<>();
        players = new ArrayList<>();
/*
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();


        winnerRound = new Player();
        winnerTotal = new Player();
*/
        d1 = new Dice();
        d2 = new Dice();
    }

    public void addPlayerToGame(Player p){
        players.add(p);
    }
    public void verwerkworp()
    {
        // TODO: 7/11/2019  //gekregen getallen van werp
        // TODO: 7/11/2019  //notify observers
    }
    public void StartGame() {
        int rondenr = 1;

        //While loop voor aantal rondes vanaf hier

        int scoreP1 = d1.RollDice() + d2.RollDice();
        System.out.println("Score P1: " + scoreP1);

        int scoreP2 = d1.RollDice() + d2.RollDice();
        System.out.println("Score P2: " + scoreP2);

        int scoreP3 = d1.RollDice() + d2.RollDice();
        System.out.println("Score P3: " + scoreP3);

        if (scoreP1 > scoreP2) {
            if (scoreP1 > scoreP3) {
                highestScore = scoreP1;
                winnerRound = p1;
                System.out.println("Speler 1 wint deze ronde!");
            } else {
                highestScore = scoreP3;
                winnerRound = p3;
                System.out.println("Speler 3 wint deze ronde!");
            }
        } else {
            if (scoreP2 > scoreP3) {
                highestScore = scoreP2;
                winnerRound = p2;
                System.out.println("Speler 2 wint deze ronde!");
            } else {
                highestScore = scoreP3;
                winnerRound = p3;
                System.out.println("Speler 3 wint deze ronde!");
            }
        }

        rounds.put(rondenr, winnerRound);
        rondenr +=1;

        //Tot hier
    }
}