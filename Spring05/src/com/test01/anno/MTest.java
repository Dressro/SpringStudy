package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/anno/applicationContext.xml");
		
		MyNickNamePrn myNick = (MyNickNamePrn) factory.getBean("myNickNamePrn");
		System.out.println(myNick);
	}

}
