package Tours_n_Travel_Management_System;

import javax.swing.*;
import java.awt.*;

public class ViewHotels extends JFrame implements Runnable {

    JLabel caption;
    Thread th;
    ImageIcon[] hotelImages;
    int currentImageIndex;

    public void run() {
        try {
            for (int i = 0; i < hotelImages.length; i++) {
                caption.setText(hotelImages[i].getDescription());
                Thread.sleep(2800);
                currentImageIndex = (currentImageIndex + 1) % hotelImages.length;
            }
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ViewHotels() {

        setBounds(350, 90, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        setUndecorated(true);

        th = new Thread(this);
        currentImageIndex = 0;

        caption = new JLabel();
        caption.setBounds(50, 620, 800, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);

        hotelImages = new ImageIcon[]{
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel1.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel2.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel3.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel4.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel5.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel6.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel7.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel8.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel9.jpg")),
                new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/hotel10.jpg"))
        };

        JLabel[] hotelLabels = new JLabel[hotelImages.length];
        for (int i = 0; i < hotelImages.length; i++) {
            hotelLabels[i] = new JLabel(hotelImages[i]);
            hotelLabels[i].setBounds(0, 0, 900, 700);
            add(hotelLabels[i]);
            hotelLabels[i].setVisible(false);
        }

        hotelLabels[0].setVisible(true);

        setLayout(null);

        th.start();

    }

    public static void main(String args[]) {
        new ViewHotels().setVisible(true);

    }

}
