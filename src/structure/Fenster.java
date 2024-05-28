
package structure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster<listObjects> extends JFrame {

    private JFrame Hauptmenu;
    private JPanel Menu;
    private JPanel Spiel;
    private JPanel Spielregeln;
    private ListObjects panelDorf;


    private GamePresenter presenter;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenster window = new Fenster();
                    GamePresenter presenter = new GamePresenter(window);
                    window.setPresenter(presenter);
                    window.Hauptmenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public Fenster() {
        erstelle();
    }


    private void erstelle(){
        Hauptmenu = new JFrame();
        Hauptmenu.setBounds(100,100, 617, 300);
        Hauptmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Hauptmenu.setTitle("Hauptmenu");
        //Fenster für das Spiel wird erstellt



        JMenuBar Leiste = new JMenuBar();
        this.setJMenuBar(Leiste);
        //Navigationsleiste wird erstellt

        JMenu datei = new JMenu("Datei");
        JMenu optionen = new JMenu("Optionen");
        JMenu hilfe = new JMenu("Hilfe");
        //Hauptpunkte der Navigationsleiste werden erstellt

        Leiste.add(datei);
        Leiste.add(optionen);
        Leiste.add(hilfe);
        //Hauptpunkte werden der Navigationsleiste zugeordnet

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
                JPanel regeln = new JPanel();
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


        panelDorf = new ListObjects();
        panelDorf.setBackground(Color.magenta);
        Hauptmenu.add(panelDorf, BorderLayout.CENTER);
        Hauptmenu.add(Leiste, BorderLayout.NORTH);

    }

    public ListObjects getPanelDorf() {
        return panelDorf;
    }

    public void setPanelDorf(ListObjects panelDorf) {
        this.panelDorf = panelDorf;
    }

    public GamePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(GamePresenter presenter) {
        this.presenter = presenter;
    }



}





