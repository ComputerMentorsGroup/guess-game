package com.clwillingham.example.guessing;

import java.util.Random;

public class RobotPlayer extends Player {
    private int max = Game.MAX_NUMBER;
    private int min = 0;
    private final Random random = new Random();

    public RobotPlayer(String name) {
        super(name);
    }

    @Override
    public int getGuess() {
        System.out.print(getName() + " pick a number:");
        int number;
        if(max != min)
            number = random.nextInt(max-min)+min;
        else
            number = min;
        System.out.println(number);
        return number;
    }

    @Override
    public void onResult(Player player, int guess, GuessResult result) {
        switch (result){
            case GREATOR:
                if(guess+1 > min)
                    min = guess+1;
                break;
            case LESS:
                if(guess-1 < max)
                    max = guess-1;
                break;
        }
//        System.out.printf("New range %d to %d\n", min, max);
    }
}
