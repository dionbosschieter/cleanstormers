package org.saseros.cleanstorms.test;
//import org.saseros.cleanstorms.Alarm;

import lejos.nxt.*;

public class Light {

	static LightSensor lss = new LightSensor(SensorPort.S3);
	
	public static void main(String[] args) {
		
		lightReadFloor();
		lightReadLine();		
	
	}
		

		public static void lightReadFloor(){
			int floorLight = SensorPort.S3.readValue();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Alarm.playBeep();
			LCD.clear();
			LCD.drawString("Floor value:", 0, 0);
			LCD.drawInt(floorLight, 0, 4);
			Button.waitForAnyPress();
		}

		public static void lightReadLine(){
			int lineLight = lss.getNormalizedLightValue();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Alarm.playBeep();
			LCD.clear();
			System.out.println("Line value");
			LCD.drawInt(lineLight, 0, 8);
			Button.waitForAnyPress();
		}
		
	   public static int getCalibratedValue() { 
		      //return readValue(); 
		   	  lss.setFloodlight(true);
		      int hundred = lss.getHigh();
		      int zero = lss.getLow();
		      if(hundred == zero) return 0;
		      return 100 * (SensorPort.S3.readRawValue() - zero) / (hundred - zero); 
		   }

	}


