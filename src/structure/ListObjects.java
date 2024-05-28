package structure;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListObjects extends JPanel {

    private List<ImageObject> dorfObjects = new ArrayList<ImageObject>();

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for (ImageObject dorfObject: dorfObjects){
            g.drawImage(dorfObject.getImage(), (int) dorfObject.getX(), (int) dorfObject.getY(), null);
        }
    }


    public List<ImageObject> getDorfObjects(){
        return dorfObjects;
    }

    public void setDorfObjects(List<ImageObject> dorfObjects){
         this.dorfObjects = dorfObjects;
    }

}

