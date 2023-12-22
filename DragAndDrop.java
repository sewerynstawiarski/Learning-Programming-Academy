package com.HighLand;

import javax.swing.*;

public class DragAndDrop extends JFrame {

    DragPanel dragPanel = new DragPanel();

    DragAndDrop () {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Drag and Drop demo ");
        this.setSize(500,500);
        this.add(dragPanel);
        this.setVisible(true);
    }
}
