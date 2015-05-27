package me.cashvillan.servermonitor.handlers;

import java.util.ArrayList;

public class ServerManager {
	
	public static ArrayList<Server> servers = new ArrayList<Server>();
	
	public ServerManager() {
		new Server("minetheft", "play.minetheft.com", 25565);
		new Server("rustmc", "play.therustmc.com", 25565);
		new Server("rustmc", "play.therustmc.com", 25565);
	}
	
	public static Server getServer(String name) {
		for(Server all : servers) {
			if (all.name.equals(name)) {
				return all;
			}
		}
		return null;
	}
	
	public static String getHost(String name) {
		String host = null;
		try {
			for (Server all : servers) {
				if (all.name.equals(name)) {
					host = all.host;
					return host;
				}
			}
		} 
		catch(Exception e) {
			String error = "ERROR";
			return error;
		}
		return null;
	}
	
	public static Integer getPort(String name) {
		Integer port = null;
		try {
			for (Server all : servers) {
				if (all.name.equals(name)) {
					port = all.port;
					return port;
				}
			}
		} 
		catch(Exception e) {
			return null;
		}
		return null;
	}
}
