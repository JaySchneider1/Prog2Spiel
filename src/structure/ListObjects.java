package structure;


import model.ImageObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ListObjects extends JPanel {

    private List<ImageObject> imageObjects = new ArrayList<>();


    public ListObjects() {
        this.setBackground(Color.BLACK);
    }

    @Override

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();


        ImageIcon background = new ImageIcon("src/bilder/background.png");

        Image hintergrund = background.getImage();

        g2d.drawImage(hintergrund, 0, 0, null);


        for (ImageObject obj : imageObjects) {

            g.drawImage(obj.getImage(), (int) obj.getX(), (int) obj.getY(), null);

        }

    }

    public List<ImageObject> getImageObjects(Object dorfObjects) {
        return imageObjects;
    }

    public void setImageObjects(List<ImageObject> imageObjects) {
        this.imageObjects = imageObjects;
    }
}

