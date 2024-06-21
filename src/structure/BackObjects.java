package structure;

import model.ImageObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BackObjects extends JPanel {
    private List<ImageObject> imageObjects2 = new ArrayList<>();


    public BackObjects() {
        //Hauptmenür per default schwarz
        this.setBackground(Color.BLACK);


    }

    @Override


    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        Dimension size = getSize();

        //Hauptmenü-Hintergund wird implementiert
        ImageIcon backgroundhome = new ImageIcon("src/bilder/backgroundhome.jpg");

        Image hintergrundhome = backgroundhome.getImage();


        g2d.drawImage(hintergrundhome, 0, 0, null);


        for (ImageObject obj : imageObjects2) {

            g.drawImage(obj.getImage(), (int) obj.getX(), (int) obj.getY(), null);

        }

    }

    public List<ImageObject> getImageObjects(Object dorfObjects) {
        return imageObjects2;
    }


    public void setImageObjects(List<ImageObject> imageObjects) {
        this.imageObjects2 = imageObjects;
    }

    public List<ImageObject> getImageObjects() {
        return imageObjects2;
    }

}
