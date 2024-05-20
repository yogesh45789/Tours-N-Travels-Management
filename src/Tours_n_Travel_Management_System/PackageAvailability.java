package Tours_n_Travel_Management_System;

import javax.swing.*;
import java.awt.*;

public class PackageAvailability extends JFrame {
    public static void main(String[] args) {
        new PackageAvailability().setVisible(true);
    }

    PackageAvailability() {
        setBounds(350, 100, 900, 565);
        setVisible(true);

        String[] package1 = new String[]{"package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights", "Airport Assistance at Airport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
        String[] package2 = new String[]{"package2.jpg", "SILVER PACKAGE", "4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
        String[] package3 = new String[]{"package3.jpg", "BRONZE PACKAGE", "6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(176, 224, 230));

        ImageIcon packageImage = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/" + pack[0]));
        JLabel packageLabel = new JLabel(packageImage);
        packageLabel.setBounds(400, 0, 450, 420);
        p1.add(packageLabel);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        for (int i = 2; i < pack.length - 2; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setForeground(i % 2 == 0 ? Color.RED : Color.BLUE);
            label.setBounds(35, 70 + (i - 2) * 40, 400, 14);
            p1.add(label);
        }

        JLabel lblCheckInStatus = new JLabel(pack[pack.length - 2]);
        lblCheckInStatus.setForeground(Color.BLUE);
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblCheckInStatus.setBounds(35, 400, 200, 30);
        p1.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel(pack[pack.length - 1]);
        lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblDeposite.setBounds(35, 460, 400, 40);
        p1.add(lblDeposite);

        return p1;
    }
}
