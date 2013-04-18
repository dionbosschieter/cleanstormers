package org.saseros.cleanstorms;

import lejos.nxt.*;

public class ContinousCheck extends Thread {
	
	private I2CSensor us;
	private int seconds;
	private float lowLevel;
	
	/**
	 * Constructor for initializing the private variables 
	 * 
	 * @param us
	 * @param seconds
	 */
	public ContinousCheck(SensorPort ussPort, int seconds, float lowLevel) {
		this.us = new I2CSensor(ussPort);;
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