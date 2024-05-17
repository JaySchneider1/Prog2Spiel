package structure;

import javax.swing.*;
import java.awt.*;

public class testHintergrund extends JPanel {
    private Image HintergrundBild;

    private final String[] backgroundImage = new String [] {"Background.jpeg"};


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(HintergrundBild,0,0, this);
    }
}
