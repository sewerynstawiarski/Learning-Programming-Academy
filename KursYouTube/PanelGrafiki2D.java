package com.HighLand;

import javax.swing.*;
import java.awt.*;

public class PanelGrafiki2D extends JPanel {
    Image image;
    PanelGrafiki2D(){
        image = new ImageIcon("iconmew.jpg").getImage(); //deklaracja obrazu, który wkleisz później metodą malowania
        this.setPreferredSize(new Dimension(440,400));
    }

    public void paint(Graphics g) { // paint to jest metoda klasy Graphics, nie trzeba jej deklarować, używasz i samoistnie jest zadeklarowana w tle
        Graphics2D g2D = (Graphics2D) g; // castujesz g jako gafikę 2D
        g2D.setPaint(Color.blue); //kolor
        g2D.setStroke(new BasicStroke(5)); // szerokość czcionki
        //g2D.drawLine(0,0,440,440); // rysujesz linię
        //każdy kolejny narysowany obiekt będzie pojawiał się na poprzednim, jka warstwy

        //g2D.setPaint(Color.GREEN);
       // g2D.setStroke(new BasicStroke(5));
        //g2D.drawRect(290,290,150,150); // puste firgury w środku
        //g2D.fillRect(285,5,150,150); // wypełniona figura

        //g2D.setPaint(Color.RED);
        //g2D.drawOval(5,285,150,150);
        //g2D.fillOval(5,245,150,150);

        //g2D.setPaint(Color.RED);
        //g2D.drawArc(5,5,100,100,0,180);
        //g2D.fillArc(5,5,100,100,0,180);
        //g2D.setPaint(Color.WHITE);
        //g2D.fillArc(5,5,100,100,180,180); // pokeball na próbę, rysowanie po łuku

        // rysowanie łączenia kilku znaków, muszą być podane jako Array ich współrzędne
        //int pointx[] = {150,50,250};
        //int pointy[] = {100,200,200};
        //g2D.drawPolygon(pointx,pointy,3); // tutaj zbudowany trójkąt równoramienny
        //g2D.fillPolygon(pointx,pointy,3);

        //można też zarysować tekst
        //g2D.drawString("Seweryn AHAHAHA!",0,0); // nie będzie widocxzne, ponieważ podajesz lewy dolny róg jako punkt startowy
        g2D.setFont(new Font("INK FREE",Font.BOLD,35));
        g2D.drawString("Seweryn AHAHAHA!",50,50);

        // dodawanie obrazu, musisz go wcześniej zadeklarować w konstruktorze
        g2D.drawImage(image,0,0,null); // żeby był tłem musisz go wcześniej dodać jako pierwszą warstwę



    }
}
