package org.saseros.cleanstorms;

import lejos.nxt.*;

public class Alarm {

	/**
	 * Print string on the screen and play a beep
	 * And waiting for someone pushing the button.
	 * 
	 * @param error
	 *            String that will be written out on the screen
	 */
	public static void createAlarmSoft(String error) {
		LCD.clear();
		System.out.println(error);
		playAlarm();
		Button.waitForAnyPress();
	}
	
	/**
	 * Print string on the screen and play the alarm
	 * And wait for a button to be pressed. 
	 * 
	 * @param error
	 *            String that will be written out on the screen
	 * @param robot
	 *            Robot object, for stopping the motors.
	 */
	public static void createAlarmHard(String error, Robot robot) {
		Robot.safeState = true;
		robot.getPilot().stop();
		
		LCD.clear();
		System.out.println(error);
		playAlarm();
		Button.waitForAnyPress();
		
		SystemCheck syscheck = new SystemCheck(SensorPort.S1, 
				SensorPort.S2, SensorPort.S3, 6.5f);
		syscheck.preform();
		Robot.safeState = false;
	}
	
	/**
	 * Show a message on the screen
	 * 
	 * @param error
	 *            String that will be written out on the screen
	 */
	public static void showMessage(String error) {
		LCD.clear();
		System.out.println(error);
		Button.waitForAnyPress();
	}
	
	/**
	 * Set the volume to max and play ascending arpeggio
	 */
	public static void playAlarm() {
		Sound.setVolume(Sound.VOL_MAX);
		Sound.systemSound(true, 3);
	}
	
	/**
	 * Set the volume to max and play a beep
	 */
	public static void playBeep(){
		Sound.setVolume(Sound.VOL_MAX);
		Sound.beep();
	}
	
}
