package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuDemo extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu plikMenu;
    JMenu edytujMenu;
    JMenu pomocMenu;
    JMenuItem openMenu;
    JMenuItem saveMenu;
    JMenuItem exitMenu;
    ImageIcon openIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;

    MenuDemo() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(440,440);
    this.setLayout(new FlowLayout());

    openIcon = new ImageIcon("Avatar próbny.jpg");
    saveIcon = new ImageIcon("takicon.jpg");
    exitIcon =new ImageIcon("nieicon.png");

    menuBar = new JMenuBar(); // ustawiasz pasek menu

    plikMenu = new JMenu("Plik"); // tworzy oszczególne segmenty menu
    edytujMenu = new JMenu("Edytuj");
    pomocMenu = new JMenu("Pomoc");

    openMenu = new JMenuItem("Otwórz"); //  tworzy elementy dodawane do zakładek w menu
    saveMenu = new JMenuItem("Zachowaj");
    exitMenu = new JMenuItem("Wyjdź");

    openMenu.addActionListener(this);
    saveMenu.addActionListener(this);
    exitMenu.addActionListener(this);

    openMenu.setMnemonic(KeyEvent.VK_O); // tworzysz skróty klawiszowe do wykonania czynności, ale tutaj najpierw musisz otworzyć menu żeby zadziałały
    saveMenu.setMnemonic(KeyEvent.VK_Z);
    exitMenu.setMnemonic(KeyEvent.VK_W);

    plikMenu.setMnemonic(KeyEvent.VK_K); //dla tych skrótów musisz kliknąć ALT + "char" żeby zadziałały,
    edytujMenu.setMnemonic(KeyEvent.VK_E);
    pomocMenu.setMnemonic(KeyEvent.VK_C);

    openMenu.setIcon(openIcon);
    saveMenu.setIcon(saveIcon);
    exitMenu.setIcon(exitIcon);

    plikMenu.add(openMenu);
    plikMenu.add(saveMenu);
    plikMenu.add(exitMenu);

    menuBar.add(plikMenu);
    menuBar.add(edytujMenu);
    menuBar.add(pomocMenu);

    this.setJMenuBar(menuBar); // zamiast dodawać do frame to ustawiasz?

    this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==openMenu) {
        System.out.println("Otworzyłeś plik!!");
    }
    else if (e.getSource()==saveMenu) {
        System.out.println("Zachowałeś plik");
    }
    else if (e.getSource()==exitMenu) {
        System.out.println("Wyszedłeś :(");
        //this.dispose();
        System.exit(0);
    }
    else System.out.println("Error");
    }
}
