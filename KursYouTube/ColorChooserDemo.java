package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserDemo extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    ColorChooserDemo() {
        button = new JButton("CLick here to change color");
        button.addActionListener(this);
        button.setFocusable(false);

        label = new JLabel("Some kind of text");
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setFont(new Font("MV Boli",Font.BOLD,20));

        this.add(button);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }
       @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null,"Pick a color",Color.BLUE);
            //zapisujesz wybór użytkownika w forme String color tutaj
            label.setForeground(color); //ustawiasz by ten wybór był kolorem tekstu w label
            //label.setBackground(color);

        }
    }
}
