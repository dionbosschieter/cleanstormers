package org.saseros.cleanstorms;

import lejos.nxt.*;

public class Alarm {

	/**
	 * Print string on the screen and play a beep
	 * without waiting for someone pushing the button.
	 * 
	 * @param error
	 */
	public static void createAlarmSoft(String error) {
		LCD.clear();
		System.out.println(error);
		playBeep();
	}
	
	private static void stopEngines() {
		Motor.A.stop();
		Motor.B.stop();
	}
	
	/**
	 * Print string on the screen and play the alarm
	 * And wait for a button to be pressed. 
	 * 
	 * @param error
	 */
	public static void createAlarmHard(String error) {
		Robot.safeState = true;
		stopEngines();
		
		LCD.clear();
		System.out.println(error);
		playAlarm();
		Button.waitForAnyPress();
		
		Robot.safeState = false;
	}
	
	/**
	 * Show a message on the screen
	 * 
	 * @param error
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
