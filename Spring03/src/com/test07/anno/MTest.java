package com.test07.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/anno/applicationContext.xml");

		TV tv = (TV) factory.getBean("lg");

		tv.powerOff();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		
		tv = (TV) factory.getBean("samsung");
	}
}
