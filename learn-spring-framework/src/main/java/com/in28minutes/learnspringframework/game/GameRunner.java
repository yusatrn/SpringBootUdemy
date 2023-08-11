package com.in28minutes.learnspringframework.game;

public class GameRunner {
   private PacmanGame game;
    public GameRunner(PacmanGame game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
