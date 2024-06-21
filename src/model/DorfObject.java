package model;

import java.awt.*;

public abstract class DorfObject implements ImageObject {//implementziert Imageobject

    private String name;
    protected double x, y, width, height;
    private Image image;
    protected Dorf dorf;

    protected boolean dead;

    public DorfObject(String name, double x, double y, double width, double height, Image image, Dorf dorf) {
        super();
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.dorf = dorf;
        this.dead = false;
    }

    public void shot(int x, int y) {
        // Überprüfen, ob die Koordinaten (x, y) innerhalb des Objekts liegen
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            dead = true;//wenn ja, wird das schwein als erschossen markiert
        }
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public Image getImage() {
        return image;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void move() {
        // Bewegungscode hier
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract int getScoreValue();
}