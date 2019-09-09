package ir.aut.view.gameview.sea;

/**
 * Created by Milad on 6/15/2017.
 */
public class MasterSeaPanel {
    public SeaPanel seaPanel;
    boolean enemy;

    public MasterSeaPanel(int xCor, int yCor, int xSize, int ySize, boolean enemy) {
        if (enemy)
            seaPanel = new EnemySeaPanel(xCor, yCor, xSize, ySize);
        else
            seaPanel = new MySeaPanel(xCor, yCor, xSize, ySize);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                SeaCellCordinate tmp = new SeaCellCordinate(i, j);
                if (seaPanel.total.get(tmp) != null) {
                    seaPanel.total.get(tmp).master = seaPanel;
                }
            }
        }
    }
}
