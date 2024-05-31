package structure;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListObjects extends JPanel {

    private List<ImageObject> dorfObjects = new ArrayList<ImageObject>();

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();


        for (ImageObject dorfObject: dorfObjects){
            g.drawImage(dorfObject.getImage(), (int) dorfObject.getX(), (int) dorfObject.getY(), null);
        }

        ImageIcon background = new ImageIcon("src/bilder/Background.jpeg");
        Image hintergrund = background.getImage();
        g2d.drawImage(hintergrund, 0,0, null);

    }


    public List<ImageObject> getDorfObjects(){
        return dorfObjects;
    }

    public void setDorfObjects(List<ImageObject> dorfObjects){
         this.dorfObjects = dorfObjects;
    }

}

