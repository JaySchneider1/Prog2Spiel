package structure;

import java.awt.*;

public class PlayerObject extends DorfObject {

    private double distanceX;
    private double distaneY;

    private double speed;

    public PlayerObject(String name, double x, double y, double width, double height, Image image, Dorf dorf){
        super(name, x, y, width, height, image, dorf);

        this.speed = speed;
    }

    @Override
    public void move() {

        x += distanceX;
        y += distaneY;
    }

    public void ClearDistances(){
        distanceX = 0.0;
        distaneY = 0.0;
    }

    public void setDistanceY(int frametime){
        distaneY = frametime * speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }


}
