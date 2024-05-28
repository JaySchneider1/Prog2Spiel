
package structure;


import javax.swing.*;

public class GamePresenter {

    private Fenster fenster;
    private Dorf dorf;
    private ListObjects listObjects;

    private Timer timer;

    private int frameTime = 10;
    private int counter = 0;

    //private Set<Integer> Mouse = new HashSet <~>();


    public GamePresenter(Fenster fenster) {
        super();
        this.fenster = fenster;
        listObjects = fenster.getPanelDorf();




        timer = new Timer(frameTime, e -> {
            updateplayer();
            if (counter == 0) {
                dorf.generateSchwein();
            }
            counter++;
            if (counter > 10) {
                counter = 0;
            }

            dorf.moveAll();

            listObjects.setDorfObjects(dorf.getDorfObjects());
            listObjects.repaint();


        });

        timer.start();

    }


    private void updateplayer(){
        dorf.getPlayer().ClearDistances();
    }

    public void addDorfObject(){

        DorfObject dorfObject = DorfFactory.createDorfObject("test1", "type", 0.5, 0.8, dorf);

        if (dorfObject != null){
            dorf.Add(dorfObject);
        }
    }

    //MouseListener !!

}