package com.HighLand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame6 extends JFrame {
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");

    MyFrame6() {
        button1.setBounds(50,100,100,100);
        button2.setBounds(150,100,100,100);
        button3.setBounds(250,100,100,100);
        button1.addActionListener(new ActionListener() { // tworzysz bezimienną klasę "jednorazową"specjalnie lda tego przycisku, nie musisz implementować interfejsu
            // zamiast tworzyć osobne klasy, przywołujesz w tym miejscu jedną bezimienną poprzez new ActionListener i nadajesz jej jeden cel
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nacisnąłeś przycisk numer1!!");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nacisnąłeś przycisk numer2!!");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nacisnąłeś przycisk numer3!!");
            }
        });
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(440,440);
        this.setLayout(null);
        this.setVisible(true);

    }
}
