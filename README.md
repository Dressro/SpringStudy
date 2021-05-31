# SpringStudy
## Spring Framework = pojo 형식으로 바뀐 경량 컨테이너

## 특징 
### OCP : Open Closed Principle : 개방 폐쇄 정책 (확장은 얼려있고 변경에는 닫힘)

## -IoC : 객체를 생성이랑 사용 하는 곳이 바뀜

## -DI : <constructor-arg>(생성자) , <property> (setter 주입) , 어노테이션을 활요한 필드 주입
1. byName : setter와 같은 이름이 있으면 자동 할당 (bean에 id 나 name 속성의 이름이 같아야함)
2. byType : setter와 깉은 타입이 있으면 자동 할당 (bean에 class가 하나만 존재해야함)
3. constructor : 생성자의 파라미터와 같은 타입이 있으면 자동 할당 (id나 name으로 호출)
4. default : constructor -> byType
  * 기본 생성자가 있으면, 기본 생성자 호출 
<context:component-scan base-package="com.test01.anno" /> -> 해당 base-package 로부터 모든 패키지 혹은 클래스를 검색해서 객체로 만들어 준다
@component("name") -> <bean id="name" class="패키지 장소"/>
@Value("값") -> 해당 하는 변수에 값을 넣어줌
@AutoWrite -> ref와 같은 성질을 가지고 있음
@Qualifier -> 같은 타입이 존재하는 경우 명확하게 구분해주기 위해 사용 

## AOP : 관점 지향 프로그래밍 -> * 횡단 관점의 분리

cc (core concern) -> 주 관심사항

ccc (Cross Cutting Concern) -> 공통 관심사항 Logging, transaction(최소한의 작업단위) 등

execution(public * *(..)) -> public (모든 리턴 타입) (모든 메소드 장소랑 이름) (파라미터는 상관없음)

@before -> 타겟 메소드 실행 전
@AfterThrowing -> 타겟 메소드에서 예외가 발생 할 경우 처리
@AfterReturning -> 타겟 메소드에서 예외가 발생하지 않을 경우 정상 처리
@After ->  타겟 실행 후
@Pointcut -> 타겟 설정

joinpoint : 메인 실행도중 타겟을 호출하는 시점
target : cc (주 관심사항)
pointcut : advice/ccc가 연결되는 시점
proxy : cc에 연결해줄떄 생기는 객체
advice : ccc 실제 구현 code(공통 관심사항)
advisor : pointcut + advice
weaving : 위의 모든 과정을 통틀어서 말함

## 스프링을 이용하여 게시판 만들기 위한 어노테이션
@Controller -> 서블릿
@Service -> biz
@Repository -> dao => 객체로 만들어 줌

@RequestMapping ->url을 class 또는 method와 mapping

@RequestParam -> key=value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터를 지정

@ModelAttribute -> form tag를 통해 넘어오는 data를 mapping된 mhthod의 파라미터로 지정

@SessionAttribute -> session에서 model의 정보를 유지하고 싶을 때 사용

context-param -> 어느 서블릿에서든 사용가능
init-param -> 해당 서블릿에서만 사용가능

@RequestBody : request 객체의 body에 저장되어 넘어오는 데이터 -> java object에 binding
@ResponseBody : java object -> response 객체의 body에 binding
JackSon : Map 을 json 형태로 바꿔줌

## 스프링 설정 순서
01. pom.xml
	ojdbc6, mybatis, mybatis-spring, commons-dbcp, spring-orm	
02. web.xml
03. /WEB-INF/spring/sqls/test.sql
04. dto, dao, biz, controller
05. src/main/resources/mybatis/myboard-mapper.xml
06. src/main/resources/mybatis/db.properties
07. /WEB-INF/spring/sqls/config.xml
08. applicationContext.xml

_filter
09. com.mvc.upgrade.common.filter/LogFilter (impl javax.servlet.Filter)
10. web.xml 에 설정

_aop
11. pom.xml : aspectjweaver, aspectjrt 추가
12. com.mvc.upgrade.commom.aop/LogAop
13. WEB-INF/spring/appServlet/aop-context.xml
14. web.xml
15. src/main/resources/log4j.xml

login
16. pom.xml : jackson-core-asl, jackson-mapper-asl (4 버전 이후 부터는  jsckson-core,jackson-databind)
17. WEB-INF/spring/sqls/test.sql
18. dto, dao, biz , controller
19. src/main/resources/mybatis/member-mapper.xml
20. WEB-INF/spring/sqls/config.xml

_interceptor
21. com.mvc.upgrade.common.interceptor / LoginInterceptor (impl HandlerInterceptor)
22. WEB-INF/spring/appServlet/servlet-context.xml

_transaction
23. (MyBoard) dao,biz,controller
24. WEB-INF/spring/appServlet/servlet-context.xml
25. applicationContext.xml

_security
26. pom.xml : spring-security-web
27. WEB-INF/spring/appServlet/security-context.xml
28. web.xml
29. (Member) dao, biz , controller

## 스프링 업데이트 
1. web.xml : 2.5 -> 4.0
2. pom.xml
	java : 1.6 -> 11
	spring : 3.1.1 -> 5.3.7
	servlet-api -> javax.servlet-api : 2.5 -> 4.0.1
	jsp-api -> javax.servlet.jsp-api : 2.1 -> 2.3.3
	maven-compiler-plugin source/targer : 1.6 -> 11
	
3. project facets
	dynamic web module : 2.5 -> 4.0
	java : 11
4. maven update

## 스프링 Mybatis 사용 안하고 게시판 만들기
_jdbc
5. pom.xml : spring-jdbc,ojdbc6
6. web.xml
7. src/main/resources/sqls
	jdbc.sql
	db.properties
8. applicationContext.xml
9. dto,dao,biz,controller
	
## 스프링 부트
thymeleaf
<html xmlns:th="http://www.thymeleaf.org">
-> 스프링 부트에서 thymeleaf를 사용하기 위해서 작성

th:text -> 해당 text 값을 넣어줌
th:object -> 해당 div 안에서 dto 객체를 가지고 와서 사용 가능
	*{value} -> c 와 c++ 같이 포인터 * 과 같은 역활
th:each ="dto:${list}" -> for each문이랑 비슷
	*{dto.value} -> 해당 dto 값을 가지고 옴
th:if -> if문과 같은 유형 안의 조건이 참이면 실행
th:unless -> if문과 같은 유형 안의 조건이 거짓이면 실행
num:${#numbers.sequence(1,3)} -> num 값안에 1~3을 차례로 넣어줌
th:href="@{링크}" -> 해당 링크로 이동
th:switch -> 스위치 문과 비슷
th:action="@{링크}" -> form 태그에서 action 역활을 맡아서 함 

JPA
spring.jpa.hibernate.ddl-auto=create(안에 값을 다시 지움) 로 통해서 
@Entity 
@Table(name = "MYBOARD")
를 프로젝트 실행 될 때 마다 자동 생성

findAll -> selectList

findByMyno -> selectOne

save -> insert

saveAndFlush -> update

deleteByMyno -> delete
