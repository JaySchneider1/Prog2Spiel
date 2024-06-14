package structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class pigshot{

    private JFrame frame;
    private ListObjects listObjects;
    private BackObjects backObjects;
    private GamePresenter presenter;
    private JMenuBar Leiste;
    private JLabel scoreLeiste;
    private int score = 0; // Move score to class level

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pigshot window = new pigshot();
                    window.frame.pack();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pigshot(){
        initialize();
    }

    private void initialize(){
        //Fenster wird erstellt und angepasst
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hauptmenü");
        frame.setResizable(false);

        //Navigationsleiste wird erstellt
        Leiste = new JMenuBar();
        frame.setJMenuBar(Leiste);

        //Hauptbutton für Navigationsleiste werden erstellt
        JMenu datei = new JMenu("Datei");
        JMenu optionen = new JMenu("Optionen");
        JMenu hilfe = new JMenu("Hilfe");

        Leiste.add(datei);
        Leiste.add(optionen);
        Leiste.add(hilfe);

        JMenuItem starten = new JMenuItem("Spiel Starten");
        starten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eee) {

                //Seite vom Spiel hat einen angepassten anderen Hintergrund
                listObjects = new ListObjects();
                listObjects.setPreferredSize(new Dimension(1250,700));
                frame.add(listObjects, BorderLayout.CENTER);
                frame.revalidate();

                starten.setVisible(false);
                startGame();
            }

            private void startGame() {

                frame.setTitle("Spiel gestartet");
                System.out.println("Game started!");


                // Initialize and start the game presenter
                presenter = new GamePresenter(pigshot.this);
                presenter.onGameStart();




            }


        });

        JMenuItem beenden = new JMenuItem("Beenden");
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        datei.add(starten);
        datei.add(beenden);


        JMenuItem zurueck = new JMenuItem("Zurück zum Hauptmenu");
        JMenuItem pause = new JMenuItem("Pause");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pause) {

            }
        });
        JMenuItem fortsetzen = new JMenuItem("Fortsetzen");

        optionen.add(zurueck);
        optionen.add(pause);
        optionen.add(fortsetzen);

        JMenuItem rules = new JMenuItem("Spielregeln");
        hilfe.add(rules);

        //Hauptmenu Hintergrund
        backObjects = new BackObjects();
        backObjects.setPreferredSize(new Dimension(1250, 700));
        frame.add(backObjects, BorderLayout.CENTER);


        scoreLeiste = new JLabel("Score: " + score);
        frame.add(scoreLeiste, BorderLayout.SOUTH);

    }

    public void updateScore(int newScore) {
        score = newScore;
        scoreLeiste.setText("Score: " + score);
    }

    public ListObjects getListObjects() {
        return listObjects;
    }

    public void setListObjects(ListObjects listObjects) {
        this.listObjects = listObjects;
    }

    public GamePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(GamePresenter presenter) {
        this.presenter = presenter;
    }

    public JMenuBar getLeiste() {
        return Leiste;
    }

    public void setLeiste(JMenuBar leiste) {
        Leiste = leiste;
    }
}