/**
 * 宝箱
 * @author humenglin
 */
public class TreasureBox {
    /** 宝箱编号 */
    private int boxId;
    /** 上一个宝箱的Hash值 */
    private String lastHashValue;
    /** Hash值 */
    private String myHashValue;
    /** 神秘数字 */
    private int mysteriousNo;

    public TreasureBox(int boxId, String lastHashValue) {
        this.boxId = boxId;
        this.lastHashValue = lastHashValue;
    }

    /**
     * 计算宝箱的hash值
     * @return
     */
    public String calculateHashValue(int mysteriousNo) {
        String treasureBoxStr = this.toString();
        this.mysteriousNo = mysteriousNo;
        this.myHashValue = ShaUtils.getHashValueBySha256(treasureBoxStr);
        return this.myHashValue;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.boxId)
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
