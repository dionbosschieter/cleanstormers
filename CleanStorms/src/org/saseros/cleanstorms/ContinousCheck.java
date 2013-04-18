package org.saseros.cleanstorms;

import lejos.nxt.*;

/**
 * 
 * @author Pers
 *
 */
public class ContinousCheck extends Thread {
	
	private I2CSensor us;
	private int seconds;
	private float lowLevel;
	private Robot robot;
	
	/**
	 * Constructor for initializing the private variables
	 * 
	 * @param ussPort
	 *            UltraSonic sensor port
	 * @param seconds
<<<<<<< HEAD
	 *            seconds to sleep in the while loop
	 * @param lowLevel
	 *            Battery low level threshold
	 * @param robot
	 *            Robot object, for the stopping of the motors.
=======
	 * @lowLevel
	 * @param robot
>>>>>>> branch 'master' of https://github.com/dionbosschieter/cleanstormers.git
	 */
	public ContinousCheck(SensorPort ussPort, int seconds, float lowLevel, Robot robot) {
		this.us = new I2CSensor(ussPort);;
		this.seconds = seconds;
		this.lowLevel = lowLevel;
		this.robot = robot;
	}
	
	/**
	 * Main method that will be called once the thread starts 
	 */
	public void run() {
		while(sleep()) {
			if(!SystemCheck.checkSensor(us)) 
				Alarm.createAlarmHard("UltraSonic sensor not Connected", robot);
			if(!SystemCheck.checkBatteryLevel(lowLevel))
				Alarm.createAlarmHard("Batterylevel to low", robot);
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
