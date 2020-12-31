import exception.BoxNumIsOutOfBoundaryException;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝箱游戏
 * @author humenglin
 */
public class TreasureBoxGame {
    // 宝箱个数
    public static final int BOX_MAX_NUMS = 10;
    // 第一个宝箱的上一个hash值
    public static final String LAST_HASH_VALUE_OF_FIRST_BOX = "0";

    // 游戏状态
    private boolean gameStatus = false;
    // 游戏的宝箱列表
    private List<TreasureBox> treasureBoxes = new ArrayList<TreasureBox>(BOX_MAX_NUMS);

    public TreasureBoxGame() {
        TreasureBox treasureBox = new TreasureBox(1, LAST_HASH_VALUE_OF_FIRST_BOX);
        this.treasureBoxes.add(treasureBox);
    }

    /**
     * 宝箱游戏玩法
     * @param boxId
     * @param mysteriousNo
     * @return
     */
    public boolean play(int boxId, int mysteriousNo) throws BoxNumIsOutOfBoundaryException {
        if (boxId > 10) {
            throw new BoxNumIsOutOfBoundaryException();
        }

        TreasureBox nowTreasureBox = treasureBoxes.get(boxId - 1);
        boolean nowTreasureBoxStatus = nowTreasureBox.play(mysteriousNo);
        if (nowTreasureBoxStatus && boxId < BOX_MAX_NUMS) {
            TreasureBox nextTreasureBox = new TreasureBox(boxId + 1, nowTreasureBox.getMyHashValue());
            treasureBoxes.add(nextTreasureBox);
        }
        if (nowTreasureBoxStatus && boxId == BOX_MAX_NUMS) {
            gameStatus = true;
        }
        return nowTreasureBoxStatus;
    }

    /**
     * 获取游戏最终的状态
     * @return
     */
    public boolean getFinalStatus() {
        return this.gameStatus;
    }
}
