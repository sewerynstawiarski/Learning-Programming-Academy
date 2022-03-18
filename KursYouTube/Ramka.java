package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramka extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;

    Ramka () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Co potwierdzasz?");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,50));
        textField.setFont(new Font("Consolas", Font.ITALIC,18));
        textField.setForeground(new Color(50,100,0));
        textField.setBackground(new Color(12,200,200));
        textField.setCaretColor(Color.white);
        textField.setText("Źródło szczęścia");
        //textField.setEditable(false); // sprawia, że tekstu w ramce nie ożna edytować

        this.add(textField);
        this.add(button);
        this.pack();
        this.setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            System.out.println("Potwierdziłeś, że " + textField.getText());
            textField.setEditable(false);
            button.setEnabled(false); // dzieki tym linijkom, po wprowadzeniu jednej danej nie mogą już nic więcej wprowadzić
        }

    }
}
