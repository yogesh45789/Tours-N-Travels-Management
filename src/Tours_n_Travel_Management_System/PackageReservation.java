package Tours_n_Travel_Management_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class PackageReservation extends JFrame implements ActionListener {

	JTextField t1;
	JLabel l1, l2, l3, l4, l5;
	Choice c1;
	JButton b1, b2, b3;
	static String username;

	public PackageReservation(String username) {

		this.username = username;
		setBounds(320, 150, 910, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BOOK PACKAGE");
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(176, 224, 230));

		ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/bookpackage.jpg"));
		Image scaledBackgroundImage = backgroundImage.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledBackgroundImage);
		JLabel backgroundLabel = new JLabel(scaledIcon);
		backgroundLabel.setBounds(485, 50, 400, 300);
		add(backgroundLabel);

		JLabel titleLabel = new JLabel("BOOK PACKAGE");
		titleLabel.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		titleLabel.setBounds(118, 11, 300, 53);
		add(titleLabel);

		JLabel userLabel = new JLabel("Username:");
		userLabel.setBounds(35, 70, 200, 14);
		add(userLabel);

		l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		add(l1);

		JLabel packageLabel = new JLabel("Select Package:");
		packageLabel.setBounds(35, 110, 200, 14);
		add(packageLabel);

		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(271, 110, 150, 30);
		add(c1);

		JLabel personsLabel = new JLabel("Total Persons");
		personsLabel.setBounds(35, 150, 200, 14);
		add(personsLabel);

		t1 = new JTextField();
		t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		add(t1);
		t1.setColumns(10);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(35, 190, 200, 14);
		add(idLabel);

		l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		add(l2);

		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setBounds(35, 230, 200, 14);
		add(numberLabel);

		l3 = new JLabel();
		l3.setBounds(271, 230, 200, 14);
		add(l3);

		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(35, 270, 200, 14);
		add(phoneLabel);

		l4 = new JLabel();
		l4.setBounds(271, 270, 200, 14);
		add(l4);

		JLabel priceLabel = new JLabel("Total Price:");
		priceLabel.setBounds(35, 310, 200, 14);
		add(priceLabel);

		l5 = new JLabel("Rs 0");
		l5.setBounds(271, 310, 200, 14);
		l5.setForeground(Color.RED);
		add(l5);

		b1 = new JButton("Check Price");
		b1.addActionListener(this);
		b1.setBounds(50, 380, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);

		b2 = new JButton("Book Package");
		b2.addActionListener(this);
		b2.setBounds(200, 380, 120, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);

		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setBounds(350, 380, 120, 30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		add(b3);

		setVisible(true);

		try {
			TnTDBConnection c = new TnTDBConnection();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
			while (rs.next()) {
				l2.setText(rs.getString("id"));
				l3.setText(rs.getString("number"));
				l4.setText(rs.getString("phone"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String pack = c1.getSelectedItem();
			int cost = 0;
			if (pack.equals("Gold Package")) {
				cost += 12000;
			} else if (pack.equals("Silver Package")) {
				cost += 25000;
			} else {
				cost += 32000;
			}
			cost *= Integer.parseInt(t1.getText());
			if (cost > 0) {
				l5.setText("Rs " + cost);
			} else {
				JOptionPane.showMessageDialog(null, "Please enter valid details!");
			}
		} else if (e.getSource() == b2) {
			try {
				TnTDBConnection c = new TnTDBConnection();
				if (l5.getText().equals("Rs 0")) {
					JOptionPane.showMessageDialog(null, "Sorry! Can't Book");
				} else {
					String q1 = "insert into bookPackage values( '" + l1.getText() + "','" + c1.getSelectedItem() + "', '" + t1.getText() + "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + l5.getText() + "')";
					c.s.executeUpdate(q1);
					JOptionPane.showMessageDialog(null, "Package Booked Successfully");
					setVisible(false);
				}
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
			}
		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new PackageReservation(username);
	}
}
