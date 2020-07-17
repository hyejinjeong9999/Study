package day02;

import java.util.Date;
//import구문

//import java.sql.Date; -> 동시에 Date를 임포트 할 수 없다

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg = "hello java~~~~";
		// java.lang.String msg의 생략형
		// java.lang ->자바의 기본적인 클래스라 생갹이 가능하다

		int size = msg.length();
		//length String의 길이반환 ***
		
		System.out.println(msg);
		
		System.out.println(size);
		
		System.out.println(msg.toUpperCase()); 
		//소문자 -32 =대문자변환
		
	
		
		
		// Date date; ->오류
		// Date는 풀네임을 안써서 오류가 난다 ->java.lang패키지가 아니라는 뜻

		java.util.Date date = new java.util.Date();
		// 뉴키워드 생성.. 객체를 생성해 메모리에 올려놔줌
		// String만 유일하게 new없이 객체를 생성하는 클래스!

		Date date2;
		// import구문을 넣으면 java.util을 생략해도 된다

		java.sql.Date date3;
		// import를 안했을 경우 풀패스로 처리

		System.out.println(date);
		System.out.println(date.toLocaleString());
		//밑줄 :  deprecated된  API 옛날엔 썻지만 지금은 쓰지 않는 기능

	}

}
