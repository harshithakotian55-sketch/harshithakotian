package swingss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImageButtonExample implements ActionListener {

    JFrame jfrm;
    JButton btnClock, btnGlass;
    JLabel jlab;

    ImageButtonExample() {

        // Create Frame
        jfrm = new JFrame("Button Image Example");
        jfrm.setSize(400, 300);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load Images (make sure images are in project folder)
        ImageIcon clockIcon = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\la\\src\\swingss\\clock.jpg");
        ImageIcon glassIcon = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\la\\src\\swingss\\hourglass.jpg");

        // Create Buttons with images
        btnClock = new JButton(clockIcon);
        btnGlass = new JButton(glassIcon);

        // Create Label
        jlab = new JLabel("Press a button");

        // Add Action Listener
        btnClock.addActionListener(this);
        btnGlass.addActionListener(this);

        // Add components to frame
        jfrm.add(btnClock);
        jfrm.add(btnGlass);
        jfrm.add(jlab);

        // Make frame visible
        jfrm.setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnClock) {
            jlab.setText("Digital Clock is pressed");
        }
        else if (ae.getSource() == btnGlass) {
            jlab.setText("Hour Glass is pressed");
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageButtonExample();
            }
        });
    }
}
