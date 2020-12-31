import java.util.ArrayList;
import java.util.List;

/**
 * 宝箱游戏
 * @author humenglin
 */
public class TreasureBoxGame {
    private boolean gameStatus = false;
    private List<TreasureBox> treasureBoxes = new ArrayList<TreasureBox>(10);

    public TreasureBoxGame() {
        TreasureBox treasureBox = new TreasureBox(1, "0");
        this.treasureBoxes.add(treasureBox);
    }

    /**
     * 宝箱游戏玩法
     * @param boxId
     * @param mysteriousNo
     * @return
     */
    public boolean play(int boxId, int mysteriousNo) {
        TreasureBox nowTreasureBox = treasureBoxes.get(boxId - 1);
        boolean nowTreasureBoxStatus = nowTreasureBox.play(mysteriousNo);
        if (nowTreasureBoxStatus && boxId < 10) {
            TreasureBox nextTreasureBox = new TreasureBox(boxId + 1, nowTreasureBox.getMyHashValue());
            treasureBoxes.add(nextTreasureBox);
        }
        if (nowTreasureBoxStatus && boxId == 10) {
            gameStatus = true;
        }
        return nowTreasureBoxStatus;
    }


    public boolean getFinalStatus() {
        return this.gameStatus;
    }
}
