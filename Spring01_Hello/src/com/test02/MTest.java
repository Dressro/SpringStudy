package com.test02;

public class MTest {

	public static void main(String[] args) {
		MessageBean msg = new MessageBeanEn();
		msg.sayHello("Spring");
		
		MessageBean msg2 = new MessageBeanKo();
		msg2.sayHello("스프링");
	}
	
}
