package me.cashvillan.servermonitor.handlers;

import java.awt.Color;
import java.io.IOException;

import me.cashvillan.servermonitor.pinger.MinecraftPing;
import me.cashvillan.servermonitor.pinger.MinecraftPingOptions;
import me.cashvillan.servermonitor.pinger.MinecraftPingReply;

public class Status {
	
	public static boolean get(String host, Integer port) {
		try {
			@SuppressWarnings("unused")
			MinecraftPingReply data = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname(host).setPort(port));
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	public static String getPlayers(String host, Integer port) {
		String players = "";
		try {
			MinecraftPingReply data = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname(host).setPort(port));
			players = data.getPlayers().getOnline() + "/" + data.getPlayers().getMax();
		} catch (IOException e) {
			players = "";
		}
		
		return players;
	}
	
	public static String getStatus(String host, Integer port) {
		String status = "";
		if (get(host, port) == true) {
			status = "online";
		} else {
			status = "offline";
		}
		return status;
	}
	
	public static Color statusColor(String host, Integer port) {
		Color color = null;
		if ((getStatus(host, port)  == "online")) {
			color = Color.green;
		} else {
			color = Color.red;
		}
		
		return color;
	}

}
