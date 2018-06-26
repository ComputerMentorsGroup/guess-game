package com.clwillingham.example.guessing;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;
    private int lastGuess;

    public HumanPlayer(String name, Scanner scanner){
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int getGuess() {
        System.out.print(getName() + " pick a number:");
        return lastGuess = scanner.nextInt();
    }

    @Override
    public void onResult(Player player, int guess, GuessResult result) {
//        if(player != this) return;
//        switch (result){
//            case GREATOR:
//                System.out.println("The number is greator than " + lastGuess);
//                break;
//            case LESS:
//                System.out.println("The number is less than " + lastGuess);
//                break;
//            case EQUAL:
//                System.out.println(player.getName() + " Wins!");
//        }
    }
}
