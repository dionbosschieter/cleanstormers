package org.saseros.cleanstorms;

import lejos.nxt.Motor;

/**
 * A thread-class for moving the UltrasonicSensor attached to the head.
 * 
 * @author Pers
 * 
 */
public class UltrasonicHeadMover extends Thread {

	private final int turningDegree = 45;
	private int check = 0;

	/**
	 * The code that should be executed once the thread has been initiated
	 */
	@Override
	public void run() {
		while (true) {
			try {
				if (check == 0) {
					executeHeadTurn(-turningDegree);
				} else if (check == 1) {
					executeHeadTurn(0);
				} else {
					executeHeadTurn(turningDegree);
				}
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("Thread turning Ultrasonic head failed");
			}
		}
	}

	/**
	 * A help-method for the thread that executes the head-turning
	 * 
	 * @param rotation
	 *            The rotation the head should execute
	 */
	private void executeHeadTurn(int rotation) {
		Motor.B.rotateTo(rotation);
		if (check <= 2) {
			check++;
		} else {
			this.check = 0;
		}
	}
}
