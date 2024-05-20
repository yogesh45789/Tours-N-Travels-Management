package Tours_n_Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelReservation extends JFrame {

    private JTextField t1, t2;
    private Choice c1, c2, c3;
    private JLabel l1, l2, l3, l4, l5;
    private static String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            HotelReservation frame = new HotelReservation(username);
            frame.setVisible(true);
        });
    }

    public HotelReservation(String username) {
        this.username = username;
        setBounds(340, 120, 900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BOOK HOTEL");
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(220, 250, 250));

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/book (1).jpg"));
        Image scaledBackgroundImage = backgroundImage.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(420, 100, 500, 300);
        add(backgroundLabel);

        JLabel titleLabel = new JLabel("BOOK HOTEL");
        titleLabel.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        titleLabel.setBounds(118, 11, 300, 53);
        getContentPane().add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 70, 200, 14);
        getContentPane().add(usernameLabel);

        l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        getContentPane().add(l1);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(35, 110, 200, 14);
        getContentPane().add(lblId);

        c1 = new Choice();
        TnTDBConnection c = new TnTDBConnection();
        try {
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                c1.add(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 110, 150, 30);
        add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        getContentPane().add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        getContentPane().add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("Number of Days");
        la4.setBounds(35, 190, 200, 14);
        getContentPane().add(la4);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(271, 190, 150, 20);
        getContentPane().add(t2);
        t2.setColumns(10);

        JLabel la5 = new JLabel("AC / Non-AC");
        la5.setBounds(35, 230, 200, 14);
        getContentPane().add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(271, 230, 150, 30);
        add(c2);

        JLabel la6 = new JLabel("Food Included :");
        la6.setBounds(35, 270, 200, 14);
        getContentPane().add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271, 270, 150, 30);
        add(c3);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 310, 200, 14);
        getContentPane().add(lbl1);

        l2 = new JLabel();
        l2.setBounds(271, 310, 200, 14);
        getContentPane().add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 350, 200, 14);
        getContentPane().add(lbl2);

        l3 = new JLabel();
        l3.setBounds(271, 350, 200, 14);
        getContentPane().add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(35, 390, 200, 14);
        getContentPane().add(lbl3);

        l4 = new JLabel();
        l4.setBounds(271, 390, 200, 14);
        getContentPane().add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 430, 200, 14);
        getContentPane().add(lblDeposite);

        l5 = new JLabel("0");
        l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
        getContentPane().add(l5);

        try {
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            if (rs.next()) {
                l2.setText(rs.getString("id"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton checkPriceButton = new JButton("Check Price");
        checkPriceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TnTDBConnection c = new TnTDBConnection();
                try {
                    String s1 = c1.getSelectedItem();
                    String q1 = "select * from hotel where name = '" + c1.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(q1);
                    if (rs.next()) {
                        int cost = Integer.parseInt(rs.getString("costperperson"));
                        int food = Integer.parseInt(rs.getString("foodincluded"));
                        int ac = Integer.parseInt(rs.getString("acroom"));
                        int persons = Integer.parseInt(t1.getText());
                        int days = Integer.parseInt(t2.getText());
                        String acprice = c2.getSelectedItem();
                        String foodprice = c3.getSelectedItem();
                        if (persons * days > 0) {
                            int total = 0;
                            total += acprice.equals("AC") ? ac : 0;
                            total += foodprice.equals("Yes") ? food : 0;
                            total += cost;
                            total = total * persons * days;
                            l5.setText("Rs " + total);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number..");
                        }
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        checkPriceButton.setBounds(50, 470, 120, 30);
        checkPriceButton.setBackground(Color.BLACK);
        checkPriceButton.setForeground(Color.WHITE);
        getContentPane().add(checkPriceButton);

        JButton bookButton = new JButton("Book");
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TnTDBConnection c = new TnTDBConnection();
                try {
                    if (l5.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null, "Can't Book!");
                    } else {
                        String q1 = "insert into bookHotel values('" + l1.getText() + "', '" + c1.getSelectedItem() + "', '" + t1.getText() + "', '" + t2.getText() + "', '" + c2.getSelectedItem() + "', '" + c3.getSelectedItem() + "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + l5.getText() + "')";
                        c.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                        setVisible(false);
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        bookButton.setBounds(200, 470, 120, 30);
        bookButton.setBackground(Color.BLACK);
        bookButton.setForeground(Color.WHITE);
        getContentPane().add(bookButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> setVisible(false));
        backButton.setBounds(350, 470, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        getContentPane().add(backButton);

        getContentPane().setBackground(new Color(176, 224, 230));
    }
}
