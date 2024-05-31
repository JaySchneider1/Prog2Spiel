package structure;

import model.Dorf;
public class GamePresenter{

    private pigshot window;
    private ListObjects listObjects;
    private Dorf dorf;

    public GamePresenter(pigshot window) {
        this.window = window;
        listObjects = window.getListObjects();
    }

    public void onGameStart() {
    }
}