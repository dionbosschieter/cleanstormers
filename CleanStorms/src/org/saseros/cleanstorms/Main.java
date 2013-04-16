package org.saseros.cleanstorms;

public class Main {

	private Robot robot;

	public Main(Robot robot) {
		this.robot = robot;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sensor sensor = new Sensor(true, 20, 30);
		Robot robot = new Robot(sensor);
		Main main = new Main(robot);
		
		
	}

}
