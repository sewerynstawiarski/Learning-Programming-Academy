package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel {

    ImageIcon pikachu = new ImageIcon("iconpikachu.jpg");
    final int width = pikachu.getIconWidth();
    final int height = pikachu.getIconHeight();
    Point imageCorner;
    Point previousPoint;

    DragPanel () {
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pikachu.paintIcon(this,g, (int) imageCorner.getX(), (int) imageCorner.getY());

    }
    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            previousPoint = e.getPoint();
        }

    }
    private class DragListener extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) { // mousedragged to metoda z klasy MouseMotionAdapter, a nie nazwa wymyślona! Wyżej też tak jest!
        Point currentPoint = e.getPoint();
        imageCorner.translate(
                (int) (currentPoint.getX() - previousPoint.getX()),
                (int) (currentPoint.getY() - previousPoint.getY())
        );
        previousPoint = currentPoint;
        repaint();
    }
    }
}
