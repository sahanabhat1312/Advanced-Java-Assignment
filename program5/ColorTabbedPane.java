package program5;

import java.awt.Color;
import javax.swing.*;

public class ColorTabbedPane {

    JFrame f;

    ColorTabbedPane() {

        f = new JFrame("Color Tabs");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        // Set colors
        p1.setBackground(Color.CYAN);
        p2.setBackground(Color.MAGENTA);
        p3.setBackground(Color.YELLOW);

        // Tabbed Pane
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50, 50, 300, 300);

        tp.add("CYAN", p1);
        tp.add("MAGENTA", p2);
        tp.add("YELLOW", p3);

        f.add(tp);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ColorTabbedPane();
    }
}
