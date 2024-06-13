
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


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pigshot window = new pigshot();
                    GamePresenter presenter = new GamePresenter(window);
                    window.setPresenter(presenter);

                    window.frame.pack();

                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the application.
     */
    public pigshot() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        int score = 0;

        frame = new JFrame();

        //frame.setBounds(100, 100, 1245, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hauptmenü");
        frame.setResizable(false);


        Leiste = new JMenuBar();
        frame.setJMenuBar(Leiste);
        //Navigationsleiste wird erstellt

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

                getPresenter().onGameStart();
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

        listObjects.setPreferredSize(new Dimension(1250,700));
        frame.add(listObjects, BorderLayout.CENTER);

        listObjects.addMouseListener(new MouseAdapter() {

            @Override

            public void mouseClicked(MouseEvent e) {

                System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");

            }
        });

        scoreLeiste = new JLabel("Score: " + score);
        frame.add(scoreLeiste, BorderLayout.SOUTH);
    ;}


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

