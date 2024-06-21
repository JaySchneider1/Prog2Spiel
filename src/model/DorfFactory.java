package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DorfFactory {

    //hier bekommen die schweine ein "Gesicht" zugeteilt und können nun theoretisch auf den Hintergrund gemalt werden
    public static DorfObject createDorfObject(String name, String type, double x, double y, Dorf dorf) {

        DorfObject result = null;


        switch (type) {

            case "Schwein3":

                result = createSchwein("Schwein3", name, x, y, dorf, "src/bilder/Schwein3.png");

                break;

            case "Schwein2":

                result = createSchwein("Schwein2", name, x, y, dorf, "src/bilder/Schwein2.png");

                break;

            case "Schwein1":

                result = createSchwein("Schwein1", name, x, y, dorf, "src/bilder/Schwein1.png");

                break;

            default:

                throw new IllegalArgumentException("Unknown type: " + type);

        }


        return result;

    }


    private static DorfObject createSchwein(String type, String name, double x, double y, Dorf dorf, String imagePath) {

        Image image = loadImage(imagePath);

        if (image == null) {

            throw new RuntimeException("Failed to load image: " + imagePath);

        }

        int width = image.getWidth(null);

        int height = image.getHeight(null);


        switch (type) {

            case "Schwein3":

                return new Schwein3(name, x, y, width, height, image, dorf);

            case "Schwein2":

                return new Schwein2(name, x, y, width, height, image, dorf);

            case "Schwein1":

                return new Schwein1(name, x, y, width, height, image, dorf);

            default:

                throw new AssertionError("Unknown type: " + type);

        }

    }


    private static Image loadImage(String path) {

        try {

            return ImageIO.read(new File(path));

        } catch (IOException e) {

            throw new RuntimeException("Failed to load image: " + path, e);//methode um zu überprüfen ob die bilder laden über due console

        }

    }

}