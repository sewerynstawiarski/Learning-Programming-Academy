package com.HighLand;

import javax.swing.*;

public class NaginiFrame extends JFrame {

    NaginiFrame() {
        this.add(new NaginiPanel());
        this.setTitle("Nagini&Mugole");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);


    }
}
