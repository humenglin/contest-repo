import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TreasureBoxTest {
    @Test
    public void should_return_hash_value_of_first_box_given_a_mysterious_number() throws ParseException {
        int mysteriousNo = 1;
        TreasureBox treasureBox = new TreasureBox(1, "0", mysteriousNo);

        String actualHashValue = treasureBox.calculateHashValue();

        assertEquals("938db8c9f82c8cb58d3f3ef4fd250036a48d26a712753d2fde5abd03a85cabf4", actualHashValue);
    }

    @Test
    public void should_return_false_when_judge_status_given_a_wrong_mysterious_number() throws ParseException {
        int mysteriousNo = 1;
        TreasureBox treasureBox = new TreasureBox(1, "0", mysteriousNo);

        boolean actualStatus = treasureBox.judgeStatus();

        assertFalse(actualStatus);
    }
}
