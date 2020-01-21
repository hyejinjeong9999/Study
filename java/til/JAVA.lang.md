# JAVA.lang

* 자바프로그래밍에 가장 기본이 되는 클래스
* import문 없이도 사용 가능
  * ex) String, System...

## Object 클래스

* Object는 모든 클래스의 최고 조상이기 때문에 모든 클래스에 사용 가능

* 메서드

| Object클래스의 매서드                                        | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Protected Object clone()                                     | 객체 자기자신의 복사본 반환                                  |
| public boolean equals(object obj)                            | 객체 자신과 객체 obj가 같은 객체인지 알려줌                  |
| Protected void finalize()                                    | 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출<br />이 때 수행되어야 하는 코드가 있을 때 오버라이딩 함(거의 사용 안함) |
| public class getClass()                                      | 객체 자신의 클래스 정보를 담고 있는 Class 인스턴스 반환      |
| public int hashcode()                                        | 객체 자신의 해시코드 반환                                    |
| pubilc String toString()                                     | 객체 자기 자신의 정보를 문자열 반환                          |
| public void notify()                                         | 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨움         |
| public void notifyAll()                                      | 객체 자신을 사용하려고 기다리는 모든 쓰래드 깨움             |
| public void wait (long timeout)<br />public void wait(long timeout, int nansos) | 다른 쓰레드가 notify나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout,nanos)동안 기다리게한다<br />*timeout은 천분의 1초, nanos는 10^9분의 1초* |


### euqlas(Object obj)

````java
package ch9;

public class EqualsEx1 {

	public static void main(String[] args) {

		Value v1 = new Value(10);
		Value v2 = new Value(10);

		if (v1.equals(v2))
			System.out.println("v1과 v2는 같다");

		else
			System.out.println("v1과v2는 다르다");
		//다르다출력 : 주소값으로 참조하기 때문!
		v2=v1;
        //같은 주소로 변경 => 같다 출력
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같다");

		else
			System.out.println("v1과v2는 다르다");

	}

}

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}

//결과 
//v1과v2는 다르다
//v1과 v2는 같다

````

* 오버라이딩
  * 주소값이 아닌 내용을 비교할 수 있도록 오버라이딩
  * 형변환 필수

````java
package ch9;

public class EqualsEx2 {

	public static void main(String[] args) {

		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		
		if(p1==p2)//주소값 비교
			System.out.println("p1==p2");
		else
			System.out.println("p1!=p2");
		if(p1.equals(p2)) //내용 비교
			System.out.println("p1==p2");
		else
			System.out.println("p1!=p2");
		
	}

}

class Person{
	long id;
	public boolean equals(Object obj) {
		if(obj instanceof Person)
			return id ==((Person)obj).id;
		//형변환이 필요하다
		else
			return false;
	}
	Person(long id){
		this.id = id;
	}
}
//출력결과
//p1!=p2
//p1==p2

````

````java
package ch9;

public class Exercise9_1 {

	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c1.equals(c2):" + c1.equals(c2));

	}

}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
	  
		return this.num ==((SutdaCard)obj).num? true: false;
	 }

	public String toString() {
		return num + (isKwang ? "k" : "");
	}

}

//출력결과
//c1=3k
//c2=3k
//c1.equals(c2):true

````



### toString()

* 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의

* 기본 정의된 toString()

  * 오버라이딩 하지 않으면 16진수의 해시코드를 얻게됨

  ````java
  public String toString(){
      return getClass().getName()+"@"+Integer.toHexString(hashCode());
  }
  ````

  * 해시코드가 정의 된 예
  
  ````java
  package ch9;
  
  public class CardToString {
  
  	public static void main(String[] args) {
  		
  		Card c1 = new Card();
  		Card c2 = new Card();
  		
  		System.out.println(c1.toString());
  		System.out.println(c2.toString());
  		//오버라이딩을 하지 않음 16진수의 해시코드를 얻게 됨	
  
  	}
  
  }
  
  class Card{
  	String kind;
  	int number;
  	
  	 Card() {
  		this("SPADE",1);
  	}
  	Card(String kind, int number){
  		this.kind = kind;
  		this.number = number;
  	}
  }
  
  //실행결과
  //ch9.Card@75b84c9
  //ch9.Card@6bc7c054
  
  ````
  
  * 오버라이드
  
  ````java
  package ch9;
  
  public class CardToString2 {
  
  	public static void main(String[] args) {
  		
  		Card2 c1 = new Card2();
  		Card2 c2 = new Card2("HEART",10);
  		
  		System.out.println(c1.toString());
  		System.out.println(c2.toString());
  		//오버라이딩을 하지 않음 16진수의 해시코드를 얻게 됨
  		
  	}
  
  }
  
  class Card2{
  	String kind;
  	int number;
  	
  	 Card2() {
  		this("SPADE",1);
  	}
  	Card2(String kind, int number){
  		this.kind = kind;
  		this.number = number;
  	}
  	
  	public String toString() {
  		return "kind : " + kind+ ", number : "+number;
  		//object의 toString()의 접근제어자가 public이기 때문에 여기서도 public임
  	}
  }
  /*결과
  kind : SPADE, number : 1
  kind : HEART, number : 10
  */
  
  ````
  
* String타입이나 Date 타입의 경우 이미 오버라이딩 되어있다

  ````java
  public class ToStringTest {
  
  	public static void main(String[] args) {
  		
  		String str = new String("KOREA");
  		java.util.Date today = new java.util.Date();
  		
  		System.out.println(str);
  		System.out.println(str.toString());
  		System.out.println(today);
  		System.out.println(today.toString());
  		//클래스 이름이나 해시코드가 아닌 제대로 된 값이 나옴
  		//-> Date와String은 이미 오버라이딩이 되어 있다
  
  	}
  
  }
  /* 결과
  KOREA
  KOREA
  Tue Jan 21 20:06:11 KST 2020
  Tue Jan 21 20:06:11 KST 2020
  */
  ````

* 예제2

````java
package ch9;

public class Exercise9_2 {

	public static void main(String[] args) {
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(1, 2, 3);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?" + (p1 == p2));
		System.out.println("p1.equals(p2)?" + (p1.equals(p2)));

	}

}

class Point3D {
	int x, y, z;

	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	Point3D() {
		this(0, 0, 0);
	}

	public boolean equals(Object obj) {
		return this.x == ((Point3D) obj).x && this.y == ((Point3D) obj).y && this.z == ((Point3D) obj).z ? true : false;
	}

	public String toString() {
		return "[" + x+ ", " + y + ", " +z+"]";
	}
}
/*실행결과
[1, 2, 3]
[1, 2, 3]
p1==p2?false
p1.equals(p2)?true
*/
````



### getClass()

* 자신이 속한 클래스의 Class 객체를 반환
* Class객체는 이름이 'Class'인 클래스의 객체
* 정의

````java
public final class Class implements{
    ,..
}
````

*  클래스의 모든 정보를 담고 있음
* 클래스당 1개만 가지고 있음

* class 객체 얻기 예

  ````java
  Class cObj = new Card().getClass();
  //생선된 객체로부터 얻기
  Class cObj = Card.flass;
  //클래스 리터럴(*.class)로부터 얻기
  Class cObj = Class.forName("Card")
      //클래스 이름으로부터 얻기
      
  Card c = Card.class.newInstance(); 
  //클래스 객체를 이용한 객체 생성
  ````

* 예제

  ````java
  
  ````

  

