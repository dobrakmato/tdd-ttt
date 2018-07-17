package eu.matejkormuth.tictactoe;

import eu.matejkormuth.tictactoe.TicTacToe;
import eu.matejkormuth.tictactoe.TicTacToeFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeFormatterTest {

    TicTacToeFormatter formatter;

    @Before
    public void setUp() {
        formatter = new TicTacToeFormatter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTranslateNonExistingState() {
        formatter.translateState(7);
    }

    @Test
    public void testTranslateExistingStates() {
        Assert.assertEquals(formatter.translateState(TicTacToe.PLAYER_O), 'O');
        Assert.assertEquals(formatter.translateState(TicTacToe.PLAYER_X), 'X');
        Assert.assertEquals(formatter.translateState(0), ' ');
    }
}