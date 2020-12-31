import java.util.ArrayList;
import java.util.List;

/**
 * 宝箱游戏
 * @author humenglin
 */
public class TreasureBoxGame {
    private List<TreasureBox> treasureBoxes = new ArrayList<TreasureBox>(10);

    public TreasureBoxGame() {
        TreasureBox treasureBox = new TreasureBox(1, "0");
        this.treasureBoxes.add(treasureBox);
    }

    public boolean play(int boxId, int mysteriousNo) {
        TreasureBox nowTreasureBox = treasureBoxes.get(boxId - 1);
        return nowTreasureBox.play(mysteriousNo);
    }
}
