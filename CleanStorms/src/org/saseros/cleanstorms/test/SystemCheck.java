package org.saseros.cleanstorms.test;

import javax.microedition.sensor.LightSensorInfo;
import javax.microedition.sensor.TouchSensorInfo;
import lejos.nxt.*;

public class SystemCheck {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		//defining and initializing all of the sensorinfo's
		I2CSensor infoUltrasonic = new I2CSensor(SensorPort.S1);
		TouchSensorInfo infoTouch = new TouchSensorInfo();
		LightSensorInfo infoInputLight = new LightSensorInfo();
		
		infoTouch.setPortNumber(SensorPort.S2.getId());
		infoInputLight.setPortNumber(SensorPort.S3.getId());
		
		while(true){
			Thread.sleep(2000);
			
			if(infoUltrasonic.getData(0, null, 0) != 0)
				Alarm.createAlarm("UltraSonic sensor not connected!");
			if(!infoTouch.isAvailable())
				Alarm.createAlarm("Touch sensor not connected!");
			if(!infoInputLight.isAvailable())
				Alarm.createAlarm("Touch sensor not connected!");
		}
	}
}
