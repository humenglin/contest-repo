import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreasureBoxGameTest {
    @Test
    public void should_return_false_when_open_first_box_given_a_init_treasure_box_game_and_a_wrong_mysterious_no() {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        boolean actualStatus = treasureBoxGame.play(1, 38);

        assertFalse(actualStatus);
    }

    @Test
    public void should_return_true_when_open_first_box_given_a_init_treasure_box_game_and_a_right_mysterious_no() {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        boolean actualStatus = treasureBoxGame.play(1, 610536);
        boolean gameStatus = treasureBoxGame.getFinalStatus();

        assertTrue(actualStatus);
        assertFalse(gameStatus);
    }

}
