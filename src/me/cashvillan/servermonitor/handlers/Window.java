package me.cashvillan.servermonitor.handlers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Window {
	
	public static void getSettings(JFrame frame) {
		frame.setSize(350, 1080);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void startWindow() {		
		JFrame frame = new JFrame("Server Monitor");
		for (Server s : ServerManager.servers) {
			JLabel label = new JLabel(Status.getStatus(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setForeground(Status.statusColor(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setAlignmentY(Component.TOP_ALIGNMENT);
			frame.add(label);
		}
		addButtons(frame);
		getSettings(frame);
	}
	
	private static void addButtons(final JFrame frame) {
		JButton addServersButton = new JButton("Add Servers");
		addServersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addServersWindow(frame);
				return;
			}
		});
		frame.add(addServersButton, BorderLayout.SOUTH);
	}
	
	public static void addServersWindow(JFrame frame) {
		getSettings(frame);
	}
	
}
