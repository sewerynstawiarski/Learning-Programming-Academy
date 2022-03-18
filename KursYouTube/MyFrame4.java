package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame4 extends JFrame implements ActionListener {
    JRadioButton udonButton;
    JRadioButton gyudonButton;
    JRadioButton ramenButton;
    ImageIcon nieUdon;
    ImageIcon nieGyudon;
    ImageIcon nieRamen;

    MyFrame4 () {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        udonButton = new JRadioButton("Udon");
        gyudonButton = new JRadioButton("Gyudon");
        ramenButton = new JRadioButton("Ramen");

        nieGyudon = new ImageIcon("Avatar próbny.jpg");
        nieUdon = new ImageIcon("takicon.jpg");
        nieRamen = new ImageIcon("nieicon.png");

        udonButton.addActionListener(this);
        gyudonButton.addActionListener(this);
        ramenButton.addActionListener(this);

        udonButton.setIcon(nieUdon);
        gyudonButton.setIcon(nieGyudon);
        ramenButton.setIcon(nieRamen);

        ButtonGroup group = new ButtonGroup();
        group.add(udonButton);
        group.add(gyudonButton);
        group.add(ramenButton);

        this.add(udonButton);
        this.add(gyudonButton);
        this.add(ramenButton);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==udonButton) {
            System.out.println("Wcinasz udon!! Zazdroszczę!!");
        }
        else  if (e.getSource()==gyudonButton) {
            System.out.println("Wcinasz gyudon!! Zazdroszczę!!");
        }
        else if (e.getSource()==ramenButton) {
            System.out.println("Wcinasz ramen!! Mogło być lepiej...");
        }

    }
}
