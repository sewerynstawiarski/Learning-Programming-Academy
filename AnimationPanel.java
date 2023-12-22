package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 440;
    final int PANEL_HEIGHT = 440;
    Image enemy;
    Image background;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    AnimationPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.YELLOW);
        enemy = new ImageIcon("Avatar próbny.jpg").getImage();
        background = new ImageIcon("takicon.jpg").getImage();
        timer = new Timer(10,this); // wykona akcję co ustawione milisekundy
        timer.start();
    }
    public void paint(Graphics g) {
        super.paint(g); // maluje tło, wcześniej zadeklarowałeś kolor
        Graphics2D g2D = (Graphics2D) g; // castujesz jako grafike 2D bo to daje więcej możliwości
        g2D.drawImage(background,0,0,null);
        g2D.drawImage(enemy,x,y,null); // rysujesz na panelu obraz wcześniej zadelarowany  wmiejsc x i y wcześniej podałeś.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {  // ustawiasz warunki kiedy ma zmienić znak xVelocity, kiedy x większy od szerokości minus szerokość obrazka
            // albo kiedy x jest mniejszy od zera, bo mierzy od lewego górnego rogu pozycję, czli musi dojechać do zera i zmienić na plus (2*-)
            xVelocity = xVelocity*(-1);
        }
        x = x + xVelocity;

        if (y>=PANEL_HEIGHT-enemy.getHeight(null) || y<0) { //ustawiasz to co wyżej, ale dla osi y
            yVelocity = yVelocity*(-1);
        }
        y = y + yVelocity;
        repaint(); // przywołuje metodę paint by od nowa namalowała obraz z nowymi współrzędnymi,
        // pain nie powinien być wzbywany bezpośrednio dlatego w ten sposób

    }
}
