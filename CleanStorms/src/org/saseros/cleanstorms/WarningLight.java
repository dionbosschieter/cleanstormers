package org.saseros.cleanstorms;

import lejos.nxt.SensorPort;

public class WarningLight extends Thread {
	
	private int seconds;
	
	WarningLight(int countseconds) {
		this.seconds = countseconds;
	}
	
	public void run() {
		while(true) {
			SensorPort.S4.setPowerType(2);
			sleep();
			SensorPort.S4.setPowerType(0);
			sleep();
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(1000*seconds);
		}	catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
