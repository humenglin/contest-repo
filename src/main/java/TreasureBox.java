import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 宝箱
 * @author humenglin
 */
public class TreasureBox {
    /** 宝箱编号 */
    private int boxId;
    /** 开启时间 */
    private Date openedTime;
    /** 上一个宝箱的Hash值 */
    private String lastHashValue;
    /** Hash值 */
    private String myHashValue;
    /** 神秘数字 */
    private int mysteriousNo;

    public TreasureBox(int boxId, Date openedTime, String lastHashValue, int mysteriousNo) {
        this.boxId = boxId;
        this.openedTime = openedTime;
        this.lastHashValue = lastHashValue;
        this.mysteriousNo = mysteriousNo;
        this.myHashValue = calculateHashValue();
    }

    /**
     * 计算宝箱的hash值
     * @return
     */
    public String calculateHashValue() {
        String treasureBoxStr = this.toString();
        return ShaUtils.getHashValueBySha256(treasureBoxStr);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.boxId)
                .append(new SimpleDateFormat("yyyyMMddHHmmss").format(this.openedTime))
                .append(this.lastHashValue)
                .append(this.mysteriousNo);
        return stringBuilder.toString();
    }

    /**
     * 判断宝箱是否开启
     * @return
     */
    public boolean judgeStatus() {
        return "00000".equals(this.myHashValue.substring(0, 5));
    }
}
