package com.HighLand;

import javax.swing.*;

public class Animation extends JFrame {
    AnimationPanel panel;

    Animation() {
        panel = new AnimationPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
