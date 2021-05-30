package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	// ccc 생성
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}
}
