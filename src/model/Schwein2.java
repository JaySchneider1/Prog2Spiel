package model;

import java.awt.*;

public class Schwein2 extends DorfObject{

    public static final double HEIGHT = 40;
    private int direction = 1 ;
    public static final double MOVE_DISTANCE = 0.25;

    public Schwein2(String name, double x, double y, double width, double height, Image image, Dorf dorf) {
        super(name, x, y, width, height, image, dorf);
    }
    @Override
    public void move() {

        double xnew = x + direction * MOVE_DISTANCE;

        if(!dorf.isObjectInDorf(xnew, y, width, height)) {
            direction *= -1;
            xnew = x + direction*MOVE_DISTANCE;
        }

        x = xnew;

     //   System.out.println("moved");

    }

    public int getScoreValue() {
        return 20; // Score value for Schwein2
    }
}
