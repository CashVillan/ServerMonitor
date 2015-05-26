package me.cashvillan.servermonitor.handlers;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Window {

	public static void startWindow() {		
		JFrame frame = new JFrame("Server Monitor");
		for (Server s : ServerManager.servers) {
			JLabel label = new JLabel(Status.getStatus(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setForeground(Status.statusColor(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setAlignmentY(Component.TOP_ALIGNMENT);
			frame.add(label);
		}
		JButton addServersButton = new JButton("Add Servers");
		frame.add(addServersButton, BorderLayout.SOUTH);
		frame.pack();
		
		frame.setSize(350, 1080);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
