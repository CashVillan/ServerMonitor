package me.cashvillan.servermonitor.handlers;

import java.awt.Color;
import java.io.IOException;

import me.cashvillan.servermonitor.pinger.MinecraftPing;
import me.cashvillan.servermonitor.pinger.MinecraftPingOptions;
import me.cashvillan.servermonitor.pinger.MinecraftPingReply;

public class Status {
	
	public static boolean get(String host, Integer port) {
		try {
			MinecraftPingReply data = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname(host).setPort(port));
			System.out.println(data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
			System.out.println("true");
			return true;
		} catch (IOException e) {
			System.out.println("false");
			return false;
		}
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
		if (getStatus(host, port) == "online") {
			color = Color.green;
		} else {
			color = Color.red;
		}
		
		return color;
	}

}
