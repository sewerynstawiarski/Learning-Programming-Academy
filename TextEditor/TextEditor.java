package com.HighLand;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;
    JLabel fontLabel;
    JButton colorChooserButton;
    JComboBox font;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem exitFile;

    TextEditor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SewerynTextEditor");
        this.setSize(600,660);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Times New Roman",Font.BOLD,20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500,500));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLabel = new JLabel("Font: ");

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.BOLD, (Integer) fontSizeSpinner.getValue()));
            }
        });

        colorChooserButton = new JButton("Color");
        colorChooserButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        font = new JComboBox<>(fonts);
        font.addActionListener(this);
        font.setSelectedItem("Times New Roman");

        //MENU
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
        exitFile = new JMenuItem("Exit");

        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exitFile.addActionListener(this);

        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(exitFile);
        menuBar.add(fileMenu);



        //*MENU

        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(colorChooserButton);
        this.add(font);
        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == colorChooserButton) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null,"Choose a color:",Color.black);

            textArea.setForeground(color);

        }
        if (e.getSource() == font) {
            textArea.setFont(new Font((String)font.getSelectedItem(),Font.BOLD,textArea.getFont().getSize()));
        }
        if (e.getSource() == openFile) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if (file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"/n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally {
                    fileIn.close();
                }
            }
        }
        if (e.getSource() == saveFile) {
            JFileChooser fileChooser= new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally {
                    fileOut.close();
                }
            }



        }
        if (e.getSource() == exitFile) {
            System.exit(0);
        }

    }
}
