
package structure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenster window = new Fenster();
                    GamePresenter presenter = new GamePresenter(window);
                    window.setPresenter(presenter);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public Fenster() { erstelle(); }

    private void erstelle(){
    JPanel startseite = new JPanel();
        startseite.setPreferredSize(new Dimension(600, 400));


        menuWindowListener();
        createMenu();


        add(startseite);
        pack();

        setTitle("Startseite");
        setLocation(10, 10);
        setResizable(true);
        setVisible(true);

    }


    private void createMenu() {

        JMenuBar Leiste = new JMenuBar();
        this.setJMenuBar(Leiste);

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
                        JPanel game = new JPanel();
                        setTitle("Spiel");
                        setLocation(10, 10);
                        setResizable(true);
                        game.setVisible(true);
                    }
                });



                JMenuItem zurueck = new JMenuItem("Zurück zum Hauptmenu");
                zurueck.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame zurueckMenu = new JFrame();
                        zurueckMenu.setPreferredSize(new Dimension(600, 400));
                        setTitle("Hauptmenu");
                        setVisible(true);
                        setResizable(true);
                    }
                });




                JMenuItem beenden = new JMenuItem("Beenden");
                beenden.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                 });



                JMenuItem pause = new JMenuItem("Pause");
                JMenuItem fortsetzen = new JMenuItem("Fortsetzen");
                JMenuItem neustart = new JMenuItem("Neustart");


                JMenuItem regeln = new JMenuItem("Spielregeln");
                regeln.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame regeln = new JFrame();
                        regeln.setPreferredSize(new Dimension( 600, 400));
                        setTitle("Spielregeln");
                        setVisible(true);
                        setResizable(false);
                    }
                });




            datei.add(starten);
            datei.add(zurueck);
            datei.add(beenden);

            optionen.add(pause);
            optionen.add(fortsetzen);
            optionen.add(neustart);

            hilfe.add(regeln);




    }



    private void menuWindowListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

    });
    }




}





