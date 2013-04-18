package org.saseros.cleanstorms;

import lejos.nxt.SensorPort;

public class WarningLight extends Thread {
	
	private int seconds;
	
	/**
	 * Constructor for initializing the private variables
	 * 
	 * @param seconds
	 *            seconds to sleep in the while loop
	 */
	WarningLight(int seconds) {
		this.seconds = seconds;
	}
	
	/**
	 * Main method that will be called once the thread starts 
	 */
	public void run() {
		while(true) {
			SensorPort.S4.setPowerType(2);
			sleep();
			SensorPort.S4.setPowerType(0);
			sleep();
		}
	}
	
	/**
	 * Sleep method to use in the while loop
	 */
	private void sleep() {
		try {
			Thread.sleep(1000*seconds);
		}	catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
