package domain;

import java.util.Random;

public class Dice {
    Random random;

    public Dice() {
        random = new Random();
    }

    public int RollDice() {
        int randomEyes = random.nextInt(7);
        return randomEyes;

    }
}
