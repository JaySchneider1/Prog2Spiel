package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.DorfFactory.createDorfObject;

public class Dorf{

    private double width, height;

    private List<DorfObject> dorfObjects = new ArrayList<>();

    private Schwein schwein1;

    public Dorf(double width, double height){
        this.width = width;
        this.height = height;

        // Playerobject erzeugen und der Liste hinzufügen
        schwein1 = (Schwein) DorfFactory.createDorfObject("Schwein1", "Schwein1", 2, 2, this);
        dorfObjects.add(schwein1);


    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Schwein getSchwein1() {
        return schwein1;
    }

    public void addDorfObject(DorfObject dorfobject){
        dorfObjects.add(dorfobject);
    }
    public boolean removeDorfObject(String name){

        return true;
    }

    public List<ImageObject> getdorfObjects() {
        return Collections.unmodifiableList(dorfObjects);
    }
}
