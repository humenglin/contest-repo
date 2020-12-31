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

    @Test
    public void should_return_game_status_is_open_when_game_is_over_given_10_right_mysterious_no() {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        treasureBoxGame.play(1, 610536);
        treasureBoxGame.play(2, 167626);
        treasureBoxGame.play(3, 661789);
        treasureBoxGame.play(4, 62753);
        treasureBoxGame.play(5, 667142);
        treasureBoxGame.play(6, 3621134);
        treasureBoxGame.play(7, 4479782);
        treasureBoxGame.play(8, 58324);
        treasureBoxGame.play(9, 197357);
        treasureBoxGame.play(10, 613080);
        boolean gameStatus = treasureBoxGame.getFinalStatus();

        assertTrue(gameStatus);
    }
}
