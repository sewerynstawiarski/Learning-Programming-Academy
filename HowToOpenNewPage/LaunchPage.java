import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Click here!");

    LaunchPage() {

        button.setBounds(100,100,200,200);
        button.setFocusable(false);
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,440);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            frame.dispose(); // sprawia, że zamkniesz okno po użyciu, po kliknięciu tu się wszystko dzieje
            NewWindow window = new NewWindow();
        }

    }
}
