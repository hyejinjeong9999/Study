# 기본 개념

1. JDK (1.8ver) 설치 
2. 웹 서버 프로그램 필요  - tomcat (8.5ver) 설치
3. 이클립스, spring library (4.0ver) 설치
   * 마켓플레이스에서 설치
   * file - new - other에 Spring 뜨면 성공

SPRING :여러가지 모듈을 단위별로 제공하고 있다

서블릿으로 class A를 만들려면

서블릿 계열을 상속받아야 했다

Class A extends Http servlet



class B : main 클래스 실행 / 서블릿 실행/안드로이드에서도 가능

어떤환경에서도 실행 가능함

일반적인 class 형태를 띈다 

plain old java object (pojo)

일반적인 클래스를 자유롭게 사용한다 = spring의 특징



=>스프링은 이전 개발 자바 객체들을 그대로 재사용이 가능하다

스프링 용으로 따로 만들 필요 없음



Spring core = di 기능을 제공

객체생성 bean

bean과 관련된 기능이 들어 있는 곳 core

 

데이터베이스 연결은 다양하다

jdbc

jdbc를 대체할 기술 spring orm dao

대신 mybatic를 사용할 예정

현재 트랜드 spring - mybatics

---





# 1. Di

용어

SPRING은 IOC 기능을 지원한다

* new를 사용하지 않아도 된다!
* spring이 대신 만들어준 객체를 거꾸로 전달받는다

* Spring 내부 프로그래밍 방식 DI

Defnedancy injection (방식)

b는 c객체가 갈지 d객체가 될지 b에 의해 갈라진다

a클래스는 b에 의존적

1. 생성자를 이용한 방법 Constructor DI
2. setter를 이용한 방법 Setter DI

* spring에선 setter를 자주 사용

---



Inversion of Control

class Mai{

...

A al = new A(new c());

class A{ 

B b1 = new B();

c타입의 객체일 수 도 있고 d타입의 객체일 수 도 있음

이걸 a클래스가 정하는게 아니라  Main 클래스가 정해줌

A가 정하는 것이 아님

제어권이 내가 있는게 아니라 거꾸로 있다

}

A에 B객체가 하나 있음

A내부에서 B가 필요하면 직접 만들어 사용해야함 

(내가 직접 제어할게!!!)

외부에서 전달받으려면?

1

A(B b1){

this.b1 = b1;

}

2

setB(B b1){

this. b1 = b1;

}

생성자나 seter로 외부에서 주입을 받을 수 있음

interface classB{}

class C implements B{}

class D implements B{}

인터페이스를 상속받은 클래스를 만들때

B타입으로 선언해도 됨

C c1 = new C();

B c1 = new D(); ->가능

B c1 = new B();



---

초기 설정 

maven 내가 할일을 자동으로 해주는 고마운 친구 ^^

spring프로젝트 생성

pom.xml

maven한테 pom.xml처럼 사용하겟다고 알려주는것

11,12라인 수정

```xml
<java-version>1.8</java-version>
<org.springframework-version>4.3.18.RELEASE</org.springframework-version>
```

![image-20200131101841165](Study/Study/md_img/image-20200131101841165.png)

properties for spring - java build path - library - jdk 1.8으로 변경

java compiler - 1.8버전인지 확인

project facets에서 jaca - 1.8버전으로 변경

​	runtimes에서 apache tomcat v8.5 체크





property태그가 bean 안에 들어가면

 DATA Objdect  = value object (vo) = data transfer object: 값을 저장하고 있는 객체 / 중간 데이터값 저장소

Main에서 사용자 입력값을 받아옴 데이터베이스에 저장하려고 함 입력받은 값이 회원정보 10개 (아이디 pw 성별,,) 10개 -> 1회원정보

10개를 전달하려면 복잡하니까 1개의 회원정보를 담는 클래스를 만들어 데이터를 저장하게 한다

DAO : 값 접근 객체 data access object

jdbc/io/네트워크 등이 dao에 들어갈 수 있다



EmpVO : 사원정보를 가지고 있는 객체

EmpDAO : 사원 등록, 정보 조회, 접근...

EmpMain : spring



property  set 메소드 호출\

`	<property name="salary" value="10000" />`

=`vo.setSalary(10000)`

name value가 salary 인 곳에 10000 저장 

# 2. mvc

spring mvc의 구성은

pom.xml 이 있어야하고

항상 버전 바꾸고

라이브러리 다운받는 곳

maven dependencies

다운받은 게 모여있는 곳



pojo : non spring애들도 spring환경에서 사용가능하다

일반적 자바 객체! 

스프링, 웹,일반main에서도 어디서든 재사용 가능한 pojo

스프링 자바 객체 = spring bean

객체를 만드는 태그 `<bean id = "bean의 이름" class ="패키지명.클래스명"/>`

# 3. mybatis

# 4. aop(선택)