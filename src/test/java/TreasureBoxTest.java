import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TreasureBoxTest {
    @Test
    public void should_return_hash_value_of_first_box_given_a_mysterious_number() throws ParseException {
        int mysteriousNo = 1;
        Date nowDate = new SimpleDateFormat("yyyyMMddHHmmss").parse("20201231143030");
        TreasureBox treasureBox = new TreasureBox(1, nowDate, "0", mysteriousNo);

        String actualHashValue = treasureBox.calculateHashValue();

        assertEquals("7ab3f8b93d83dad40c54e0f62585fa2daf02877edc84eb7ecd9aeb35c4ee2179", actualHashValue);
    }
}
