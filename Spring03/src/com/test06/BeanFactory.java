package com.test06;

public class BeanFactory {

	Object getBean(String name) {
		if (name.equals("samsong")) {
			return new SamsongTv();
		} else if (name.equals("lg")) {
			return new LgTv();
		}

		return null;
	}
}
