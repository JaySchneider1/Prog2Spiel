
package structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class background extends JFrame {



    public background(){

        JPanel hauptLeiste = new JPanel();
        hauptLeiste.setPreferredSize(new Dimension(600, 400));


        new testHintergrund();
        menuWindowListener();
        createMenu();


        add(hauptLeiste);
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





