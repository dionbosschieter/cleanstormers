package org.saseros.cleanstorms;

import lejos.nxt.I2CSensor;

public class UltraSonicCheck implements Runnable {
	
	private I2CSensor us;
	private int seconds;
	
	/**
	 * Constructor for initializing the private variables 
	 * 
	 * @param us
	 * @param seconds
	 */
	UltraSonicCheck(I2CSensor us, int seconds) {
		this.us = us;
		this.seconds = seconds;
	}
	
	/**
	 * Main method that will be called once the thread starts 
	 */
	public void run() {
		while(sleep()) {
			if(!SystemCheck.checkSensor(us)) 
				Alarm.createAlarmHard("UltraSonic sensor not Connected");
		}
	}
	
	/**
	 * Sleep method to use in the while loop
	 * 
	 * @return	true if sleep is succesful 
	 * 			and false if a exception occured
	 */
	private boolean sleep() {
		try {
			Thread.sleep(1000*seconds);
			return true;
		}	catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}