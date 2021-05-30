package com.test06;

import org.springframework.stereotype.Component;

@Component("woman")
public class Woman implements Person {

	@Override
	public void classWork() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 켜서 웹 서핑을 한다");
	}

}
