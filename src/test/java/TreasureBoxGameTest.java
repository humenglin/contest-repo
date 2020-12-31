import exception.BoxNumIsOutOfBoundaryException;
import exception.ThisBoxCannotPlayException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreasureBoxGameTest {
    @Test
    public void should_return_false_when_open_first_box_given_a_init_treasure_box_game_and_a_wrong_mysterious_no() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        boolean actualStatus = treasureBoxGame.play(1, 38);

        assertFalse(actualStatus);
    }

    @Test(expected = BoxNumIsOutOfBoundaryException.class)
    public void should_throw_exception_given_11_box() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        treasureBoxGame.play(11, 38);
    }

    @Test(expected = ThisBoxCannotPlayException.class)
    public void should_throw_exception_given_before_box_is_not_open() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        treasureBoxGame.play(2, 38);
    }

    @Test
    public void should_return_true_when_open_first_box_given_a_init_treasure_box_game_and_a_right_mysterious_no() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        boolean actualStatus = treasureBoxGame.play(1, 3229170);
        boolean gameStatus = treasureBoxGame.getFinalStatus();

        assertTrue(actualStatus);
        assertFalse(gameStatus);
    }

    @Test
    public void should_return_game_status_is_open_when_game_is_over_given_10_right_mysterious_no() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        treasureBoxGame.play(1, 3229170);
        treasureBoxGame.play(2, 1135497);
        treasureBoxGame.play(3, 2125891);
        treasureBoxGame.play(4, 3041721);
        treasureBoxGame.play(5, 179272);
        treasureBoxGame.play(6, 1295904);
        treasureBoxGame.play(7, 395138);
        treasureBoxGame.play(8, 1871275);
        treasureBoxGame.play(9, 99911);
        treasureBoxGame.play(10, 1695112);
        boolean gameStatus = treasureBoxGame.getFinalStatus();

        assertTrue(gameStatus);
    }

    @Test
    public void should_return_game_status_is_close_when_game_is_over_given_5_right_mysterious_no_and_6th_is_wrong() throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        treasureBoxGame.play(1, 3229170);
        treasureBoxGame.play(2, 1135497);
        treasureBoxGame.play(3, 2125891);
        treasureBoxGame.play(4, 3041721);
        treasureBoxGame.play(5, 179272);
        treasureBoxGame.play(6, 1);
        boolean gameStatus = treasureBoxGame.getFinalStatus();

        assertFalse(gameStatus);
    }
}
