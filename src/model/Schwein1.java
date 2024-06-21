package model;

import java.awt.*;

public class Schwein1 extends DorfObject {
//gibt dem schwein größe, geschwindigkeit, richtung

    public static final double HEIGHT = 48;
    private int direction = 1;

    public static final double MOVE_DISTANCE = 0.1;


    public Schwein1(String name, double x, double y, double width, double height, Image image, Dorf dorf) {
        super(name, x, y, width, height, image, dorf);

    }

    @Override
    public void move() {

        double xnew = x + direction * MOVE_DISTANCE;

        if (!dorf.isObjectInDorf(xnew, y, width, height)) {
            direction *= -1;
            xnew = x + direction * MOVE_DISTANCE;
        }

        x = xnew;

        // System.out.println("moved");//überprüfung ob sich das schwein bewegt hat


    }

    public int getScoreValue() {
        return 10; // Score value for Schwein1
    }

}