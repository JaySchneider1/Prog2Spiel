package structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pigshot {

    private JFrame frame;
    private ListObjects listObjects;
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

    public pigshot() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hauptmenü");
        frame.setResizable(false);

        Leiste = new JMenuBar();
        frame.setJMenuBar(Leiste);

        JMenu datei = new JMenu("Datei");
        JMenu optionen = new JMenu("Optionen");
        JMenu hilfe = new JMenu("Hilfe");

        Leiste.add(datei);
        Leiste.add(optionen);
        Leiste.add(hilfe);

        JMenuItem starten = new JMenuItem("Spiel Starten");
        starten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        listObjects = new ListObjects();
        listObjects.setPreferredSize(new Dimension(1250, 700));
        frame.add(listObjects, BorderLayout.CENTER);

        listObjects.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
//                if (presenter != null) {
//                    presenter.onMouseClick(e.getX(), e.getY());
//                }
//            }
        });

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