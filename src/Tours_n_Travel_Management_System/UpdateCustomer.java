package Tours_n_Travel_Management_System;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JFrame implements ActionListener {
	JTextField t2, t3, t4, t5, t6, t7, t8, t9, t10;
	JLabel t1;
	JButton back, update;
	String username;

	public UpdateCustomer(String username) {
		this.username = username;
		setBounds(340, 120, 850, 550);
		getContentPane().setBackground(new Color(176, 224, 230));
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/update.png"));
		Image i3 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(550, 60, 200, 400);
		add(l1);

		JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		lblName.setBounds(118, 11, 300, 53);
		add(lblName);

		JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		add(l3);

		t1 = new JLabel();
		t1.setBounds(271, 70, 150, 20);
		add(t1);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		add(lblId);

		t2 = new JTextField();
		t2.setBounds(271, 110, 150, 20);
		add(t2);
		t2.setColumns(10);

		JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		add(l2);

		t3 = new JTextField();
		t3.setBounds(271, 150, 150, 20);
		add(t3);
		t3.setColumns(10);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		add(lblName_1);

		t4 = new JTextField();
		t4.setBounds(271, 190, 150, 20);
		add(t4);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		add(lblGender);

		t5 = new JTextField();  // Initialize t5 before setting properties
		t5.setColumns(10);
		t5.setBounds(271, 230, 150, 20);
		add(t5);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		add(lblCountry);

		t6 = new JTextField();
		t6.setBounds(271, 270, 150, 20);
		add(t6);
		t6.setColumns(10);

		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		add(lblReserveRoomNumber);

		t7 = new JTextField();
		t7.setBounds(271, 310, 150, 20);
		add(t7);
		t7.setColumns(10);

		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		add(lblCheckInStatus);

		t8 = new JTextField();
		t8.setBounds(271, 350, 150, 20);
		add(t8);
		t8.setColumns(10);

		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		add(lblDeposite);

		t9 = new JTextField();
		t9.setBounds(271, 390, 150, 20);
		add(t9);
		t9.setColumns(10);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(260, 460, 120, 30);
		back.addActionListener(this);
		add(back);

		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(100, 460, 120, 30);
		update.addActionListener(this);
		add(update);

		setVisible(true);

		try {
			TnTDBConnection c = new TnTDBConnection();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
			if (rs.next()) {
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("id"));
				t3.setText(rs.getString("number"));
				t4.setText(rs.getString("name"));
				t5.setText(rs.getString("gender"));
				t6.setText(rs.getString("country"));
				t7.setText(rs.getString("address"));
				t8.setText(rs.getString("phone"));
				t9.setText(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == update) {
			String s1 = t1.getText();
			String s2 = t2.getText();
			String s3 = t3.getText();
			String s4 = t4.getText();
			String s5 = t5.getText();
			String s6 = t6.getText();
			String s7 = t7.getText();
			String s8 = t8.getText();
			String s9 = t9.getText();

			try {
				TnTDBConnection c = new TnTDBConnection();
				String q1 = "update customer set id = '" + s2 + "', number = '" + s3 + "', name = '" + s4 + "', gender = '" + s5 + "', country = '" + s6 + "', address = '" + s7 + "', phone = '" + s8 + "', email = '" + s9 + "' where username = '" + s1 + "'";
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
				setVisible(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (ae.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// Put some default username for testing
		String defaultUsername = "test_username";
		new UpdateCustomer(defaultUsername);
	}
}
