package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame3 extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon takicon;
    ImageIcon nieicon;

    MyFrame3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        takicon = new ImageIcon("takicon.jpg");
        nieicon = new ImageIcon("nieicon.png");

        button = new JButton();
        button.setText("Zaiste");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("Kochasz ciasto tak jak ja?");
        checkBox.setFont(new Font("Consolas", Font.BOLD,15));
        checkBox.setFocusable(false);
        checkBox.setIcon(nieicon);
        checkBox.setSelectedIcon(takicon);


        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            System.out.println(checkBox.isSelected()); // funckja w nawiasie oddaje true albo false czy zostało zaznaczone checkbox/można też przypisać do variable

        }

    }
}
