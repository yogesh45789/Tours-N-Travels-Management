package Tours_n_Travel_Management_System;

import java.awt.Image;
import javax.swing.*;

public class SplashingFrame {

	public static void main(String[] args) {
		SplashFrame frame = new SplashFrame();
		frame.setVisible(true);
		int x = 1;
		for (int i = 1; i <= 500; i += 6, x += 7) {
			frame.setLocation(600 - (x + i) / 2, 250 - (i / 4));
			frame.setSize(x + i, i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// Exception handling
			}
		}
		frame.setVisible(true);
	}
}

class SplashFrame extends JFrame implements Runnable {
	Thread t1;

	public SplashFrame() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Tours_n_Travel_Management_System/icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1200, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);
		setUndecorated(true);
		t1 = new Thread(this);
		t1.start();
	}

	public void run() {
		try {
			Thread.sleep(1000);
			this.setVisible(false);
			new LoginPage().setVisible(true);
		} catch (Exception e) {
			// Exception handling
		}
	}
}
