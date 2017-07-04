package ir.aut.tools;

import java.awt.*;

/**
 * Created by Milad on 6/15/2017.
 */
public class Rotator {

    public static Rectangle rotate90(Rectangle r) {
//        int x = r.x , y = r.y , width = r.width , height = r.height;
//        int x2 = x + width, y2 = y + height;
//        int resX = -y, resY = x, resX1 = -y2, resY1 = x2;
//        Rectangle ret = new Rectangle(Math.min(resX, resX1), Math.min(resY, resY1), Math.abs(resX - resX1), Math.abs(resY - resY1));
//        return ret;
        int tmp = r.width;
        r.width = r.height;
        r.height = tmp;
        return r;
    }
}