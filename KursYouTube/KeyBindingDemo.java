package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyBindingDemo {
    JFrame frame;
    JLabel label;
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;


    KeyBindingDemo() {
        frame = new JFrame("KeyBindingDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setLayout(null);

        label = new JLabel();
        label.setBackground(Color.GREEN);
        label.setBounds(150,150,100,100);
        label.setOpaque(true);

        upAction = new UpAction(); // musisz stworzyć instancję danej klasy, którą stworzyłeś niżej
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction"); // ustanawiasz akcję przy naciśnięciu strzałki w górę lub innego przycisku njaki ustalisz
        label.getActionMap().put("upAction",upAction); // tutaj przypisujesz co to naciśnięcie ma oznaczać, czyli tutaj wykonancie klasy upAction
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        label.getActionMap().put("downAction",downAction);
        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"leftAction");
        label.getActionMap().put("leftAction",leftAction);
        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"rightAction");
        label.getActionMap().put("rightAction",rightAction);

        //label.getInputMap().put(KeyStroke.getKeyStroke('w'),"upAction"); // ustanawiasz akcję przy naciśnięciu strzałki w górę lub innego przycisku njaki ustalisz
        //label.getActionMap().put("upAction",upAction); // tutaj przypisujesz co to naciśnięcie ma oznaczać, czyli tutaj wykonancie klasy upAction
        //label.getInputMap().put(KeyStroke.getKeyStroke('s'),"downAction");
        //label.getActionMap().put("downAction",downAction);
        //label.getInputMap().put(KeyStroke.getKeyStroke('a'),"leftAction");
        //label.getActionMap().put("leftAction",leftAction);
       //label.getInputMap().put(KeyStroke.getKeyStroke('d'),"rightAction");
        //label.getActionMap().put("rightAction",rightAction);

        frame.add(label);
        frame.setVisible(true);



    }
    public class UpAction extends AbstractAction { //Musisz ustanowić klasy osobne dla każdego przycisku, do którego przywiążesz akcję
        @Override
        public void actionPerformed(ActionEvent e) {
        label.setLocation(label.getX(),label.getY()-5); // tutaj zmieniasz położenie etykiety, kiedy wystąpi dana akcja
        }
    }
    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
        label.setLocation(label.getX(),label.getY()+5);
        }
    }
    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
        label.setLocation(label.getX()-5,label.getY());
        }
    }
    public class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
        label.setLocation(label.getX()+5,label.getY());
        }
    }
}
