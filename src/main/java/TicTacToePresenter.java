import java.util.Random;

public class TicTacToePresenter {

    public static final int PLAYING_SPEED = 2000;

    private TicTacToe game;
    private Random random;
    private int currentPlayer = TicTacToe.PLAYER_O;

    public TicTacToePresenter() {
        this.game = new TicTacToe();
        this.random = new Random();
    }

    public void printCurrentPlayer() {
        System.out.println("Player " + (currentPlayer == TicTacToe.PLAYER_X ? "X" : "O") + " played :");
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format(
                    "%s|%s|%s",
                    translateState(game.getState(3 * i)),
                    translateState(game.getState(3 * i + 1)),
                    translateState(game.getState(3 * i + 2))
            ));
            System.out.println("-+-+-");
        }
    }

    public void printWin(String who) {
        printSeparator();
        System.out.println("Player " + who + " won!");
    }

    public void printDraw() {
        printSeparator();
        System.out.println("Game ends with a draw!");
    }

    public void printSeparator() {
        System.out.println();
    }

    public char translateState(int state) {
        if (state == 0) {
            return ' ';
        }
        if (state == TicTacToe.PLAYER_X) {
            return 'X';
        }
        if (state == TicTacToe.PLAYER_O) {
            return 'O';
        }

        throw new IllegalArgumentException("Invalid state provided!");
    }

    public void startGame() {
        System.out.println("Staring game.");
        printBoard();
        System.out.println("The game will start with Player " + (currentPlayer == TicTacToe.PLAYER_X ? "X" : "O"));
        printSeparator();
        sleep();
        nextMove();
    }

    private void nextMove() {
        int move = findValidMove();

        game.playMove(currentPlayer, move);


        printSeparator();
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
