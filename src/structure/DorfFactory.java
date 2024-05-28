package structure;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DorfFactory {

    public static DorfObject createDorfObject(String name, String type, double x, double y, Dorf dorf){
        DorfObject result = null;

        switch(type){
            case "Schwein1":
                Image image = loadImage("img/Schwein1.png");
                if (image != null){
                    result = new Schwein(name, x, y, image.getWidth(null), image.getHeight(null), image, dorf);
                }
                break;
            case "Schwein2":
                Image image1 = loadImage("img/Schwein2.png");
                if (image1 != null){
                    result = new Schwein(name, x, y, image1.getWidth(null), image1.getHeight(null), image1, dorf);
                }
                break;
            case "Schwein3":
                Image image2 = loadImage("img/Schwein3.png");
                if (image2 != null){
                    result = new Schwein(name, x, y, image2.getWidth(null), image2.getHeight(null), image2, dorf);
                }
                break;
        }
        return result;
    }


    private static Image loadImage(String path){

        Image result = null;
        try{
            result = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
