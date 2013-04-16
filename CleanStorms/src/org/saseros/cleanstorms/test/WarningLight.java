package org.saseros.cleanstorms.test;

import lejos.nxt.SensorPort;

public class WarningLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO
			SensorPort.S4.setPowerType(2);
			Thread.sleep(1000);
			SensorPort.S4.setPowerType(0);
			Thread.sleep(1000);
		}

}
