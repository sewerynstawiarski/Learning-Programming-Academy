package com.HighLand;

import java.awt.*;
import javax.swing.*;

public class ProgressBarDemo {
    JFrame frame = new JFrame();
    JProgressBar progressBar = new JProgressBar();

    ProgressBarDemo() {

        progressBar.setValue(0);
        progressBar.setBounds(10,10,400,100);
        progressBar.setStringPainted(true); // dodaje procentowy miernik na wskaźniku
        progressBar.setFont(new Font("MV Boli",Font.BOLD,20));
        progressBar.setForeground(Color.blue);
        progressBar.setBackground(Color.darkGray);


        frame.add(progressBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    } // tutaj ustawiłeś odliczanie do tyłu, zmieniając counter na zero i po while loop dodając 1 zamiast odejmując będzie w druga stronę
    public void fill() {
        int counter = 0;
        while (counter <= 100) { // ustawiasz while loop aby dla każdej wartości p kolei zmieniał szczytywaną wartość pokazywaną
            progressBar.setValue(counter);
            try {
                Thread.sleep(100); // sprawia, że program przystanie na sekundę, dzięki czemu wygląda to na "wczytywanie" stopniowe, a nie wykonanie całej pętli na raz
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
        }
        progressBar.setString("Get it down!!");
    }
}
