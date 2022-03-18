package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyDemo extends JFrame implements KeyListener {
        JLabel label;
        ImageIcon icon;
    KeyDemo () {



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(440,440);
        this.addKeyListener(this);
        this.setLayout(null);

        icon = new ImageIcon("Avatar próbny.jpg");

        label = new JLabel();
        label.setBounds(150,150,70,70);
        //label.setBackground(Color.green);
        //label.setOpaque(true);
        label.setIcon(icon); //!!!!!!!!!!!!!!! nie add

        this.getContentPane().setBackground(Color.cyan); // tak ustawiasz kolor tła w całek frame!!
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output

        switch (e.getKeyChar()) {
            case 'a': label.setLocation(label.getX()-5,label.getY());
            break;
            case 'd' : label.setLocation(label.getX()+5,label.getY());
            break;
            case 'w': label.setLocation(label.getX(),label.getY()-5);
            break;
            case 's': label.setLocation(label.getX(),label.getY()+5);
            break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output

        switch (e.getKeyCode()) {
            case  37:
                label.setLocation(label.getX() - 5, label.getY());
                break;
            case 39:
                label.setLocation(label.getX() + 5, label.getY());
                break;
            case 38:
                label.setLocation(label.getX(), label.getY() - 5);
                break;
            case 40:
                label.setLocation(label.getX(), label.getY() + 5);
                break;
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {
        //keyReleased = called whenever a button is released
        //System.out.println("Właśnie kliknałeś: " + e.getKeyChar());
        System.out.println("Właśnie kliknałeś przycisk numer: " + e.getKeyCode());
    }
}
