package com.clwillingham.example.guessing;

public abstract class Player {
    private String name;
    public abstract int getGuess();
    public abstract void onResult(Player player, int guess, GuessResult result);

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
