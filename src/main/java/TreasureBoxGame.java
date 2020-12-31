import constant.CHECKMSG;
import exception.BoxNumIsOutOfBoundaryException;
import exception.ThisBoxCannotPlayException;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝箱游戏
 * @author humenglin
 */
public class TreasureBoxGame {
    // 游戏状态
    private boolean gameStatus = false;
    // 游戏的宝箱列表
    private List<TreasureBox> treasureBoxes = new ArrayList<TreasureBox>(CHECKMSG.BOX_MAX_NUMS);

    public TreasureBoxGame() {
        TreasureBox treasureBox = new TreasureBox(1, CHECKMSG.LAST_HASH_VALUE_OF_FIRST_BOX);
        this.treasureBoxes.add(treasureBox);
    }

    /**
     * 宝箱游戏玩法
     * @param boxId
     * @param mysteriousNo
     * @return
     */
    public boolean play(int boxId, int mysteriousNo) throws BoxNumIsOutOfBoundaryException, ThisBoxCannotPlayException {
        if (boxId > 10) {
            throw new BoxNumIsOutOfBoundaryException();
        }

        if (treasureBoxes.size() < boxId) {
            // 只有当上一个宝箱开启后才初始化下一个宝箱，因此当play的这个宝箱编号大于游戏中的宝箱个数时，说明此前有宝箱未开启
            throw new ThisBoxCannotPlayException();
        }

        TreasureBox nowTreasureBox = treasureBoxes.get(boxId - 1);
        boolean nowTreasureBoxStatus = nowTreasureBox.play(mysteriousNo);
        if (nowTreasureBoxStatus && boxId < CHECKMSG.BOX_MAX_NUMS) {
            TreasureBox nextTreasureBox = new TreasureBox(boxId + 1, nowTreasureBox.getMyHashValue());
            treasureBoxes.add(nextTreasureBox);
        }
        if (nowTreasureBoxStatus && boxId == CHECKMSG.BOX_MAX_NUMS) {
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
