package eu.matejkormuth.tictactoe;

/**
 * Class that holds game logic for Tic-Tac-Toe.
 * <p>
 * Board is realized by using array where array indices
 * are used to denote positions as show in following figure.
 * <pre>
 *  0 | 1 | 2
 * ---+---+---
 *  3 | 4 | 5
 * ---+---+---
 *  6 | 7 | 8
 * </pre>
 */
public class TicTacToe {

    /* Integer constants for players. */
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = -1;

    private final int[] board = new int[9];

    private int nextPlayer = 0;

    /**
     * Returns whether the specified move (position) is at this moment legal.
     * <p>
     * Legal move is move to empty place on board only.
     *
     * @param position position to check
     * @return true if specified move (position) is valid, false otherwise
     */
    public boolean isMoveLegal(int position) {
        if (!isPositionLegal(position)) {
            throw new IllegalArgumentException("Illegal position!");
        }

        return board[position] == 0;
    }

    private boolean isPositionLegal(int position) {
        return position < 9;
    }

    /**
     * Returns the board state at specified position.
     *
     * @param position position to return state at
     * @return 0 if no player has symbol on specified position, player integral id otherwise
     */
    public int getState(int position) {
        if (!isPositionLegal(position)) {
            throw new IllegalArgumentException("Illegal position!");
        }

        return board[position];
    }

    /**
     * Plays specified move (player and position).
     *
     * @param player   player to play move with
     * @param position position to place player's symbol
     */
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

    /**
     * Returns whether the specified player has won the game at this moment.
     * <p>
     * Winning the game means connecting three adjacent dots in a row, in a column or diagonally.
     *
     * @param player player to check
     * @return true if specified player won the game at this moment, false otherwise
     */
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

    /**
     * Returns whether this game resulted in a draw.
     * <p>
     * Draw is situation when there are no more moves left and no player
     * has won the game.
     *
     * @return true if the game resulted in a draw, false otherwise
     */
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
