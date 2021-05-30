package com.test01.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("msg")
public class MessageBeanImpl implements MessageBean {

	@Value("망고")
	private String fruit;
	@Value("1000")
	private int cost;

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("과일이름 : " + fruit + "\t" + "가격 : " + cost);
	}

	public MessageBeanImpl() {

	}

	public MessageBeanImpl(String fruit, int cost) {

		this.fruit = fruit;
		this.cost = cost;
	}
	
	

}
