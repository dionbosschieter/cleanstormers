package org.saseros.cleanstorms;

import lejos.nxt.I2CSensor;

public class UltraSonicCheck implements Runnable {
	
	private I2CSensor us;
	private int seconds;
	private float lowLevel;
	
	/**
	 * Constructor for initializing the private variables 
	 * 
	 * @param us
	 * @param seconds
	 */
	UltraSonicCheck(I2CSensor us, int seconds, float lowLevel) {
		this.us = us;
		this.seconds = seconds;
		this.lowLevel = lowLevel;
	}
	
	/**
	 * Main method that will be called once the thread starts 
	 */
	public void run() {
		while(sleep()) {
			if(!SystemCheck.checkSensor(us)) 
				Alarm.createAlarmHard("UltraSonic sensor not Connected");
			if(!SystemCheck.checkBatteryLevel(lowLevel))
				Alarm.createAlarmHard("Batterylevel to low");
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