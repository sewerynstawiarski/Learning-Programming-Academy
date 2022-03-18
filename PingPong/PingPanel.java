package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PingPanel extends JPanel implements Runnable {
    static final int GAME_WITDH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WITDH*(0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WITDH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PALETKI_WIDTH = 30;
    static final int PALETKI_HEIGHT = 90;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paletki paletka1;
    Paletki paletka2;
    PingBall ball;
    Wynik wynik;

    PingPanel() {
        newPaletka();
        newPingBall();
        wynik = new Wynik(GAME_WITDH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newPaletka() {
    paletka1 = new Paletki(0,(GAME_HEIGHT/2)-(PALETKI_HEIGHT/2),PALETKI_WIDTH,PALETKI_HEIGHT,1);
    paletka2 = new Paletki(GAME_WITDH-PALETKI_WIDTH,(GAME_HEIGHT/2)-(PALETKI_HEIGHT/2),PALETKI_WIDTH,PALETKI_HEIGHT,2);
    }
    public void newPingBall() {
        random = new Random();
        //ball = new PingBall((GAME_WITDH/2)-(BALL_DIAMETER/2), (GAME_HEIGHT/2)-(BALL_DIAMETER/2), BALL_DIAMETER,BALL_DIAMETER);
        ball = new PingBall((GAME_WITDH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER,BALL_DIAMETER);
    }
    public void paint(Graphics g) {
    image = createImage(getWidth(),getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
    paletka1.draw(g);
    paletka2.draw(g);
    ball.draw(g);
    wynik.draw(g);
    }
    public void move() {
        paletka1.move();
        paletka2.move();
        ball.move();
    }
    public void checkCollision() {
        //ogranicza od góry
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        // odbicie od paletki
        if (ball.intersects(paletka1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity >0) {
                ball.yVelocity++;
            }
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paletka2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity >0) {
                ball.yVelocity++;
            }
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        // ogranicza paletki
        if (paletka1.y <=0) {
            paletka1.y = 0;
        }
        if (paletka1.y >+ (GAME_HEIGHT-PALETKI_HEIGHT)) {
            paletka1.y = GAME_HEIGHT-PALETKI_HEIGHT;
        }
        if (paletka2.y <=0) {
            paletka2.y = 0;
        }
        if (paletka2.y >+ (GAME_HEIGHT-PALETKI_HEIGHT)) {
            paletka2.y = GAME_HEIGHT-PALETKI_HEIGHT;
        }

        //daje punkty
        if (ball.x <= 0) {
            wynik.player2++;
            newPingBall();
            newPaletka();
        }
        if (ball.x >= GAME_WITDH-BALL_DIAMETER) {
            wynik.player1++;
            newPingBall();
            newPaletka();
        }
    }
    public void run() {
    long lasTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta =0;
    while (true) {
        long now = System.nanoTime();
        delta += (now-lasTime)/ns;
        lasTime = now;
        if (delta >= 1) {
            move();
            checkCollision();
            repaint();
            delta--;
        }

    }

    }
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paletka1.keyPressed(e);
            paletka2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paletka1.keyReleased(e);
            paletka2.keyReleased(e);
        }
    }
}
