package com.HighLand;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderDemo implements ChangeListener {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slaider;

    SliderDemo() {
        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label = new JLabel();
        slaider =new JSlider(1,0,100,50);

        slaider.setPreferredSize(new Dimension(200,400));
        slaider.setPaintTicks(true); // ustawiasz na wskaźniku kreski dla lepszej orientacji
        slaider.setMinorTickSpacing(5); // ustawiasz odległość między tymi kreskami, wskaźnikami
        slaider.setPaintTrack(true); // ustawiasz większe wartości na suwaku, na przykład 5 minor daje jeden major
        slaider.setMajorTickSpacing(20); // ustawiasz odległość pomedzy większymi odległościami
        slaider.setPaintLabels(true); // dopisze liczby do wartości większych
        slaider.setFont(new Font("MV Boli",Font.BOLD,15));
        //slaider.setOrientation(SwingConstants.VERTICAL); / tu ręcznie ustawiasz orientacje suwaka, ale możesz tez w pierwszej metodzie ustanawiającej podstawowe wartości, to pierwszy int

        label.setFont(new Font("MV Boli",Font.BOLD,20));
        label.setText("stopni Celsjusza  " + slaider.getValue());

        slaider.addChangeListener(this); // dodajesz zczytywanie zmian z suwaka

        panel.add(label);
        panel.add(slaider);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("stopni Celsjusza  " + slaider.getValue()); // kiedy coś się zmieni w źródle ma nastapić ta akcja, czyli sczytanie danych

    }
}
