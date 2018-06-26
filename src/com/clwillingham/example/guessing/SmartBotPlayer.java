package com.clwillingham.example.guessing;


import java.util.Random;

public class SmartBotPlayer extends Player {
    private int max = Game.MAX_NUMBER;
    private int min = 0;
    private final Random random = new Random();

    public SmartBotPlayer (String name) {
        super(name);
    }

    @Override
    public int getGuess() {
        System.out.print(getName() + " pick a number:");
        int number;
        if(max != min)
            number = min+((max-min)/2);
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
    }
}