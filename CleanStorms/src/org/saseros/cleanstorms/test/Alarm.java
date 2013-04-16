package org.saseros.cleanstorms.test;

import lejos.nxt.*;

public class Alarm {

	/**
	 * @param args
	 */
	private static final short[] note = {2349,115, 0,5, 1760,165, 0,35};

	
	public static void main(String[] args) throws Exception {
		// TODO Make police-like sound
		// TODO Make light emmit		
		Sound.setVolume(50);
		
		
		while(true){
			
			for(int i=0;i <note.length; i+=2) {
				short w = note[i+1];
				int n = note[i];
				if (n != 0) {
					Sound.playTone(n, w*10);
				}
				Thread.sleep(w*10);
			}
		}
		
		

	}

}
