package ir.aut.view.gameview.sea;

/**
 * Created by Milad on 6/14/2017.
 */
public class SeaCellCordinate {
    public int xCor, yCor;

    public SeaCellCordinate(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
    }

    public String toString() {
        return xCor + " " + yCor;
    }

    public boolean equals(Object obj) {

        SeaCellCordinate x = (SeaCellCordinate) obj;

        if (x.xCor == this.xCor && x.yCor == this.yCor)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return xCor * 100 + yCor;
    }
}
