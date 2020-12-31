/**
 * 宝箱
 * @author humenglin
 */
public class TreasureBox {
    // 正确hash值的前缀
    public static final String PREFIX_RIGHT_HASH_VALUE = "00000";
    // 正确hash值的前缀位数
    public static final int PREFIX_NUM_OF_RIGHT_HASH_VALUE = 5;

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

    /**
     * 获取宝箱的hash值
     * @return
     */
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

    /**
     * 按照hash值计算的字符串，重写宝箱的toString方法
     * @return
     */
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
        this.boxOpenFlag = PREFIX_RIGHT_HASH_VALUE.equals(this.myHashValue.substring(0, PREFIX_NUM_OF_RIGHT_HASH_VALUE));
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
