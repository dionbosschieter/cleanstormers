package org.saseros.cleanstorms;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

/**
 * This class is for simple handling with the sensors.
 * 
 * @author Pers
 * 
 */
public class Sensor {

	private UltrasonicSensor uss;
	private TouchSensor ts;
	private LightSensor ls;
	private int reactionDistanceHori;
	private int reactionDistanceVerti;

	/**
	 * Sets the sensor and other values used by the sensors.
	 * 
	 * @param floodlightOn
	 *            Indicates wether the floodlight on the LightSensor should be
	 *            on or not.
	 * @param reactionDistanceHori
	 *            Distance that the Ultrasonic Sensor should react to.
	 * @param reactionDistanceVerti
	 *            Distance that the LightSensor should react to.
	 */
	public Sensor(boolean floodlightOn, int reactionDistanceHori,
			int reactionDistanceVerti) {
		this.uss = new UltrasonicSensor(SensorPort.S1);
		this.ts = new TouchSensor(SensorPort.S2);
		this.ls = new LightSensor(SensorPort.S3, floodlightOn);
		this.reactionDistanceHori = reactionDistanceHori;
		this.reactionDistanceVerti = reactionDistanceVerti;
	}

	/**
	 * Method for fetching the UltrasonicSensor
	 * 
	 * @return Returns the UltrasonicSensor
	 */
	public UltrasonicSensor getUltrasonicSensor() {
		return uss;
	}

	/**
	 * Method for fetching the horizontal reaction distance
	 * 
	 * @return Returns the horizontal reaction distance
	 */
	public int getReactonDistanceHori() {
		return reactionDistanceHori;
	}

	/**
	 * Method for fetching the TouchSensor
	 * 
	 * @return Returns the TouchSensor
	 */
	public TouchSensor getTouchSensor() {
		return ts;
	}

	/**
	 * Checks for an obstacle with the Ultrasonic Sensor
	 * 
	 * @return Return false if an obstacle is not detected, and true if the
	 *         other way around.
	 */
	public boolean isObstacleDetected() {
		if (uss.getDistance() > reactionDistanceHori) {
			return false;
		}
		return true;
	}

	/**
	 * Checks for an obstacle with the Touch Sensor
	 * 
	 * @return Returns true if the an obstacle is detected, and false if the
	 *         other way around.
	 */
	public boolean isBumpDetected() {
		return ts.isPressed();
	}

	/**
	 * Checks if the ground is safe, specifically if the is an edge under the
	 * Light Sensor.
	 * 
	 * @return Returns true if the ground is safe, and false if the other way
	 *         around.
	 */
	public boolean isGroundValid() {
		if (ls.readValue() > (reactionDistanceVerti-2) && ls.readValue() < (reactionDistanceVerti+2)) {
			return true;
		}
		return false;
	}

	/**
	 * Intended for light-calibration
	 * You need to initiate this class first
	 */
	public void calibrateLight(){
		Alarm.showMessage("Put the robot on the floor");
		reactionDistanceVerti = ls.readValue();		
		Alarm.createAlarmSoft("Calibrated");	
	}

	/**
	 * <b>Intented for testing purposes only</b>
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Sensor sensor = new Sensor(true, 20, 30);
		while (!Button.ESCAPE.isDown()) {
			// Insert testing code here
		}
	}
}