package org.saseros.cleanstorms.test;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class NavigationTest {
	
//	DifferentialPilot pilot;
//	
//	public void Go(){
//		pilot.travel(20, true);
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub s
		
		// Make sure the parameters in this constructor match your vehicle.
//		ArcMoveController p = new SteeringPilot(5.6f, Motor.A, Motor.C, 41, -33, 40);
		
		// Alternate code to simulate a steering vehicle of steering radius 40 cm:
		DifferentialPilot p = new DifferentialPilot(5.6F, 5.6F, 14F, Motor.A, Motor.C, false);
		TouchSensor bump = new TouchSensor(SensorPort.S2);
		UltrasonicSensor uss = new UltrasonicSensor(SensorPort.S1);
		p.setMinRadius(5);
		
		Navigator c = new Navigator(p);
		c.getPoseProvider().getPose().setLocation(0, 0);
		
		
		
		
		
		uss.continuous();
		
		while(true){
			p.forward();
			
			System.out.println("X: " + c.getPoseProvider().getPose().getX() + " - Y: " + c.getPoseProvider().getPose().getY());
			
			while(p.isMoving()){
				int lastDistance = uss.getDistance();

				if (bump.isPressed()){
					// Move backward routine
					p.stop();
					
					p.backward();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					p.rotate(90 + (int)(Math.random() * ((180 - 90) + 1)));
					p.setTravelSpeed(p.getMaxTravelSpeed());
					break;
					
				}
				
				if(lastDistance < 60){
					
					p.arc(20, 90 + (int)(Math.random() * ((180 - 90) + 1)));
					
					break;
				}
				
				/* Limit the area */
				
				if(c.getPoseProvider().getPose().getX() > 500){
					p.stop();
				}
				if(c.getPoseProvider().getPose().getY() > 500){
					p.stop();
				}
				
				
			}
		}
		
		
		
//		// To retrieve the coordinates and heading, access the PoseProvider: 
//		Pose pose = c.getPoseProvider().getPose();
//		System.out.println("x=" + pose.getX() + " y=" + pose.getY() + " H=" + pose.getHeading());
//		c.addWaypoint(0, 0);
//		c.addWaypoint(0, 150);
//		c.addWaypoint(150, 150);
//		c.addWaypoint(150, 0);
//		c.addWaypoint(0, 0);
//
//		c.followPath();
//		
//		c.waitForStop();
//		Sound.beep();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}
//		
//		pose = c.getPoseProvider().getPose();
//		System.out.println("x=" + pose.getX() + " y=" + pose.getY() + " H=" + pose.getHeading());
//		
//		c.goTo(new Waypoint(0, 60, 0));
//		c.waitForStop();
//		Sound.beep();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//				
//		pose = c.getPoseProvider().getPose();
//		System.out.println("x=" + pose.getX() + " y=" + pose.getY() + " H=" + pose.getHeading());
//		
//		Waypoint dest = new Waypoint(0, 70, 0);
//		c.goTo(dest);
//		c.waitForStop();
//		Sound.beep();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		pose = c.getPoseProvider().getPose();
//		System.out.println("x=" + pose.getX() + " y=" + pose.getY() + " H=" + pose.getHeading());
//		
//		dest = new Waypoint(0, 80, 0);
//		c.goTo(dest);
//		c.waitForStop();
//		Sound.beep();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		pose = c.getPoseProvider().getPose();
//		System.out.println("x=" + pose.getX() + " y=" + pose.getY() + " H=" + pose.getHeading());

//		Button.ESCAPE.waitForPressAndRelease();
		

	}

}
