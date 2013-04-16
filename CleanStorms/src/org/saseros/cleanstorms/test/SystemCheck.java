package org.saseros.cleanstorms.test;

import lejos.nxt.*;

public class SystemCheck {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public void enginecheck() {
		
	}
	
	public void sensorcheck() {
		//defining and initializing all of the sensorinfo's
		I2CSensor infoUltrasonic = new I2CSensor(SensorPort.S1);
		TouchSensor t = new TouchSensor(SensorPort.S2);
		LightSensor ls = new LightSensor(SensorPort.S3);
		
		if(infoUltrasonic.getData(0, null, 0) != 0)
			Alarm.createAlarm("UltraSonic sensor not connected!");
		
		//this does'nt work, use user interaction
		if(t.isPressed())
			Alarm.createAlarm("Touch sensor not connected!");
		if(ls.readNormalizedValue() != 0)
			Alarm.createAlarm("Touch sensor not connected!");
	}
}
