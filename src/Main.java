import ir.aut.tools.Rotator;
import ir.aut.view.gameview.GameChatPanel;
import ir.aut.view.gameview.GameFrame;
import ir.aut.view.gameview.MasterGameFrame;
import ir.aut.view.gameview.SeaCellCordinate;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Milad on 6/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        MasterGameFrame field = new MasterGameFrame(50, 10, 1000, 700);
        Scanner inp = new Scanner(System.in);
        while (true){
            int x , y;
            x = inp.nextInt();
            y = inp.nextInt();
            field.gameFrame.mySea.hit(new SeaCellCordinate(x , y));
            field.gameFrame.showEnemySea();
        }

//        while (true){
//            int x , y , x2 , y2;
//            x = inp.nextInt();
//            y = inp.nextInt();
//            x2 = inp.nextInt();
//            y2 = inp.nextInt();
//            System.out.println(Rotator.rotate90(x , y , x2 , y2));
//        }
    }
}
