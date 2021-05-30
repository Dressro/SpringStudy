package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	// 타겟 메소드 실행 전
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍는다.");
	}

	//타겟 메소드에서 예외가 발생 할 경우 처리
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날 이었다.");
	}

	//타겟 메소드에서 예외가 발생하지 않을 경우 정상 처리
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + "공부하는 날이었다.");
	}

	// 타겟 실행 후
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
