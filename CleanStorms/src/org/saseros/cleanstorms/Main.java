package org.saseros.cleanstorms;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

/**
 * The main-class that executes the software that makes the robot move
 * 
 * @author Pers
 * 
 */
public class Main {

	private Robot robot;

	/**
	 * The constructor sets the needed values and exeutes the movement of the
	 * robot, so it moves in the main method once a object of Main is created
	 * 
	 * @param robot
	 *            Takes a object of Robot as an argument since it needs the
	 *            handling in that class to know how to execute movements
	 */
	public Main(Robot robot) {
		this.robot = robot;

		while (true) {
			if(Robot.safeState) continue;
			robot.getPilot().forward();

			while (robot.getPilot().isMoving()) {
				if(!robot.getSensor().isGroundValid()){
					robot.moveBackward();
				}

//				

			}
		}
	}

	/**
	 * The method that executes the software that makes the robot run
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		SystemCheck syscheck = new SystemCheck(SensorPort.S1, 
				SensorPort.S2, SensorPort.S3, 6.5f);
		syscheck.preform();
		
		WarningLight wLight = new WarningLight(2);
		wLight.start();
		
		Sensor sensor = new Sensor(true, 80, 40);

		DifferentialPilot pilot = new DifferentialPilot(5.6F, 5.6F, 14F,
				Motor.A, Motor.C, false);

		Navigator navigator = new Navigator(pilot);

		Robot robot = new Robot(sensor, pilot, navigator);
		
		ContinousCheck cCheck = new ContinousCheck(SensorPort.S1,
				2, 6.5f, robot);
		cCheck.start();

		navigator.getPoseProvider().getPose().setLocation(0, 0);

		Main main = new Main(robot);
	}

}
