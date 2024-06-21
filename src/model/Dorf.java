package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
//Haupt-model-klasse, hier läuft ein Großteil zusammen
public class Dorf {

    private double width, height;
    private List<DorfObject> dorfObjects = new ArrayList<>();
    private Schwein1 schwein1;
    private Schwein2 schwein2;
    private Schwein3 schwein3;
    private int score = 0;

    public Dorf(double width, double height) {
        this.width = width;
        this.height = height;

        // object erzeugen und der Liste hinzufügen
        schwein1 = (Schwein1) DorfFactory.createDorfObject("Schwein1", "Schwein1", 2, getY(Schwein1.HEIGHT), this);
        dorfObjects.add(schwein1);

        schwein2 = (Schwein2) DorfFactory.createDorfObject("Schwein2", "Schwein2", 200, getY(Schwein2.HEIGHT), this);
        dorfObjects.add(schwein2);

        schwein3 = (Schwein3) DorfFactory.createDorfObject("Schwein3", "Schwein3", 500, getY(Schwein3.HEIGHT), this);
        dorfObjects.add(schwein3);
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

    public Schwein1 getSchwein1() {
        return schwein1;
    }

    public void addDorfObject(DorfObject dorfobject) {
        dorfObjects.add(dorfobject);
    }

    public boolean removeDorfObject(String name) {
        return true;
    }

    public List<ImageObject> getdorfObjects() {
        return Collections.unmodifiableList(dorfObjects);
    }

    public Schwein2 getSchwein2() {
        return schwein2;
    }

    public void setSchwein2(Schwein2 schwein2) {
        this.schwein2 = schwein2;
    }

    public Schwein3 getSchwein3() {
        return schwein3;
    }

    public void setSchwein3(Schwein3 schwein3) {
        this.schwein3 = schwein3;
    }

    public boolean isObjectInDorf(double x, double y, double width, double height) {
        return x > 0 && x + width < this.width && y > 0 && y + height < this.height;
    }//prüfung ob das ganze object(höhe,breite) sich in der deklarierten Dorfgröße befindet

    public int getScore() {
        return score;
    }

    private void increaseScore(int value) {
        score += value;
    }//scorerechnung

    public void moveAll() {
        List<DorfObject> resurrectedObjects = new ArrayList<>();

        for (DorfObject dorfObject : dorfObjects) {
            dorfObject.move();

            if (dorfObject.dead) {//prüfung ob ein schwein tot ist
                // der scorer wird hiermit um die festgelegt anzahl an punkten für verschieden schweine erhöht
                increaseScore(dorfObject.getScoreValue());

                // Schwein wird an beliebiger stelle wiederbelebt
                dorfObject.setX(Math.random() * this.width);
                dorfObject.setY(getY(dorfObject.getHeight()));
                dorfObject.dead = false;
                resurrectedObjects.add(dorfObject);
            }
        }

        // entfernt nach wiederbelebung das tote schwein von der liste, somit ist es nichtz mehr als dead geflaggt
        dorfObjects.removeIf(o -> o.dead);


        dorfObjects.addAll(resurrectedObjects);
    }

    public void shot(int x, int y) {
        for (DorfObject dorfObject : dorfObjects) {
            dorfObject.shot(x, y);
        }
    }

    private double getY(double objectHeight) {
        return Math.random() * (this.height - objectHeight);
    }
}