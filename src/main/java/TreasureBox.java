/**
 * 宝箱
 * @author humenglin
 */
public class TreasureBox {
    public static final String PREFIX_RIGHT_HASH_VALUE = "00000";
    /** 宝箱编号 */
    private int boxId;
    /** 上一个宝箱的Hash值 */
    private String lastHashValue;
    /** Hash值 */
    private String myHashValue;
    /** 神秘数字 */
    private int mysteriousNo;
    /** 宝箱是否开启 */
    private boolean boxOpenFlag;

    public TreasureBox(int boxId, String lastHashValue) {
        this.boxId = boxId;
        this.lastHashValue = lastHashValue;
        this.boxOpenFlag = false;
    }

    public String getMyHashValue() {
        return myHashValue;
    }

    /**
     * 计算宝箱的hash值
     * @return
     */
    public String calculateHashValue(int mysteriousNo) {
        this.mysteriousNo = mysteriousNo;
        String treasureBoxStr = this.toString();
        return ShaUtils.getHashValueBySha256(treasureBoxStr);
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
     * @param mysteriousNo
     */
    public boolean play(int mysteriousNo) {
        this.myHashValue = calculateHashValue(mysteriousNo);
        this.boxOpenFlag = PREFIX_RIGHT_HASH_VALUE.equals(this.myHashValue.substring(0, 5));
        return this.boxOpenFlag;
    }

    /**
     * 查找真实的神秘数字
     * @return
     */
    public int findRightMysteriousNo() {
        int initMysteriousNo = 1;
        while (!boxOpenFlag) {
            boxOpenFlag = play(initMysteriousNo);
            if (!boxOpenFlag) {
                initMysteriousNo++;
            }
        }
        return initMysteriousNo;
    }
}
