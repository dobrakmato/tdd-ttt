import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToePresenterTest {

    TicTacToePresenter presenter;

    @Before
    public void setUp() {
        presenter = new TicTacToePresenter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTranslateNonExistingState() {
        presenter.translateState(7);
    }

    @Test
    public void testTranslateExistingStates() {
        Assert.assertEquals(presenter.translateState(TicTacToe.PLAYER_O), 'O');
        Assert.assertEquals(presenter.translateState(TicTacToe.PLAYER_X), 'X');
        Assert.assertEquals(presenter.translateState(0), ' ');
    }
}