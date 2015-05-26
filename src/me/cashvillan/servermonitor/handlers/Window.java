package me.cashvillan.servermonitor.handlers;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Window {

	public static void startWindow() {		
		JFrame frame = new JFrame("SwingSword Server Monitor");
		for (Server s : ServerManager.servers) {
			JLabel label = new JLabel(Status.getStatus(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setForeground(Color.WHITE);
			frame.add(label);
		}
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}
}
