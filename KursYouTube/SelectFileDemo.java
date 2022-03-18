package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectFileDemo extends JFrame implements ActionListener {
    JButton button;

    SelectFileDemo() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Wybierz plik");
        button.addActionListener(this);

        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".")); // "." ustawi jako miejsce domyślne folder projektu, inaczej trzeba ściężkę pliku wpisać
            //fileChooser.setCurrentDirectory(new File("C:\\Users\\sewer"));

            //System.out.println(fileChooser.showOpenDialog(null)); // pokaże plik do otwarcia, po zaznaczeniu odpowie 0 (został wybrany) 1 (nie został wybrany)
            int response = fileChooser.showOpenDialog(null); // file chooser otwiera okno wyboru tutaj i zachowuje wynik wyżej opisany jako int response
            //int response = fileChooser.showSaveDialog(null); // teraz pozwala wybrać miejsce zapisu pliku
            if (response == JFileChooser.APPROVE_OPTION) { // jeśli JFile Chooser pommyślnie zadziała to
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); // klasa File now instancja/ pobiera ściężkę do wybranego pliku
                System.out.println(file);
            }
        }
    }
}
