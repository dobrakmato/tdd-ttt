package eu.matejkormuth.tictactoe;

public class TicTacToe {

    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = -1;

    private final int[] board = new int[9];
    private int nextPlayer = 0;

    public boolean isMoveLegal(int position) {
        if (!isPositionLegal(position)) {
            throw new IllegalArgumentException("Illegal position!");
        }

        return board[position] == 0;
    }

    private boolean isPositionLegal(int position) {
        return position < 9;
    }

    public int getState(int position) {
        if (!isPositionLegal(position)) {
            throw new IllegalArgumentException("Illegal position!");
        }

        return board[position];
    }

    public void playMove(int player, int position) {
        if (!isPositionLegal(position)) {
            throw new IllegalArgumentException("Illegal position!");
        }

        if (!isMoveLegal(position)) {
            throw new IllegalArgumentException("Illegal move played!");
        }

        if (player != nextPlayer && nextPlayer != 0) {
            throw new IllegalArgumentException("Next player is " + nextPlayer);
        }

        board[position] = player;
        if (nextPlayer == 0) {
            nextPlayer = player * -1;
        } else {
            nextPlayer *= -1;
        }
    }

    public boolean hasWon(int player) {
        // horizontal check
        for (int r = 0; r < 3; r++) {
            if (board[3 * r] == player &&
                    board[3 * r + 1] == player &&
                    board[3 * r + 2] == player) {
                return true;
            }
        }

        // vertical check
        for (int c = 0; c < 3; c++) {
            if (board[c] == player &&
                    board[c + 3] == player &&
                    board[c + 6] == player) {
                return true;
            }
        }

        // diagonal check
        return (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player);
    }

    public boolean isDraw() {
        int movesLeft = 9;

        for (int i = 0; i < 9; i++) {
            if (!isMoveLegal(i)) {
                movesLeft--;
            }
        }
        return movesLeft == 0 && !hasWon(PLAYER_O) && !hasWon(PLAYER_X);
    }


}
