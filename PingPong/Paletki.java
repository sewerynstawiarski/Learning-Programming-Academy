package com.HighLand;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Paletki extends Rectangle {
    int id;
    int yVelocity;
    int speed = 10;

    Paletki(int x, int y, int PALETKI_WIDTH, int PALETKI_HEIGHT, int id) {
    super(x,y, PALETKI_WIDTH, PALETKI_HEIGHT);
    this.id=id;
    }
    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void move() {
        y = y+yVelocity;
    }
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }
    public void draw(Graphics g) {
    if (id==1) {
        g.setColor(Color.BLUE);
    }
    else   {
        g.setColor(Color.RED);
    }
    g.fillRect(x,y,width,height);
    }
}
