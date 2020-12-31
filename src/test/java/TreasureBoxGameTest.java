import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TreasureBoxGameTest {
    @Test
    public void should_return_false_when_open_first_box_given_a_init_treasure_box_game_and_a_wrong_mysterious_no() {
        TreasureBoxGame treasureBoxGame = new TreasureBoxGame();

        boolean actualStatus = treasureBoxGame.play(1, 38);

        assertFalse(actualStatus);
    }
}
