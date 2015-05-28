package me.cashvillan.servermonitor;

import me.cashvillan.servermonitor.handlers.ServerManager;
import me.cashvillan.servermonitor.handlers.Window;

public class Main extends Thread {
	
	public static void main(String[] args) {
		Window.startWindow();
		new ServerManager();
	}
}