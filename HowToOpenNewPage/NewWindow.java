import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Here I am!");

    NewWindow () {
        label.setBounds(20,20,200,100);
        label.setFont(new Font("Times New Roman", Font.BOLD,25));

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
