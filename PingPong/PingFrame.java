package com.HighLand;

import javax.swing.*;
import java.awt.*;

public class PingFrame extends JFrame {
    PingPanel panel;

    PingFrame() {
    panel = new PingPanel();
    this.setTitle("Ping&Pong");
    this.add(panel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBackground(Color.black);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    }
}
