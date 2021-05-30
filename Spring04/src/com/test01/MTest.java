package com.test01;

import java.util.Date;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		//today 호출 (오늘날짜)
		Date start = factory.getBean("start",Date.class);
		System.out.println(start);
		
		BeanTest bean = (BeanTest) factory.getBean("beanTest");
	}
}
