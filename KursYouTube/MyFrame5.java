package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame5 extends JFrame implements ActionListener {
    JComboBox comboBox;

    MyFrame5() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"piesek", "kotek", "słoń"}; // do combox można wysyłać tylko dane referencyjne  !!
        //Integer[] animals2 = {1,2,3};
        comboBox = new JComboBox<>(animals); // w nawiasie można też wymienić, ale trzeba użyć wrapper class
        comboBox.addActionListener(this);
        //comboBox.setEditable(true); // sprawi, że w okienku będzie można coś wpisać, żeby znaleźć na liście
        //System.out.println(comboBox.getItemCount()); // ta funkcja pokaże ile jest na liście przedmiotów
        //comboBox.addItem("konik"); // dodaje do listy
        //comboBox.insertItemAt("Orzeł", 0); // dodaje do listy w danym miejscu wyznaczonym przez index
        //comboBox.setSelectedIndex(3); // sprawia, że domyślnie pierwsza pokazuje się odpowiedź z danym indexem
        //comboBox.removeItem("kotek"); // usuwa z listy dany obiekt
        //comboBox.removeItemAt(1); // usuwa obiekt o danym indeksie
        //comboBox.removeAllItems();// usunie wszystko z listy/ taki reset

        this.add(comboBox);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboBox) {
            System.out.println(comboBox.getSelectedItem()); // zwróci wybrany item
            //System.out.println(comboBox.getSelectedIndex()); //  zwróci index zaczynając od zera
        }
    }
}
