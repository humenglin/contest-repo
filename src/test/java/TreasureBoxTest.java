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

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_first_box() {
        TreasureBox treasureBox = new TreasureBox(1, "0");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(610536, actualMysteriousNo);

        int mysteriousNo = 610536;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("00000ba87fb7b85ce9194e09440ee1555369a0af116426e01d4c3cc6b1ec7d67", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_second_box() {
        TreasureBox treasureBox = new TreasureBox(2, "00000ba87fb7b85ce9194e09440ee1555369a0af116426e01d4c3cc6b1ec7d67");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(167626, actualMysteriousNo);

        int mysteriousNo = 167626;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("0000077ec1faa10d7668a79feab0a7e7fea0b7312450b9899ef922bf0f188786", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_third_box() {
        TreasureBox treasureBox = new TreasureBox(3, "0000077ec1faa10d7668a79feab0a7e7fea0b7312450b9899ef922bf0f188786");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(661789, actualMysteriousNo);

        int mysteriousNo = 661789;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000009f15feae5dd134edcae710799e39f7cffe7873d1ca97f0ded2707504430", actualHashValue);
    }
}
