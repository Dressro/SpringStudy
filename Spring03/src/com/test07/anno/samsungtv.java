package com.test07.anno;

import org.springframework.stereotype.Component;

@Component("samsung")
public class samsungtv implements TV {
	
	public samsungtv() {
		System.out.println("samsung tv 생성!!!");
	}

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
