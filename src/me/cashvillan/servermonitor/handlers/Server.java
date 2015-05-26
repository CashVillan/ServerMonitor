package me.cashvillan.servermonitor.handlers;

public class Server {
	
	public String name;
	public String host;
	public Integer port;
	
	public Server(String name, String host, Integer port) {
		this.name = name;
		this.host = host;
		this.port = port;
		
		ServerManager.servers.add(this);
	}

}
