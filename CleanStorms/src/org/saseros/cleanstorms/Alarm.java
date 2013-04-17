package org.saseros.cleanstorms;

import lejos.nxt.*;

public class Alarm {

	public static void createAlarmSoft(String error) {
		LCD.clear();
		System.out.println(error);
		playBeep();
	}
	
	public static void createAlarmHard(String error) {
		LCD.clear();
		System.out.println(error);
		playAlarm();
		Button.waitForAnyPress();
		
	}
	public static void showMessage(String error) {
		LCD.clear();
		System.out.println(error);
		Button.waitForAnyPress();
	}
	
	public static void playAlarm() {
		Sound.setVolume(Sound.VOL_MAX);
		Sound.systemSound(true, 3);
	}
	
	public static void playBeep(){
		Sound.setVolume(Sound.VOL_MAX);
		Sound.beep();
	}
	
}
