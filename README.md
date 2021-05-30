# SpringStudy
## Spring Framework = pojo 형식으로 바뀐 경량 컨테이너
## 특징 : Open Closed Principle : 개방 폐쇄 정책 (확장은 얼려있고 변경에는 닫힘)
## -IoC : 객체를 생성이랑 사용 하는 곳이 바뀜

## -DI : <constructor-arg>(생성자) , <property> (setter 주입) , 어노테이션을 활요한 필드 주입
### 1. byName : setter와 같은 이름이 있으면 자동 할당 (bean에 id 나 name 속성의 이름이 같아야함)
### 2. byType : setter와 깉은 타입이 있으면 자동 할당 (bean에 class가 하나만 존재해야함)
### 3. constructor : 생성자의 파라미터와 같은 타입이 있으면 자동 할당 (id나 name으로 호출)
### 4. default : constructor -> byType
### * 기본 생성자가 있으면, 기본 생성자 호출 
### <context:component-scan base-package="com.test01.anno" /> -> 해당 base-package 로부터 모든 패키지 혹은 클래스를 검색해서 객체로 만들어 준다
### @component("name") -> <bean id="name" class="패키지 장소"/>
### @Value("값") -> 해당 하는 변수에 값을 넣어줌
### @AutoWrite -> ref와 같은 성질을 가지고 있음
### @Qualifier -> 같은 타입이 존재하는 경우 명확하게 구분해주기 위해 사용 

##AOP : 관점 지향 프로그래밍 -> * 횡단 관점의 분리

### cc (core concern) -> 주 관심사항

### ccc (Cross Cutting Concern) -> 공통 관심사항 Logging, transaction(최소한의 작업단위) 등

### execution(public * *(..)) -> public (모든 리턴 타입) (모든 메소드 장소랑 이름) (파라미터는 상관없음)

### @before -> 타겟 메소드 실행 전
### @AfterThrowing -> 타겟 메소드에서 예외가 발생 할 경우 처리
### @AfterReturning -> 타겟 메소드에서 예외가 발생하지 않을 경우 정상 처리
### @After ->  타겟 실행 후
### @Pointcut -> 타겟 설정

### joinpoint : 메인 실행도중 타겟을 호출하는 시점
### target : cc (주 관심사항)
### pointcut : advice/ccc가 연결되는 시점
### proxy : cc에 연결해줄떄 생기는 객체
### advice : ccc 실제 구현 code(공통 관심사항)
### advisor : pointcut + advice
### weaving : 위의 모든 과정을 통틀어서 말함

## 스프링을 이용하여 게시판 만들기
### @Controller -> 서블릿
### @Service -> biz
### @Repository -> dao => 객체로 만들어 줌

### @RequestMapping ->url을 class 또는 method와 mapping

### @RequestParam -> key=value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터를 지정

### @ModelAttribute -> form tag를 통해 넘어오는 data를 mapping된 mhthod의 파라미터로 지정

### @SessionAttribute -> session에서 model의 정보를 유지하고 싶을 때 사용

### context-param -> 어느 서블릿에서든 사용가능
### init-param -> 해당 서블릿에서만 사용가능

### RequestBody : request 객체의 body에 저장되어 넘어오는 데이터 -> java object에 binding
### ResponseBody : java object -> response 객체의 body에 binding
### JackSon : Map 을 json 형태로 바꿔줌
