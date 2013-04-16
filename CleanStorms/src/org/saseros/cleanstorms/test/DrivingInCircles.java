package org.saseros.cleanstorms.test;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;


public class DrivingInCircles {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LCD.drawString("Program 1", 0,0);
		Button.waitForAnyPress();
		LCD.clear();

		Motor.A.setSpeed(Motor.A.getMaxSpeed());
		Motor.B.setSpeed(Motor.A.getMaxSpeed());
		//FORWARD
		Motor.A.forward();
		Motor.B.forward();
		LCD.drawString("FORWARD", 0,0);
		Thread.sleep(3000);
		/*Button.waitForAnyPress();*/
		/*Turning right*/
		Motor.A.stop();
		Motor.B.forward();
		LCD.drawString("TURNING RIGHT", 0, 0);
		Thread.sleep(500);
		
		//FORWARD
		
		Motor.A.forward();
		Motor.B.forward();
		LCD.drawString("FORWARD", 0,0);
		Thread.sleep(3000);
		//TURNING RIGTH
		Motor.A.stop();
		Motor.B.forward();
		LCD.drawString("TURNING RIGHT", 0, 0);
		Thread.sleep(500);
		//FORWARD
		
		Motor.A.forward();
		Motor.B.forward();
		LCD.drawString("FORWARD", 0,0);
		Thread.sleep(3000);
		//TURNING RIGTH
		Motor.A.stop();
		Motor.B.forward();
		LCD.drawString("TURNING RIGHT", 0, 0);
		Thread.sleep(500);
		//FORWARD
		
		Motor.A.forward();
		Motor.B.forward();
		LCD.drawString("FORWARD", 0,0);
		Thread.sleep(3000);
		//TURNING RIGTH
		Motor.A.stop();
		Motor.B.forward();
		LCD.drawString("TURNING RIGHT", 0, 0);
		Thread.sleep(500);
		
		
		/*Button.waitForAnyPress();*/
		Motor.A.stop();
		Motor.B.stop();
		

	}

}
