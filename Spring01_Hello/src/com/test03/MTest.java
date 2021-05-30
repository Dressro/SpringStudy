package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기존방식
		// 1. 
		// Resources res = new FileSystemResource("src/com/tset/bean.xml");
		// 2.
		// Resources res = new ClassPathResource("com/test03/bean.xml");
		
		// 3. 현재방식
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/bean.xml");
		
		MessageBean bean = (MessageBean) factory.getBean("english");
		bean.sayHello("Spring");
		
		bean = (MessageBean) factory.getBean("korean");
		bean.sayHello("스프링");
		
	}

}
/*

ApplicationContext, ClassPathXmlApplicationContext

BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext

ApplicationContext 객체는 스프링 컨테이너의 인스터스 이다.
스프링은 ApplicationContext 인터페이스의 몇가지 기본 구현을 제공한다.
그 중, ClassPathXmlApplicationContext는 XML 형식의 독립형 어플리케이션에 적합.
(지정된 ClassPath에서 Xml 파일을 읽어서 객체 생성)

--------------------------------------------------------------------------

Container : 담는 그릇 (bean을 저장하고 관리하는 객체)
Content : 기능
Context : 기능을 구현하기 위한 정보 (설정)


*/