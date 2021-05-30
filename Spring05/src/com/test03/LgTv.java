package com.test03;

import org.springframework.stereotype.Component;

// <bean id="lgTv" class="com.test03.LgTv"/>
@Component
public class LgTv implements TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("lg tv power on");

	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("lg tv power off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("lg tv volume up");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("lg tv volume down");
	}


}
