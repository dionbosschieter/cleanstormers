package org.saseros.cleanstorms.test;

import lejos.nxt.*;

public class SystemCheck {

	public static boolean motorCheck(NXTRegulatedMotor m) {
		int pos = m.getPosition();
		m.rotate(180);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m.getPosition() == pos) return false;
		m.rotate(pos);
		return true;
	}
	
	public void enginesCheck() {
		if(motorCheck(Motor.A))
			Alarm.createAlarmHard("UltraSonic sensor not connected!");
		if(motorCheck(Motor.B))
			Alarm.createAlarmHard("UltraSonic sensor not connected!");
		if(motorCheck(Motor.C))
			Alarm.createAlarmHard("UltraSonic sensor not connected!");
	}
	
	public void sensorCheck() {
		//defining and initializing all of the sensorinfo's
		I2CSensor infoUltrasonic = new I2CSensor(SensorPort.S1);
		TouchSensor t = new TouchSensor(SensorPort.S2);
		LightSensor ls = new LightSensor(SensorPort.S3);
		
		if(infoUltrasonic.getData(0, null, 0) != 0)
			Alarm.createAlarmHard("UltraSonic sensor not connected!");
		
		//this does'nt work, use user interaction
		if(t.isPressed())
			Alarm.createAlarmHard("Touch sensor not connected!");
		if(ls.readNormalizedValue() != 0)
			Alarm.createAlarmHard("Touch sensor not connected!");
	}
}
