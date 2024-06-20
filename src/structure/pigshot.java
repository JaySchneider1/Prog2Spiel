package structure;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class pigshot{

    public JFrame frame;
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


        //Hauptmenu Hintergrund
        backObjects = new BackObjects();
        backObjects.setPreferredSize(new Dimension(1250, 700));
        frame.add(backObjects, BorderLayout.CENTER);


        //Navigationsleiste wird erstellt
        Leiste = new JMenuBar();
        frame.setJMenuBar(Leiste);


        //Hauptbutton für Navigationsleiste werden erstellt
        JMenu datei = new JMenu("Datei");
        JMenu hilfe = new JMenu("Hilfe");
        Leiste.add(datei);
        Leiste.add(hilfe);


        //Spiel Starten in der Menuleiste bekommt die Funktion, dass das Spiel gestartet wird
        //Frame bekommt einen anderen Hintergrund
        JMenuItem starten = new JMenuItem("Spiel Starten");
        starten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent gamestart) {
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

                //Ein neues Label wird erstellt, wo der Score angezeigt wird
                scoreLeiste = new JLabel("Score: " + score);
                scoreLeiste.setOpaque(true);
                frame.add(scoreLeiste, BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();

                // Initialize and start the game presenter
                presenter = new GamePresenter(pigshot.this);
                presenter.onGameStart();

            }
        });


        //Beenden in der Menuleiste bekommt die Funktion das Spiel zu quitten
        JMenuItem beenden = new JMenuItem("Beenden");
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent quitgame) {
                System.exit(0);
            }
        });
        //der Hauptbutton Datei bekommt die Unterpunkte Spiel starten und Beenden zugeordnet
        datei.add(starten);
        datei.add(beenden);


        //Spielregeln werden erstellt und Hilfe bekommt den Unterpunkt Spielregeln zugeordnet
        //Spielregeln bekommt die Funktion eine Meldung mit den Regeln anzuzeigen
        JMenuItem rules = new JMenuItem("Spielregeln");
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent rulesgame) {
                JOptionPane.showMessageDialog(frame, "Willkommen bei Pigshot! Das Spiel Pigshot umfasst die" +
                        " wichtige Aufgabe, dass Dorf vor der Invasion der Schweine zu retten und die Bewohner zu " +
                        "schützen. Aber sei gewarnt, die Schweine spüren die Gefahr und werden immer schneller. " +
                        "Also sei schnell und versuche so viele Schweine, wie möglich abzuschießen!");
                frame.revalidate();
                frame.repaint();
            }
        });
        hilfe.add(rules);


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