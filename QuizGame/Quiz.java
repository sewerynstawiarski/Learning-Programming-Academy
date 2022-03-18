package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {
        public static final String[] QUESTIONS = {
                "Przedstawicielem której dynastii był Zygmunt August?",
                "Kogo pokonały wojska Rzeczypospolitej w bitwie pod Kircholmem?",
                "Który władca poprowadził wojska Królestwa Polskiego w bitwie pod Płowcami?",
                "Który władca przyjął hołd pruski z rąk Wielkiego Mistrza Zakonu Krzyżackiego?",
                "Kto był pierwszym królem Polski po rozbiciu dzielnicowym?"
        };
        String[][] options = {
                {"Piastów", "Jagiellonów", "Wazów", "Sasów"},
                {"Rosjan", "Turków", "Kozaków", "Szwedów"},
                {"Kazimierz Wielki", "Władysław Jagiełło", "Władysław Łokietek", "Bolesław Chrobry"},
                {"Władsyław Jagiełło", "Jan III Sobieski", "Zygmunt August", "Zygmunt Stary"},
                {"Przemysł II", "Władysław Łokietek", "Mieszko II", "Kazimierz Wielki"}
        };
        char[] answers = {
                'B',
                'D',
                'C',
                'D',
                'A'
        };

        char guess;
        char answer;
        int index=0;
        int correctGuesses=0;
        int totalQuestions = QUESTIONS.length;
        int result;
        int seconds = 10;

        JFrame frame = new JFrame();
        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea();
        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();
        JLabel answerAlabel = new JLabel();
        JLabel answerBlabel = new JLabel();
        JLabel answerClabel = new JLabel();
        JLabel answerDlabel = new JLabel();
        JLabel timeLabel = new JLabel();
        JLabel secondsLeft = new JLabel();
        JTextField numberRight = new JTextField();
        JTextField percentage = new JTextField();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                secondsLeft.setText(String.valueOf(String.valueOf(seconds)));
                if (seconds<=0) {
                    displayAnswer();
                }

            }
        });

    public Quiz()  {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,620);
        frame.getContentPane().setBackground(new Color(40,40,90));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,600,60);
        textField.setBackground(new Color(40,60,40));
        textField.setForeground(Color.WHITE);
        textField.setEditable(false);
        textField.setFont(new Font("MV Boli",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);


        textArea.setBounds(0,60,600,60);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(40,90,40));
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setFont(new Font("Times New Roman",Font.BOLD,20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));

        buttonA.setBounds(10,120,80,100);
        buttonA.setFont(new Font("Times New Roman",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setBackground(new Color(90,40,60));
        buttonA.setText("A.");
        buttonA.setForeground(Color.WHITE);

        buttonB.setBounds(10,220,80,100);
        buttonB.setFont(new Font("Times New Roman",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setBackground(new Color(90,40,60));
        buttonB.setText("B.");
        buttonB.setForeground(Color.WHITE);

        buttonC.setBounds(10,320,80,100);
        buttonC.setFont(new Font("Times New Roman",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setBackground(new Color(90,40,60));
        buttonC.setText("C.");
        buttonC.setForeground(Color.WHITE);

        buttonD.setBounds(10,420,80,100);
        buttonD.setFont(new Font("Times New Roman",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setBackground(new Color(90,40,60));
        buttonD.setText("D.");
        buttonD.setForeground(Color.WHITE);

        answerAlabel.setBounds(100,120,500,100);
        answerAlabel.setBackground(new Color(40,40,90));
        answerAlabel.setForeground(Color.WHITE);
        answerAlabel.setFont(new Font("Ink Free",Font.BOLD,25));

        answerBlabel.setBounds(100,220,500,100);
        answerBlabel.setBackground(new Color(40,40,90));
        answerBlabel.setForeground(Color.WHITE);
        answerBlabel.setFont(new Font("Ink Free",Font.BOLD,25));

        answerClabel.setBounds(100,320,500,100);
        answerClabel.setBackground(new Color(40,40,90));
        answerClabel.setForeground(Color.WHITE);
        answerClabel.setFont(new Font("Ink Free",Font.BOLD,25));

        answerDlabel.setBounds(100,420,500,100);
        answerDlabel.setBackground(new Color(40,40,90));
        answerDlabel.setForeground(Color.WHITE);
        answerDlabel.setFont(new Font("Ink Free",Font.BOLD,25));

        secondsLeft.setBounds(250,520,100,70);
        secondsLeft.setBackground(new Color(90,40,50));
        secondsLeft.setForeground(Color.WHITE);
        secondsLeft.setFont(new Font("Times New Roman",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createEmptyBorder());
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(150,520,100,70);
        timeLabel.setBackground(new Color(40,40,90));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Times New Roman",Font.BOLD,33));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Czas: ");

        numberRight.setBounds(100,120,400,200);
        numberRight.setBackground(new Color(150,150,250));
        numberRight.setForeground(Color.WHITE);
        numberRight.setFont(new Font("Ink Free", Font.BOLD, 40));
        numberRight.setEditable(false);
        numberRight.setBorder(BorderFactory.createLineBorder(Color.yellow,5,true));
        numberRight.setHorizontalAlignment(JTextField.CENTER);


        percentage.setBounds(100,320,400,200);
        percentage.setBackground(new Color(150,150,250));
        percentage.setForeground(Color.WHITE);
        percentage.setFont(new Font("Ink Free", Font.BOLD, 40));
        percentage.setEditable(false);
        percentage.setBorder(BorderFactory.createLineBorder(Color.yellow,5,true));
        percentage.setHorizontalAlignment(JTextField.CENTER);




        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answerAlabel);
        frame.add(answerBlabel);
        frame.add(answerClabel);
        frame.add(answerDlabel);
        frame.add(secondsLeft);
        frame.add(timeLabel);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion() {
        if (index>=totalQuestions) {
            showResults();
        }
        else {
            textField.setText("Pytanie: "+(index+1));
            textArea.setText(QUESTIONS[index]);
            answerAlabel.setText(options[index][0]);
            answerBlabel.setText(options[index][1]);
            answerClabel.setText(options[index][2]);
            answerDlabel.setText(options[index][3]);
            timer.start();
        }

    }
    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A') {
            answerAlabel.setBackground(Color.RED);
            answerAlabel.setOpaque(true);
            if (answers[index] != 'B') {
                answerBlabel.setBackground(Color.RED);
                answerBlabel.setOpaque(true);
            }
            if (answers[index] != 'C') {
                answerClabel.setBackground(Color.RED);
                answerClabel.setOpaque(true);
            }
            if (answers[index] != 'D') {
                answerDlabel.setBackground(Color.RED);
                answerDlabel.setOpaque(true);
            }
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerAlabel.setBackground(new Color(40,40,90));
                answerBlabel.setBackground(new Color(40,40,90));
                answerClabel.setBackground(new Color(40,40,90));
                answerDlabel.setBackground(new Color(40,40,90));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }
    public void showResults() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correctGuesses/(double)totalQuestions)*100);

        textField.setText("Wyniki !!!");

        numberRight.setText(correctGuesses+"/"+totalQuestions);
        percentage.setText(result + "%");

        frame.add(numberRight);
        frame.add(percentage);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA) {
            answer = 'A';
            if (answer==answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonB) {
            answer = 'B';
            if (answer==answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonC) {
            answer = 'C';
            if (answer==answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonD) {
            answer = 'D';
            if (answer==answers[index]) {
                correctGuesses++;
            }
        }
        displayAnswer();
    }
}
