package org.saseros.cleanstorms;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class Main {

	private Robot robot;

	public Main(Robot robot) {
		this.robot = robot;

		while (true) {
			robot.getPilot().forward();

			while (robot.getPilot().isMoving()) {

				/* Limit the area to 3m2 */
				if (robot.getNavigator().getPoseProvider().getPose().getX() > 150
						|| robot.getNavigator().getPoseProvider().getPose()
								.getX() < -150
						|| robot.getNavigator().getPoseProvider().getPose()
								.getY() > 150
						|| robot.getNavigator().getPoseProvider().getPose()
								.getX() < -150) {
					robot.getPilot().arc(10, 180);
					robot.getPilot().forward();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

				if (robot.getSensor().isBumpDetected()) {
					// Move backward routine
					robot.getPilot().backward();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					robot.getPilot().rotate(90 + (int)(Math.random() * ((180 - 90) + 1)));
					robot.getPilot().forward();
					break;

				}

				if (robot.getSensor().isObstacleDetected()) {
					robot.getPilot().arc(15,
							90 + (int) (Math.random() * ((180 - 90) + 1)));
				}

			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sensor sensor = new Sensor(true, 60, 30);

		DifferentialPilot pilot = new DifferentialPilot(5.6F, 5.6F, 14F,
				Motor.A, Motor.C, false);

		Navigator navigator = new Navigator(pilot);

		Robot robot = new Robot(sensor, pilot, navigator);

		navigator.getPoseProvider().getPose().setLocation(0, 0);

		Main main = new Main(robot);

	}

}
