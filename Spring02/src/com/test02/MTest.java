package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
	
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		// bean으로 등록된 2명 출력
		Address people_one = (Address) factory.getBean("people_one"); 
		Address people_two = (Address) factory.getBean("people_two"); 
		
		System.out.println(people_one);
		System.out.println(people_two);
	}
}
