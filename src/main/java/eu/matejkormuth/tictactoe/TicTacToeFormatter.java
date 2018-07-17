package eu.matejkormuth.tictactoe;

public class TicTacToeFormatter {

    public String formatSeparator() {
        return "";
    }

    public String formatDraw() {
        return "Game ends with a draw!";
    }

    public String formatCurrentPlayerMessage(int currentPlayer) {
        return "Player " + (currentPlayer == TicTacToe.PLAYER_X ? "X" : "O") + " played:";
    }

    public String formatBoardRow(TicTacToe game, int row) {
        return String.format(
                "%s|%s|%s",
                translateState(game.getState(3 * row)),
                translateState(game.getState(3 * row + 1)),
                translateState(game.getState(3 * row + 2))
        );
    }

    public String formatBoardRowSeparator() {
        return "-+-+-";
    }

    public String formatWin(String who) {
        return "Player " + who + " won!";
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

    public String formatStartMessage(int player) {
        return "The game will start with Player " + (player == TicTacToe.PLAYER_X ? "X" : "O") + ".";
    }
}
