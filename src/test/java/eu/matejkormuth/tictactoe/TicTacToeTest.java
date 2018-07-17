package eu.matejkormuth.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInTheBeginningAllMovesAreLegal() {
        for (int i = 0; i < 9; i++) {
            Assert.assertTrue(game.isMoveLegal(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPositionForGetState() {
        game.getState(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPositionForPlay() {
        game.playMove(TicTacToe.PLAYER_X, 100);
    }

    @Test
    public void testRemembersMoves() {
        game.playMove(TicTacToe.PLAYER_X, 3);
        game.playMove(TicTacToe.PLAYER_O, 4);
        Assert.assertEquals(game.getState(3), TicTacToe.PLAYER_X);
        Assert.assertEquals(game.getState(4), TicTacToe.PLAYER_O);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testXCannotPlayOnO() {
        game.playMove(TicTacToe.PLAYER_O, 0);
        game.playMove(TicTacToe.PLAYER_X, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testXCannotPlayAfterX() {
        game.playMove(TicTacToe.PLAYER_X, 0);
        game.playMove(TicTacToe.PLAYER_X, 1);
    }

    @Test
    public void testWinByVerticalLine() {
        game.playMove(TicTacToe.PLAYER_X, 0);
        game.playMove(TicTacToe.PLAYER_O, 4);
        game.playMove(TicTacToe.PLAYER_X, 3);
        game.playMove(TicTacToe.PLAYER_O, 8);
        game.playMove(TicTacToe.PLAYER_X, 6);
        Assert.assertTrue(game.hasWon(TicTacToe.PLAYER_X));
    }

    @Test
    public void testWinByHorizontalLine() {
        game.playMove(TicTacToe.PLAYER_X, 0);
        game.playMove(TicTacToe.PLAYER_O, 3);
        game.playMove(TicTacToe.PLAYER_X, 2);
        game.playMove(TicTacToe.PLAYER_O, 4);
        game.playMove(TicTacToe.PLAYER_X, 6);
        game.playMove(TicTacToe.PLAYER_O, 5);
        Assert.assertTrue(game.hasWon(TicTacToe.PLAYER_O));
    }

    @Test
    public void testWinByDiagonalLine() {
        game.playMove(TicTacToe.PLAYER_X, 0);
        game.playMove(TicTacToe.PLAYER_O, 3);
        game.playMove(TicTacToe.PLAYER_X, 4);
        game.playMove(TicTacToe.PLAYER_O, 6);
        game.playMove(TicTacToe.PLAYER_X, 8);
        Assert.assertTrue(game.hasWon(TicTacToe.PLAYER_X));
    }

    @Test
    public void testDraw() {
        game.playMove(TicTacToe.PLAYER_X, 0);
        game.playMove(TicTacToe.PLAYER_O, 1);
        game.playMove(TicTacToe.PLAYER_X, 2);
        game.playMove(TicTacToe.PLAYER_O, 3);
        game.playMove(TicTacToe.PLAYER_X, 5);
        game.playMove(TicTacToe.PLAYER_O, 4);
        game.playMove(TicTacToe.PLAYER_X, 6);
        game.playMove(TicTacToe.PLAYER_O, 8);
        game.playMove(TicTacToe.PLAYER_X, 7);
        Assert.assertFalse(game.hasWon(TicTacToe.PLAYER_X));
        Assert.assertFalse(game.hasWon(TicTacToe.PLAYER_O));
        Assert.assertTrue(game.isDraw());
    }

}
