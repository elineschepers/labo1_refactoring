package domain;

import java.util.HashMap;
import java.util.Map;

public class DiceGame {
    private Player[] players;
    private Dice d1, d2;
    private Map<Integer, Player> rounds;
    private int round;
    private Player winnerTotal, winnerRound, p1, p2, p3;
    private int highestScore;

    public DiceGame() {
        rounds = new HashMap<>();
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        winnerRound = new Player();
        winnerTotal = new Player();
        d1 = new Dice();
        d2 = new Dice();
    }

    public void StartGame() {
        int scoreP1 = d1.RollDice() + d2.RollDice();
        System.out.println(scoreP1);

        int scoreP2 = d1.RollDice() + d2.RollDice();
        System.out.println(scoreP2);

        int scoreP3 = d1.RollDice() + d2.RollDice();
        System.out.println(scoreP3);


        //IF fixen
        if (scoreP1 > scoreP2) {
            highestScore = scoreP1;
            winnerRound = p1;
        } else if (scoreP1 < scoreP2) {
            highestScore = scoreP2;
            winnerRound = p2;
        }

        if (scoreP3 > highestScore) {
            highestScore = scoreP3;
            winnerRound = p3;
        }
    }
}