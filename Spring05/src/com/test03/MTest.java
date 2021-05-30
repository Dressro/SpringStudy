package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV samsung = (TV) factory.getBean("samsung");
		TV Lg = (TV) factory.getBean("lgTv");
		
		samsung.powerOn();
		Lg.powerOn();
	}
}
