
package structure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster<listObjects> extends JFrame {

    private JFrame Hauptmenu;
    private ListObjects Menu;
    private ListObjects Spiel;
    private ListObjects Spielregeln;
    private ListObjects panelDorf;
    private JMenuBar Leiste;



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


        Leiste = new JMenuBar();
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


        runG();

        JMenuItem starten = new JMenuItem("Spiel Starten");
        starten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hauptmenu.getContentPane().removeAll();
                Hauptmenu.revalidate();
                Hauptmenu.repaint();
                startGame();




            }

        });



        JMenuItem zurueck = new JMenuItem("Zurück zum Hauptmenu");
            zurueck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hauptmenu.getContentPane().removeAll();
                    Hauptmenu.revalidate();
                    Hauptmenu.repaint();
                    zurueckMenu();
                }
            });


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
                    Hauptmenu.getContentPane().removeAll();
                    Hauptmenu.revalidate();
                    Hauptmenu.repaint();
                    rules();

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


    public void runG(){
        panelDorf = new ListObjects();
        panelDorf.setBackground(Color.magenta);
        Hauptmenu.add(panelDorf, BorderLayout.CENTER);
        //Wertebereich wird dem Fenster hinzugefügt
        Hauptmenu.add(Leiste, BorderLayout.NORTH);
        //Navigationsleiste wird dem Fenster beigefügt
    }


    public void startGame(){
        Hauptmenu.setTitle("Spiel");
        Hauptmenu.add(Leiste, BorderLayout.NORTH);
        Spiel = new ListObjects();
        Hauptmenu.add(Spiel, BorderLayout.CENTER);

    }

    public void zurueckMenu(){
        Hauptmenu.setTitle("Hauptmenu");
        Hauptmenu.add(Leiste, BorderLayout.NORTH);
        Hauptmenu.add(panelDorf, BorderLayout.CENTER);
    }

    public void rules(){
        Hauptmenu.setTitle("Spielregeln");
        Hauptmenu.add(Leiste, BorderLayout.NORTH);
        Spielregeln = new ListObjects();
        Spielregeln.setBackground(Color.PINK);
        Hauptmenu.add(Spielregeln, BorderLayout.CENTER);


    }

    public ListObjects getMenu() {
        return Menu;
    }

    public void setMenu(ListObjects menu) {
        Menu = menu;
    }

    public ListObjects getSpiel() {
        return Spiel;
    }

    public void setSpiel(ListObjects spiel) {
        Spiel = spiel;
    }

    public ListObjects getSpielregeln() {
        return Spielregeln;
    }

    public void setSpielregeln(ListObjects spielregeln) {
        Spielregeln = spielregeln;
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





