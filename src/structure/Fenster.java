
package structure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster<listObjects> extends JFrame {

    private JFrame Hauptmenu;
    private ListObjects Menu;
    private ListObjects Spiel;
    private ListObjects Spielregeln;
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
                Spiel = new ListObjects();
                Spiel.setBackground(Color.magenta);

            }
        });

        JMenuItem zurueck = new JMenuItem("Zurück zum Hauptmenu");
            Menu = new ListObjects();
            Menu.setBackground(Color.CYAN);


        JMenuItem beenden = new JMenuItem("Beenden");
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Fenster wird geschlossen



        JMenuItem pause = new JMenuItem("Pause");
        JMenuItem fortsetzen = new JMenuItem("Fortsetzen");
        JMenuItem neustart = new JMenuItem("Neustart");
        //Unterpunkte für die Hauptpunkte der Navigationsleiste


        JMenuItem regeln = new JMenuItem("Spielregeln");
            regeln.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   Spielregeln = new ListObjects();
                   Spielregeln.setBackground(Color.PINK);
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
        Hauptmenu.add(panelDorf, BorderLayout.CENTER);
        //Wertebereich wird dem Fenster hinzugefügt
        Hauptmenu.add(Leiste, BorderLayout.NORTH);
        //Navigationsleiste wird dem Fenster beigefügt

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





