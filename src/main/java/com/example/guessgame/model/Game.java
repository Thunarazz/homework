package com.example.guessgame.model;

public class Game {
    private final int numberToGuess;
    private int attempts;

    public Game() {
        this.numberToGuess = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}
