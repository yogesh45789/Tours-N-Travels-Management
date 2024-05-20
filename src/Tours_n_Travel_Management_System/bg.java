package Tours_n_Travel_Management_System;

import javax.swing.*;
import java.awt.*;

public class bg extends JFrame {

	JLabel titleLabel;

	public bg() {

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		getContentPane().setBackground(new Color(220, 250, 250));

		// Load background image
		ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/home.jpg"));
		Image scaledBackgroundImage = backgroundImage.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledBackgroundImage);
		JLabel backgroundLabel = new JLabel(scaledIcon);
		backgroundLabel.setBounds(0, 0, 1300, 700);
		add(backgroundLabel);

		// Add title label
		titleLabel = new JLabel("Tours & Travel Management System");
		titleLabel.setBounds(300, 70, 1200, 70);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Raleway", Font.BOLD, 40));
		backgroundLabel.add(titleLabel);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new bg().setVisible(true);
			new SplashFrame().setVisible(true);
		});
	}
}
