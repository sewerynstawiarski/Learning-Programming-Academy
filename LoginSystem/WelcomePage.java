package com.HighLand;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel welcomePage =new JLabel();

    WelcomePage(String userID) {

        welcomePage.setFont(new Font("MV Boli" ,Font.ITALIC,18));
        welcomePage.setForeground(Color.cyan);
        welcomePage.setText("Witamy w Nibylandi!!<3 "+userID);
        welcomePage.setBounds(20,20,400,400);


        frame.add(welcomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
