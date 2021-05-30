package com.test07;

public class LgTv implements TV {

	public LgTv() {
		System.out.println("LgTv 생성!!!");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTv power on");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTv power off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTv volume up");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTv volume down");
	}

}
