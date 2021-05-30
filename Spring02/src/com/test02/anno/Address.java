package com.test02.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("people")
public class Address {

	@Value("홍길동")
	private String name;
	@Value("서울시 강남구")
	private String addr;
	@Value("010-1234-1234")
	private String phone;

	public Address() {

	}

	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

}
