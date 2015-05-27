package me.cashvillan.servermonitor;

import me.cashvillan.servermonitor.handlers.ServerManager;
import me.cashvillan.servermonitor.handlers.Window;

public class Main {
	
	public static void main(String[] args) {
		new ServerManager();
		Window.startWindow();
	}
	
}