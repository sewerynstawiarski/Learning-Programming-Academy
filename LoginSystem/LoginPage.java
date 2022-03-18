package com.HighLand;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton =  new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JTextField userIDfield = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDlabel = new JLabel("User Id: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("HELLO THERE!");
        HashMap<String, String> logininfo = new HashMap<String, String>();
    LoginPage(HashMap<String,String> logininfooriginal) {
            logininfo = logininfooriginal;

            messageLabel.setBounds(120,300,200,50);
            messageLabel.setFont(new Font("MV Boli",Font.BOLD,20));

            userIDfield.setBounds(120,100,200,30);
            userPasswordField.setBounds(120,150,200,30);

            userIDlabel.setBounds(50,100,70,30);
            userPasswordLabel.setBounds(50,150,70,30);

            loginButton.setBounds(120,200,100,50);
            loginButton.addActionListener(this);
            loginButton.setFont(new Font("Ink Free",Font.BOLD,15));
            loginButton.setForeground(Color.GREEN);
            loginButton.setBorderPainted(false);
            loginButton.setBackground(Color.white);
            loginButton.setFocusable(false);

            resetButton.setBounds(220,200,100,50);
            resetButton.addActionListener(this);
            resetButton.setFont(new Font("Ink Free", Font.BOLD,15));
            resetButton.setForeground(Color.RED);
            resetButton.setBorderPainted(false);
            resetButton.setBackground(Color.white);
            resetButton.setFocusable(false);

            frame.add(userIDlabel);
            frame.add(userPasswordLabel);
            frame.add(messageLabel);
            frame.add(userIDfield);
            frame.add(userPasswordField);
            frame.add(loginButton);
            frame.add(resetButton);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(440,440);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDfield.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton) {
            String userID = userIDfield.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.blue);
                    messageLabel.setText("You've logged in!");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else {
                    messageLabel.setForeground(Color.BLACK);
                    messageLabel.setText("Wrong password!");
                }
            }
            else {
                messageLabel.setForeground(Color.BLACK);
                messageLabel.setText("User ID not found");
            }
        }
    }
}
