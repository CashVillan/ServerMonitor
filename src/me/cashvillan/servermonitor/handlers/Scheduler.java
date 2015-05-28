package me.cashvillan.servermonitor.handlers;

public abstract class Scheduler implements Runnable {
	
	
	
}

// /*for (Server s : ServerManager.servers) {
//	JLabel label = new JLabel(s.name.toUpperCase() + " / " + Status.getStatus(s.name, ServerManager.getHost(s.name), ServerManager.getPort(s.name)).toUpperCase() + " " + Status.getPlayers(ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
//	label.setFont(new Font(Font.SERIF, Font.TRUETYPE_FONT, 19));
//	label.setForeground(Status.statusColor(s.name, ServerManager.getHost(s.name), ServerManager.getPort(s.name)));
//	label.setAlignmentX(Component.LEFT_ALIGNMENT);
//	label.setAlignmentY(Component.LEFT_ALIGNMENT);
//	frame.add(label);
//	frame.add(Box.createVerticalStrut(1));
//	SwingUtilities.updateComponentTreeUI(frame);
//}
