package structure;

import java.awt.*;

public abstract class DorfObject implements ImageObject{

    private String name;

    protected double x;
    protected double y;

    protected double width;
    protected double height;

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
    }



    public String getName() {
        return name;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean intersect(DorfObject dorfObject) {

        return !(this.x + this.width < dorfObject.x || this.y + this.height < dorfObject.y || dorfObject.x + dorfObject.width < this.x || dorfObject.y + dorfObject.height < this.y );

    }

    @Override
    public Image getImage() {
        return image;
    }


    public abstract void move();

}

