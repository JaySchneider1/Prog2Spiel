package structure;

import kotlin.jvm.internal.SpreadBuilder;
import model.Dorf;
import model.DorfObject;
import model.ImageObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GamePresenter{

    private pigshot window;
    private ListObjects listObjects;
    private Dorf dorf; // Deklaration der dorf-Variable
    public Timer timer;
    private int frameTime = 10;



    public GamePresenter(pigshot window) {

        this.window = window;
        listObjects = window.getListObjects();

        dorf = new Dorf(1250, 700);



        List<ImageObject> imageObjects = dorf.getdorfObjects();

        listObjects.setImageObjects(dorf.getdorfObjects());

        listObjects.repaint();

        listObjects.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                dorf.shot(x, y);
                listObjects.repaint();
            }
        });

        timer = new Timer(frameTime, e -> {
            dorf.moveAll();
            listObjects.setImageObjects(listObjects.getImageObjects());
            listObjects.repaint();
            window.updateScore(dorf.getScore()); // Update the score in the window
        });
        timer.start();


    }




    public void onGameStart() {
        // Game start logic
    }

    public void update() {
        dorf.moveAll();
        window.updateScore(dorf.getScore());
    }
}