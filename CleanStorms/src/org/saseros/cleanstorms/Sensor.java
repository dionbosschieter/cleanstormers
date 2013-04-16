package org.saseros.cleanstorms;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class Sensor {

	private UltrasonicSensor uss;
	private TouchSensor ts;
	private LightSensor ls;
	private int reactionDistanceHori;
	private int reactionDistanceVerti;

	public Sensor(boolean floodlightOn, int reactionDistanceHori,
			int reactionDistanceVerti) {
		this.uss = new UltrasonicSensor(SensorPort.S1);
		this.ts = new TouchSensor(SensorPort.S2);
		this.ls = new LightSensor(SensorPort.S3, floodlightOn);
		this.reactionDistanceHori = reactionDistanceHori;
		this.reactionDistanceVerti = reactionDistanceVerti;
	}

	public boolean isObstacleDetected() {
		if (uss.getDistance() > reactionDistanceHori) {
			return false;
		}
		return true;
	}

	public boolean isBumpDetected() {
		return ts.isPressed();
	}

	public boolean isGroundValid() {
		if (ls.readValue() > reactionDistanceVerti) {
			return true;
		}
		return false;
	}

	/**
	 * Intended for light-calibration, will be implemented if needed
	 */
	// public void calibrateLight(){
	//
	// }

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