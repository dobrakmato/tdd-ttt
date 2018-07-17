package eu.matejkormuth.tictactoe;

import java.util.Random;

public class TicTacToePresenter {

    public static final int PLAYING_SPEED = 2000;

    private TicTacToeFormatter formatter;
    private TicTacToe game;
    private Random random;
    private int currentPlayer = TicTacToe.PLAYER_O;

    public TicTacToePresenter() {
        this.formatter = new TicTacToeFormatter();
        this.game = new TicTacToe();
        this.random = new Random();
    }

    private void println(String str) {
        System.out.println(str);
    }

    private void printCurrentPlayer() {
        println(formatter.formatCurrentPlayerMessage(currentPlayer));
    }

    private void printBoard() {
        for (int row = 0; row < 3; row++) {
            println(formatter.formatBoardRow(game, row));
            println(formatter.formatBoardRowSeparator());
        }
    }

    private void printWin(String who) {
        println(formatter.formatSeparator());
        println(formatter.formatWin(who));
    }

    private void printDraw() {
        println(formatter.formatSeparator());
        println(formatter.formatDraw());
    }

    public void startGame() {
        println("Staring game.");
        printBoard();
        println(formatter.formatStartMessage(currentPlayer));
        println(formatter.formatSeparator());
        sleep();
        nextMove();
    }

    private void nextMove() {
        int move = findValidMove();

        game.playMove(currentPlayer, move);

        println(formatter.formatSeparator());
        printCurrentPlayer();
        printBoard();

        if (checkIsGameFinished()) return;

        sleep();

        // switch player
        currentPlayer *= -1;
        nextMove();
    }

    private int findValidMove() {
        int move = random.nextInt(9);
        while (!game.isMoveLegal(move)) { // pls no stuck
            move = random.nextInt(9);
        }
        return move;
    }

    private boolean checkIsGameFinished() {
        if (game.hasWon(TicTacToe.PLAYER_O)) {
            printWin("O");
            return true;
        }

        if (game.hasWon(TicTacToe.PLAYER_X)) {
            printWin("X");
            return true;
        }

        if (game.isDraw()) {
            printDraw();
            return true;
        }
        return false;
    }

    private void sleep() {
        try {
            Thread.sleep(PLAYING_SPEED);
        } catch (InterruptedException e) {
        }
    }
}
