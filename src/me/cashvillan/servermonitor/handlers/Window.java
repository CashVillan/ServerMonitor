package me.cashvillan.servermonitor.handlers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	}

	public static void startWindow() {	
		JFrame frame = new JFrame("Server Monitor");
		for (Server s : ServerManager.servers) {
			JLabel label = new JLabel(Status.getStatus(s.name + " ", (ServerManager.getHost(s.name), ServerManager.getPort(s.name)).toUpperCase());
			label.setFont(new Font(Font.SERIF, Font.TRUETYPE_FONT, 19));
			label.setForeground(Status.statusColor(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		addServersButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		addServersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(addServersButton);
		frame.add(Box.createVerticalStrut(10));
	}
	
	public static void addServersWindow(JFrame frame) {
		getSettings(frame);
	}
	
	public static void addServers(JFrame frame) {
		for (Server s : ServerManager.servers) {
			JLabel label = new JLabel(Status.getStatus(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
			label.setForeground(Status.statusColor(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
		}
	}
	
}
