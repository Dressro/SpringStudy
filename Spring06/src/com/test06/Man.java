package com.test06;

import org.springframework.stereotype.Component;

@Component("man")
public class Man implements Person {

	@Override
	public void classWork() {
		// TODO Auto-generated method stub

		System.out.println("컴퓨터를 켜서 유튜브를 본다");
	}

}
