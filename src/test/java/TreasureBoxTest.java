import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class TreasureBoxTest {
    @Test
    public void should_return_hash_value_of_first_box_given_a_mysterious_number() throws ParseException {
        int mysteriousNo = 1;
        TreasureBox treasureBox = new TreasureBox(1, "0");

        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);

        assertTrue(actualHashValue.length() > 0);
    }

    @Test
    public void should_return_false_when_play_given_a_wrong_mysterious_number() throws ParseException {
        int mysteriousNo = 1;
        TreasureBox treasureBox = new TreasureBox(1, "0");

        boolean actualStatus = treasureBox.play(mysteriousNo);

        assertFalse(actualStatus);
    }

    @Test
    public void should_return_true_when_play_given_a_right_mysterious_number() throws ParseException {
        int mysteriousNo = 610536;
        TreasureBox treasureBox = new TreasureBox(1, "0");

        boolean actualStatus = treasureBox.play(mysteriousNo);

        assertTrue(actualStatus);
    }

    @Test
    public void should_return_right_mysterious_no_when_find_right_mysterious_no() {
        TreasureBox treasureBox = new TreasureBox(1, "0");

        int actualMysteriousNo = treasureBox.findRightMysteriousNo();

        assertEquals(610536, actualMysteriousNo);
    }
}
