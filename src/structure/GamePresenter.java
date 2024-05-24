
package structure;


import java.util.Timer;

public class GamePresenter {

    private Fenster fenster;
    private Dorf dorf;
    private ListObjects listObjects;

    private Timer timer;

    private int frameTimer = 10;
    private int counter = 0;

    //private Set<Integer> Mouse = new HashSet <~>();


    public GamePresenter(Fenster fenster){
        super();
        this.fenster = fenster;


    }

}


