package com.HighLand;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("Okienko próbne - tutaj tytuł"); // ustawiasz tytuł okienka
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sprawia, że po kliknięciu X program przestanie działać, domyślnie jest po prostu HIDe
        this.setResizable(false); // sprawia, że nie można zmienić rozmiaru okienka za pomocą myszki
        this.setSize(440,440); // ustawia wysokość i szerokość okienka

        ImageIcon icon = new ImageIcon("SharingaLogo.jpg"); // tworzy obraz/ikonę
        this.setIconImage(icon.getImage()); // ustawia przywołaną ikonę jako ikonę okienka
        //this.getContentPane().setBackground(Color.yellow); //ustanawiasz tło okienka, jego kolor, jeden z domyślnych
        this.getContentPane().setBackground(new Color(100,3,89)); // tak ustawiasz kolor na podstawie współrzędnych RGB (o-255)/ *(red, green, blue)
        //this.getContentPane().setBackground(new Color(0x0000FF)); // tak ustawiasz na podstawie liczb szesnastkowych

        this.setVisible(true); // sprawia, że okrenko będzie widoczne
    }
}
