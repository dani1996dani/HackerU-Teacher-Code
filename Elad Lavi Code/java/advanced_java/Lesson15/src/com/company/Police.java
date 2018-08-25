package com.company;

public class Police implements MotionSensor.MotionSensorListener {
	@Override
	public void motionDetected(int motionIntensity) {
		System.out.println("stop! you are under arrest!");
	}
}
