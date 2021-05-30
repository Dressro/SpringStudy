package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvise {

	public MyAdvise() {
		// TODO Auto-generated constructor stub
	}

	@Before("execution (public String com.test01.Person.sayName(..))")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇입니까?");
	}

	@AfterReturning("execution (public String com.test01.Person.sayName(..))")
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}

	@After("execution (public String com.test01.Person.sayName(..))")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요");
	}

}
