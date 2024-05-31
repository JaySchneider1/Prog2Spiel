package structure;

import model.Dorf;
import model.ImageObject;

import java.util.List;

public class GamePresenter{

    private pigshot window;
    private ListObjects listObjects;
    private Dorf dorf;

    public GamePresenter(pigshot window) {
        this.window = window;
        listObjects = window.getListObjects();

        dorf = new Dorf(100,100);

        List<ImageObject> imageObjects = dorf.getdorfObjects();

        listObjects.setImageObjects(dorf.getdorfObjects());

        listObjects.repaint();
    }

    public void onGameStart() {

    }
}