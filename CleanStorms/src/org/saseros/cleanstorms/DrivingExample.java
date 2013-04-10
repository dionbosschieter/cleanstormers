package org.saseros.cleanstorms;

import lejos.nxt.*;

public class DrivingExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");
		
		Motor.A.setSpeed(Motor.A.getMaxSpeed());
		Motor.B.setSpeed(Motor.A.getMaxSpeed());
		
		Motor.A.forward();
		Motor.B.forward();
		
		Thread.sleep(6000);
		
		Motor.B.stop();
		Motor.A.stop();
		
		//test
	}

}
