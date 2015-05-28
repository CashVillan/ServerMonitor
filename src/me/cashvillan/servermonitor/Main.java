package me.cashvillan.servermonitor;

import me.cashvillan.servermonitor.handlers.ServerManager;
import me.cashvillan.servermonitor.handlers.Window;

public class Main extends Thread {
	
	public static void main(String[] args) {
		new ServerManager();
		while(true) {
			Window.startWindow();
			try{Thread.sleep(5000);} 
	          catch(Exception e){}
	    } 
	}
}