package org.saseros.cleanstorms.test;

import lejos.nxt.*;

public class DrivingExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello, Cleanstormers");
		
		TouchSensor bump = new TouchSensor(SensorPort.S2);
		
		Motor.A.setSpeed(Motor.A.getMaxSpeed());
		Motor.C.setSpeed(Motor.A.getMaxSpeed());
		
		Motor.A.forward();
		Motor.C.forward();
		
		
		
		while (true) {
		      if (bump.isPressed()){
		    	  Motor.A.stop();
		    	  Motor.C.stop();
		    	  
		    	  Thread.sleep(1000);
		    	  
		    	  Motor.A.backward();
		  		  Motor.C.backward();
		  		  
		  		  Thread.sleep(1000);
		  		  
		  		  Motor.A.stop();
		    	  Motor.C.stop();
		  		  
		  		  int rotationAngle = 20 + (int)(Math.random() * ((90 - 20) + 1));
		  		  
		  		  System.out.println(rotationAngle);
		    	  
		    	  Motor.C.rotateTo(rotationAngle);
		    	  
		    	  Motor.C.stop();
		    	  
		    	  Motor.A.forward();
		  		  Motor.C.forward();
		      }else{
//		    	  System.exit(0);
		      }
		    }
		
		//test
	}

}
