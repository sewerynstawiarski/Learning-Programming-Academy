package com.HighLand;

import javax.swing.*;
import java.awt.*;

public class Grafiki2D extends JFrame {
    PanelGrafiki2D panel;

    Grafiki2D() {
        panel = new PanelGrafiki2D();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //.setSize(440,440); // niepotrzebne jeśli dodasz panel i pack bo sama wokół panelu się stworzy
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

}
