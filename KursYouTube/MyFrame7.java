package com.HighLand;

import javax.swing.*;

public class MyFrame7 extends JFrame {
    JButton button = new JButton("MyButton");
    JButton button2 = new JButton("MyButton2");

    MyFrame7() {
        button.setBounds(50,100,200,100);
        button.addActionListener( (e) -> System.out.println("Kliknąłeś w przycisk Wladymir!")); // lamda expresion zamiast tworzenia ianonymous inne class
        // wysyłasz argument i to co się ma dziać po tym, jeśli więcej niż jednalinijka to {}
        button2.setBounds(250,100,200,100);
        button2.addActionListener( (e) -> System.out.println("Głupia małpa dostanie cukierka!Nie mogę!"));

        this.add(button);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);
    }
}
