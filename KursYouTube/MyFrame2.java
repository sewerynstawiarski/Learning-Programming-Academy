package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame implements ActionListener {
    JButton jButton;
    JLabel label;

    MyFrame2() {
        ImageIcon icon = new ImageIcon("Avatar próbny.jpg");
        ImageIcon icon2 = new ImageIcon("SharingaLogo.jpg");

        jButton = new JButton();
        label = new JLabel();
        label.setBounds(150,150,500,500);
        label.setVisible(false); // false ponieważ ma się pojawiac po kliknięciu przyciski a  nie od razu
        label.setIcon(icon2);

        jButton.setBounds(50, 50, 100, 100);
        jButton.addActionListener(this); // dodajesz interefejs szczytujący do przycisku
        //jButton.addActionListener(e -> System.out.println("LOL")); // wtedy bez implementacji u góry i bez override na dole, mniej pisania
        jButton.setText("It's O.K.");
        jButton.setFocusable(false); // pozbywa się obramowania wewnątrz przycisku
        jButton.setIcon(icon); // dodanie obrazka do przycisku
        jButton.setHorizontalTextPosition(JButton.CENTER);
        jButton.setVerticalTextPosition(JButton.BOTTOM);
        jButton.setFont(new Font("Times New Roman",Font.ITALIC,20));
        jButton.setIconTextGap(20); // minus przybliży do siebie
        jButton.setForeground(Color.yellow);
        jButton.setBackground(Color.cyan);
        jButton.setBorder(BorderFactory.createRaisedBevelBorder()); // ustawiasz obramowanie jakieś/ granice
        //jButton.setEnabled(false); // wyłączy przycisk


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(440, 440);
        this.setVisible(true);
        this.add(jButton);
        this.add(label); // !!!!!!!!
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            //System.out.println("LOL");
            //jButton.setEnabled(false); // sprawi, że po jednym naciśnięciu przycisk się wyłączy
            label.setVisible(true); // ustawiamy, że po naciśnięciu pojawi się label
        } // tutaj sprawiasz, że akcja jest "wyjątkiem", jeśli zostanie przeprowadzona to program musi zrobić wymienioną akcję
    }
}

