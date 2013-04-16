package org.saseros.cleanstorms.test;

import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class BluetoothExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("waiting connection");

		byte[] newPin = {0,1,2,3};
		
		Bluetooth.setPin(newPin);
		
		BTConnection bt = Bluetooth.waitForConnection();
		
		if(bt == null) {
			System.out.println("Not Connected");
			return;
		}
		
		System.out.println("Connected");
		Thread.sleep(2000);
		System.out.println(bt.getSignalStrength());
		
	}

}
