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
        int mysteriousNo = 3229170;
        TreasureBox treasureBox = new TreasureBox(1, "0");

        boolean actualStatus = treasureBox.play(mysteriousNo);

        assertTrue(actualStatus);
    }

    @Test
    public void should_return_right_mysterious_no_when_find_right_mysterious_no() {
        TreasureBox treasureBox = new TreasureBox(1, "0");

        int actualMysteriousNo = treasureBox.findRightMysteriousNo();

        assertEquals(3229170, actualMysteriousNo);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_first_box() {
        TreasureBox treasureBox = new TreasureBox(1, "0");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(3229170, actualMysteriousNo);

        int mysteriousNo = 3229170;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("0000079dda0cef8b640efd9d6a475fb179f29e52f9f0800f47f58d3998a20b15", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_second_box() {
        TreasureBox treasureBox = new TreasureBox(2, "0000079dda0cef8b640efd9d6a475fb179f29e52f9f0800f47f58d3998a20b15");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(1135497, actualMysteriousNo);

        int mysteriousNo = 1135497;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000000102a4cb841e9c70ff7e5f04fb18f9b584258ce97c98189febcda579596", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_third_box() {
        TreasureBox treasureBox = new TreasureBox(3, "000000102a4cb841e9c70ff7e5f04fb18f9b584258ce97c98189febcda579596");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(2125891, actualMysteriousNo);

        int mysteriousNo = 2125891;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000002dcc19bc7c86528c625c9b5a11c066b76875cf344639dc50f807ac3dec3", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_4th_box() {
        TreasureBox treasureBox = new TreasureBox(4, "000002dcc19bc7c86528c625c9b5a11c066b76875cf344639dc50f807ac3dec3");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(3041721, actualMysteriousNo);

        int mysteriousNo = 3041721;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("00000efee702d3229f253e61154dbe4d152b276fcba9980ff7f841137608e3af", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_5th_box() {
        TreasureBox treasureBox = new TreasureBox(5, "00000efee702d3229f253e61154dbe4d152b276fcba9980ff7f841137608e3af");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(179272, actualMysteriousNo);

        int mysteriousNo = 179272;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("0000007b54832063dbd8ca2bc6fa49774fc2d6388cfeeed6312e1459526819d0", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_6th_box() {
        TreasureBox treasureBox = new TreasureBox(6, "0000007b54832063dbd8ca2bc6fa49774fc2d6388cfeeed6312e1459526819d0");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(1295904, actualMysteriousNo);

        int mysteriousNo = 1295904;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("0000084b0b72e00f044ab399e1b8f1b2c9d3060e81d0d881b31b116334f6b484", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_7th_box() {
        TreasureBox treasureBox = new TreasureBox(7, "0000084b0b72e00f044ab399e1b8f1b2c9d3060e81d0d881b31b116334f6b484");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(395138, actualMysteriousNo);

        int mysteriousNo = 395138;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("00000b1061220e6c95d511c8b2b5a8206101b02fb8f96436c0c56d12c78348c9", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_8th_box() {
        TreasureBox treasureBox = new TreasureBox(8, "00000b1061220e6c95d511c8b2b5a8206101b02fb8f96436c0c56d12c78348c9");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(1871275, actualMysteriousNo);

        int mysteriousNo = 1871275;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000007db8d6c79327c9e58348301312fa2f3e818348ab4bff39e25fe65254020", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_9th_box() {
        TreasureBox treasureBox = new TreasureBox(9, "000007db8d6c79327c9e58348301312fa2f3e818348ab4bff39e25fe65254020");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(99911, actualMysteriousNo);

        int mysteriousNo = 99911;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000002d090883b9cec6f5ad6c1bff62d598890d935313f402d34d8353ea85081", actualHashValue);
    }

    @Test
    public void should_return_right_mysterious_no_and_hash_value_given_10th_box() {
        TreasureBox treasureBox = new TreasureBox(10, "000002d090883b9cec6f5ad6c1bff62d598890d935313f402d34d8353ea85081");
        int actualMysteriousNo = treasureBox.findRightMysteriousNo();
        assertEquals(1695112, actualMysteriousNo);

        int mysteriousNo = 1695112;
        String actualHashValue = treasureBox.calculateHashValue(mysteriousNo);
        assertEquals("000008168d5d5680cab46470ae7f7861d167b00a145210cf15a6aa686f2715ef", actualHashValue);
    }
}
