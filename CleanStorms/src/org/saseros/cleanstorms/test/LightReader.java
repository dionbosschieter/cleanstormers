package org.saseros.cleanstorms.test;
import org.saseros.cleanstorms.Alarm;

import lejos.nxt.*;

/*
 * This is the light sensing implementation for the navigation of the robot. 
 * It has to run as a thread because it is always checking for the line.
 * 
 */

public class LightReader implements Runnable  {

	static LightSensor lss = new LightSensor(SensorPort.S3);
	
		public static boolean lightReadFloor(){
			int floorLight 		= lss.readValue();
			boolean x = lightValueCheck(floorLight);
			return x;
		}

		public static boolean lightReadLine(){
			int lineLight = SensorPort.S3.readValue();
			Alarm.playBeep();
			boolean y = lightValueCheck(lineLight);
			return y;
			
		}
		
		public static boolean lightValueCheck(int lv){
			return (lv < lv+1 && lv > lv-1);
		}

		@Override
		public void run() {
			while(sleep()){
				if(lightReadLine())
					//put here the turning sequence
			}		
		}
		
		private boolean sleep() {
			try {
				Thread.sleep(1000);
				return true;
			}	catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
		}
}

