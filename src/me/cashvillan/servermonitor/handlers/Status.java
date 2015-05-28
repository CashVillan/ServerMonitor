package me.cashvillan.servermonitor.handlers;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import me.cashvillan.servermonitor.pinger.MinecraftPing;
import me.cashvillan.servermonitor.pinger.MinecraftPingOptions;
import me.cashvillan.servermonitor.pinger.MinecraftPingReply;

public class Status {
	
	public static HashMap<String, String> lastonline = new HashMap<String, String>();
	
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
			players = " / " + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax();
		} catch (IOException e) {
			players = "";
		}
		
		return players;
	}
	
	public static String getStatus(String name, String host, Integer port) {
		String status = "";
		if (get(host, port) == true) {
			lastonline.remove(name);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			lastonline.put(name, dateFormat.format(date));
			status = "online";
			System.out.println(name + " online");
		} else {
			if (!(lastonline.containsKey(name))) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				lastonline.put(name, dateFormat.format(date));
				status = onOnlineString(name, host, port) + " DOWNTIME";
				System.out.println(name + " offline");
			}
		}
		System.out.println("test2");
		return status;
	}
	
	public static Color statusColor(String name, String host, Integer port) {
		Color color = null;
		if (getStatus(name, host, port)  == "online") {
			color = Color.green;
		} else {
			color = Color.red;
		}
		
		return color;
	}
	
	public static String onOnlineString(String name, String host, Integer port) {
		String difference = "";
		
		if (get(host, port) == true) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  

			try {
				Date current = new Date();
				Date since = format.parse(lastonline.get(name));
				
				long diff = current.getTime() - since.getTime();
				long diffSeconds = diff / 1000 % 60;  
				long diffMinutes = diff / (60 * 1000) % 60;        
				long diffHours = diff / (60 * 60 * 1000); 
				
				if (diffHours != 0) {
					difference = diffHours + " hours";
				}
				if (diffMinutes != 0) {
					if (difference == diffHours + " hours") {
						difference = diffHours + " hours " + diffMinutes + " minutes"; 
					} else {
						difference = diffMinutes + " minutes";
					}
				}
				if (diffSeconds != 0) {
					if (difference == diffHours + " hours " + diffMinutes + " minutes") {
						difference = diffHours + " hours " + diffMinutes + " minutes " + diffSeconds + " seconds"; 
					
					} else if (difference == diffHours + " hours") {
						difference = diffHours + " hours " + diffSeconds + " seconds";
					
					} else if (difference == diffMinutes + " minutes") {
						difference = diffMinutes + " minutes " + diffSeconds + " seconds";
						
					} else {
						difference = diffSeconds + " seconds";
					}
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}  
		}
		return difference;
	}

}
