package org.saseros.cleanstorms;

import java.util.Random;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;
import lejos.robotics.objectdetection.TouchFeatureDetector;

/**
 * This class is for handling the robot and various movements when the sensor
 * reacts
 * 
 * @author Pers
 * 
 */
public class Robot {

	private Sensor sensor;
	private DifferentialPilot pilot;
	private Navigator navigator;
	private RangeFeatureDetector fd;
	private TouchFeatureDetector tfd;
	private Random random;

	private int turn = -15;
	private int recursiveDepth = 0;

	private final int RESPONSE_TIME_ULTRASONIC = 700;

	/**
	 * The constructor sets the sensors, events, and various variables used by
	 * this class for movement-handling
	 * 
	 * @param sensor
	 *            An object of the class Sensor must be put in to initiate a
	 *            Robot-object
	 * @param pilot
	 * @param navigator
	 */
	public Robot(Sensor sensor, DifferentialPilot pilot, Navigator navigator) {
		this.sensor = sensor;
		this.pilot = pilot;
		this.navigator = navigator;
		this.fd = new RangeFeatureDetector(sensor.getUltrasonicSensor(),
				-sensor.getReactonDistanceHori(), RESPONSE_TIME_ULTRASONIC);
		addUltrasonicListener();
		this.tfd = new TouchFeatureDetector(sensor.getTouchSensor());
		addTouchSensorListener();
		this.random = new Random();

		pilot.setMinRadius(15); // Radius for turns

	}

	/**
	 * A recursive method that checks for obstacles numerous times, moves the
	 * Ultrasonic Sensor around and checks again. If a obstacle is detected it
	 * locks on to that obstacle until it moves, or recursive depth reaches
	 * maximum value(246), if no object is detected it will return true.
	 * 
	 * @deprecated
	 * @return Returns a boolean-value, false, to indicate that the path is not
	 *         clear, or true, to indicate the path is ready to go.
	 */
	public boolean isPathClear() {
		recursiveDepth++;
		if (recursiveDepth >= 246) {
			atEndOfPathIsDetected();
			System.out.println("Path not clear");
			return false;
		}
		if (sensor.isObstacleDetected()) {
			return isPathClear();
		}
		Motor.B.rotate(turn);
		System.out.println("Surveying");
		if (Motor.B.getTachoCount() <= -45) {
			turn = +15;
			return isPathClear();
		} else if (Motor.B.getTachoCount() >= 45) {
			System.out.println("Done Surveying!");
			atEndOfPathIsDetected();
			return true;
		} else {
			return isPathClear();
		}
	}

	/**
	 * Help-method for the method isPathClear(), sets every modified value back
	 * to its default.
	 */
	private void atEndOfPathIsDetected() {
		moveUltrasonicSensorToDefaultPosition();
		recursiveDepth = 0;
		turn = -15;
	}

	/**
	 * Moves the motor-arm back to default position(0), which is the position
	 * the arm was located at software boot-up. This position must be set
	 * manually before boot-up.
	 */
	private void moveUltrasonicSensorToDefaultPosition() {
		Motor.B.rotateTo(0);
	}

	/**
	 * @return the pilot
	 */
	public DifferentialPilot getPilot() {
		return pilot;
	}

	/**
	 * @return the navigator
	 */
	public Navigator getNavigator() {
		return navigator;
	}

	/**
	 * @return the sensor
	 */
	public Sensor getSensor() {
		return sensor;
	}

	/**
	 * In this method goes code that is suppeosed to executed when the
	 * UltrasonicSensor detecs an obstacle
	 * 
	 * @param feature
	 *            Default value that must be implemented, not really usedfor
	 *            anything
	 * @param detector
	 *            Default value that must be implemented, not really usedfor
	 *            anything
	 */
	private void handleOnUltrasonicDetection(Feature feature,
			FeatureDetector detector) {
		this.getPilot().arc(generateRadius(),
				20 + (int) (Math.random() * ((90 - 20) + 1)));
	}

	/**
	 * Used in the constructor to add an Event to the UltrasonicSensor
	 */
	private void addUltrasonicListener() {
		this.fd.addListener(new FeatureListener() {
			@Override
			public void featureDetected(Feature feature,
					FeatureDetector detector) {
				handleOnUltrasonicDetection(feature, detector);
			}
		});
	}

	/**
	 * Used in the constructor to add an Event to the TouchSensor, might not be
	 * implemented in the final product due to conflicts with threads
	 */
	private void addTouchSensorListener() {
		this.tfd.addListener(new FeatureListener() {
			@Override
			public void featureDetected(Feature feature,
					FeatureDetector detector) {
				// Add code here
			}
		});
	}

	/**
	 * A help-method to generate the radius the robot moves in by a coin-flip
	 * 
	 * @return 15.0 or -15.0 depending on the outcome of the coinflip
	 */
	private double generateRadius() {
		if (random.nextBoolean()) {
			return 15.0;
		} else {
			return -15.0;
		}
	}

	/**
	 * For testing purposes only.
	 * 
	 * @param args
	 */
	// public static void main(String[] args) {
	// Sensor sensor = new Sensor(true, 20, 30);
	// Robot robot = new Robot(sensor);
	// System.out.println("Method returns: " + robot.isPathClear());
	// // robot.isPathClear();
	// Button.waitForAnyPress();
	// // while(!Button.ESCAPE.isDown()){
	//
	// // }
	//
	// }
}