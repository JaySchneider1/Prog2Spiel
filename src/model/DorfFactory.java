package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DorfFactory{

    public static DorfObject createDorfObject(String name, String type, double x, double y, Dorf dorf){

        DorfObject result = null;

        switch(type){
            case "Schwein1":
                Image imageSchwein1 = loadImage("src/bilder/Schwein1.png");
                if (imageSchwein1 != null){
                    result = new Schwein(name, x, y, imageSchwein1.getWidth(null), imageSchwein1.getHeight(null), imageSchwein1, dorf);
                }
        }
        return result;
    }

    private static Image loadImage(String path) {
        Image result = null;
        try {
            result = ImageIO.read(new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
