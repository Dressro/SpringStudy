package com.test03;

import org.springframework.stereotype.Component;


//<bean id="samsung" class="com.test03.SamsungTV"/>
@Component("samsung")
public class SamsungTv implements TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv power on");

	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv power off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv volume up");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv volume down");
	}

}
