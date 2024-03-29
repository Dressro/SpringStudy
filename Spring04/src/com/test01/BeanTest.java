package com.test01;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {

	public BeanTest() {
		// TODO Auto-generated constructor stub
		System.out.println("BeanTest() 호출");
	}

	public BeanTest(Date date) {
		System.out.println("BeanTest(Date date) 호출 : " + date);
	}
	
	public void setMyClass(MyClass myClass) {
		System.out.println("setMyClass(MyClass myClass) 호출 :");
		myClass.prn();
	}
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date) 호출 : " + date);
	}

	public void setNumber(int num) {
		System.out.println("setNumber(int num) 호출 : "+num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("setArray(String[] arr) 호출");
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList(List<String> list) 호출");
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public void setSet(Set<String> set) {
		System.out.println("Set<String> set 호출");
		for(String s : set) {
			System.out.println(s);
		}
	}
	
	public void setMap(Map<String,String> map) {
		System.out.println("setMap(Map<String,String> map) 호출");
		for(String s : map.values()) {
			System.out.println(s);
		}
		// entry 써보자.
		Set<Map.Entry<String,String>> entry = map.entrySet();
		for(Map.Entry<String, String> en : entry) {
			System.out.println(en.getValue());
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore(List<Score> list) 호출");
		for(Score sc :list) {
			System.out.println(sc);
		}
		
	}
}
