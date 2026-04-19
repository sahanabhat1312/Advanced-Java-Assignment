package program4;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageButtonExample {

    JLabel l1;

    ImageButtonExample() {

        JFrame f = new JFrame("Image Button Example");

        // Label
        l1 = new JLabel();
        l1.setBounds(50, 50, 600, 100);
        l1.setFont(new Font("Arial", Font.BOLD, 30));

        // Load images (make sure images are in project folder)
        ImageIcon clockIcon = new ImageIcon("\"C:\\Users\\Sahana\\OneDrive\\Documents\\java\\Assignment\\Java_Assignment\\src\\program4\\digital.png\"");
        ImageIcon hourglassIcon = new ImageIcon("\"C:\\Users\\Sahana\\OneDrive\\Documents\\java\\Assignment\\Java_Assignment\\src\\program4\\hourglass.png\"");

        // Buttons with images
        JButton b1 = new JButton(" Digital Clock ", clockIcon);
        JButton b2 = new JButton(" Hour Glass ", hourglassIcon);

        b1.setBounds(100, 200, 200, 100);
        b2.setBounds(350, 200, 200, 100);

        // Action for Digital Clock
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        // Action for Hour Glass
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        // Add components
        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}