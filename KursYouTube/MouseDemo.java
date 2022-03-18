package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo extends JFrame implements MouseListener {
        JLabel label;
        ImageIcon pikachu;
        ImageIcon mew;
        ImageIcon whitepokemon;
        ImageIcon brownpokemon;

    MouseDemo() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,900);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        //label.setBounds(5,5,150,150);
        //label.setBackground(Color.cyan);
        //label.setOpaque(true);
        //label.addMouseListener(this);
        //this.addMouseListener(this);
        pikachu = new ImageIcon("iconpikachu.jpg");
        mew = new ImageIcon("iconmew.jpg");
        whitepokemon = new ImageIcon("C:\\Users\\sewer\\IdeaProjects\\KursYouTube\\iconwhitepokemon.png");
        brownpokemon = new ImageIcon("C:\\Users\\sewer\\IdeaProjects\\KursYouTube\\iconbrownpokemon.jpg");
        label.setIcon(whitepokemon);
        label.addMouseListener(this);


        this.setLocationRelativeTo(null);
        this.add(label);


        this.pack();
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when the mouse button has been clicked (pressed and released) on a component
        //System.out.println("Kliknąłeś na myszkę!");
        //label.setBackground(Color.BLACK);


    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Invoked when a mouse button has been pressed on a component
        //System.out.println("Nacisnąłeś przycisk!");
        //label.setBackground(Color.YELLOW);
        label.setIcon(pikachu);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Invoked when a mouse button has been released on a component
        //System.out.println("Puściłeś przycisk!");
        //label.setBackground(Color.GREEN);
        label.setIcon(mew);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a component
        //System.out.println("Najechałeś na obiekt!");
        //label.setBackground(Color.LIGHT_GRAY);
        label.setIcon(brownpokemon);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component
        //System.out.println("Opuściłeś obiekt!");
        //label.setBackground(Color.BLUE);
        label.setIcon(whitepokemon);

    }
}
