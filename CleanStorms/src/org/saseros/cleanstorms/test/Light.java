package org.saseros.cleanstorms.test;
import org.saseros.cleanstorms.Alarm;

import lejos.nxt.*;

public class Light {

	static LightSensor lss = new LightSensor(SensorPort.S3);
	
	public static void main(String[] args) {
		while(true){
			lightReadFloor();
			lightReadLine();
			//break Button.waitForAnyPress();
		}
	}
		

		public static void lightReadFloor(){
			int floorLight 		= lss.readValue();
			int floorLightRaw 	= lss.getNormalizedLightValue();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Alarm.playBeep();
			boolean x = lightValueCheck(floorLight);
			LCD.clear();
			LCD.drawInt(floorLight, 0, 0);
			LCD.drawInt(floorLightRaw, 0, 1);
			if(x)
				LCD.drawString("on floor", 0, 2);
			else
				LCD.drawString("not on floor", 0, 2);
			Button.waitForAnyPress();
		}

		public static void lightReadLine(){
			int lineLight = SensorPort.S3.readValue();
			int lineLightRaw 	= lss.getNormalizedLightValue();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Alarm.playBeep();
			boolean y = lightValueCheck(lineLight);
			LCD.clear();
			LCD.drawInt(lineLight, 0, 0);
			LCD.drawInt(lineLightRaw, 0, 1);
			if(y)
				LCD.drawString("on line", 0, 2);
			else
				LCD.drawString("not on line", 0, 2);
			Button.waitForAnyPress();
		}
		
		public static boolean lightValueCheck(int lv){
			return (lv < lv+1 && lv > lv-1);
		}
		
		public static int lineCheck(int lineC){
			if(lineC < lineC++ && lineC > lineC--){
				return 1;
			}
			else{
				return 0;
			}
			
		}

	}


