package com.test07;

public class MessageBeanImpl implements MessageBean {

	String name;
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello " + name);
	}

}