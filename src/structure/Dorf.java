package structure;

import kotlin.jvm.internal.SpreadBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dorf {

    private double  width;
    private double height;

    private List<DorfObject> dorfObjects = new ArrayList<DorfObject>();

    private PlayerObject player;

    public Dorf(double width, double height){

        this.width = width;
        this.height = height;


        player = (PlayerObject) DorfFactory.createDorfObject("Player1", "Player", width/2, height/2, this);
        dorfObjects.add(player);

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

    public List<ImageObject> getDorfObjects(){
        return Collections.unmodifiableList(dorfObjects);
    }

    public void Add(DorfObject dorfObject){
        dorfObjects.add(dorfObject);
    }

    public boolean Remove(String name){
        return true;
    }

    public PlayerObject getPlayer(){
        return player;
    }

    public void moveAll(){
        //Methode Objekte verschwinden lassen
    }

    public void generateSchwein() {
        double x = Math.random() * width;
        double y = Math.random() * height;

        DorfObject dorfObject = DorfFactory.createDorfObject("Schwein", "Schwein", x, y, this);

        if (dorfObject != null) {
            this.Add(dorfObject);
        }

    }

    public boolean isObjectInDorf(double x, double y, double width, double height){
        if(x > 0 && x + width < this.width && y > 0 && y + height < this.height)
            return true;
        else
            return false;
    }


}

