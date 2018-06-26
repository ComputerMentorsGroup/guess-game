package com.clwillingham.example.guessing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static final int MAX_NUMBER = 10000;

    private boolean isRunning = true;

    final int number;
    private Player[] players;

    private int rounds = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player[] players = new Player[]{
                new HumanPlayer("Player 1", scanner),
                new RobotPlayer("Robot 1"),
                new SmartBotPlayer("Robot 2")
        };
        Game game = new Game(MAX_NUMBER, players);
        while(game.isRunning()){
            game.loop();
        }
    }

    public Game(int max, Player[] players){
        Random generator = new Random();
        this.players = players;
        number = generator.nextInt(max);
    }

    public void loop(){
        System.out.println("Round " + rounds);
        for(Player player : players){
            int playerGuess = player.getGuess();
            GuessResult result = guess(playerGuess);

            tellPlayers(player, playerGuess, result);
            if(!isRunning) return;
        }
        rounds++;
    }

    private void tellPlayers(Player guesser, int guess, GuessResult result){

        switch (result){
            case GREATOR:
                System.out.println("The number is greator than " + guess);
                break;
            case LESS:
                System.out.println("The number is less than " + guess);
                break;
            case EQUAL:
                System.out.println(guesser.getName() + " Wins!");
        }
        System.out.println();

        for(Player player : players){
            player.onResult(guesser, guess, result);
        }
    }

    public GuessResult guess(int guess){
        GuessResult result;
        if(number > guess){
//            System.out.println("The number is greater than " + guess);
            result = GuessResult.GREATOR;
        } else if (number < guess) {
//            System.out.println("The number is less than " + guess);
            result = GuessResult.LESS;
        }else{
//            System.out.println("You win!");
            isRunning = false;
            result = GuessResult.EQUAL;
        }
        return result;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
