package structure;

import model.Dorf;
import model.ImageObject;

import javax.swing.*;
import java.util.List;


public class GamePresenter{

    private pigshot window;
    private ListObjects listObjects;
    private Dorf dorf;
    private Timer timer;
    private int frameTime = 10;

    private int counter = 0;


//methode shot ergänzen und weiterreichen

    public GamePresenter(pigshot window) {
        this.window = window;
        listObjects = window.getListObjects();

        dorf = new Dorf(1245, 700);

        List<ImageObject> imageObjects = dorf.getdorfObjects();

        listObjects.setImageObjects(dorf.getdorfObjects());

        listObjects.repaint();

        timer = new Timer(frameTime, e -> {

            // updateSchwein();

            dorf.moveAll();

            listObjects.setImageObjects(listObjects.getImageObjects());
            listObjects.repaint();

        });
        timer.start();

    }


    public void onGameStart() {
//testmethode für eine andere Idee
    }}
