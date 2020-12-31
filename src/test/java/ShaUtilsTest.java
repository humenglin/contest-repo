import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShaUtilsTest {
    @Test
    public void should_return_hash_value_given_sha_256_algorithm() {
        String boxId = "1";
        String nowDate = "20201231143030";
        String hashValueOfLastBox = "0";
        String mysteriousNo = "0";
        String message = new StringBuilder(boxId).append(nowDate).append(hashValueOfLastBox).append(mysteriousNo).toString();

        String hashValue = ShaUtils.getHashValueBySha256(message);

        assertEquals("60bf8f43e19c81d5fe5d499bb14d1e29778dbbb6a8741a1ddc0fecace2e27f29", hashValue);
    }
}
