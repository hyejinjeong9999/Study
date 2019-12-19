package day05;

public class Prob5 {
	public static void main(String args[]) {

		System.out.println(Prob5.leftPad("SDS", 6, '#'));
		System.out.println(Prob5.leftPad("SDS", 5, '$'));
		System.out.println(Prob5.leftPad("SDS", 2, '&'));

		Prob5 p5 = new Prob5(); // 객체생성 필요
		System.out.println(p5.rightPad("SDS", 6, '#'));
		System.out.println(p5.rightPad("SDS", 5, '$'));
		System.out.println(p5.rightPad("SDS", 2, '&'));
	}

	public static String leftPad(String str, int size, char padChar) {
		//스태틱이 있는 메소드 -> 클래스 메소드
		//new안해도 올라감 / static영역에 올라감
		//딱하나뿐.. static에 저장되 있는 하나를 가져다 쓰는거
		//prob5 객체를 10개를 만들어됴 leftPad는 하나뿐이다!!
		
		int count = size-str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {

			sb.append(padChar);
		}

		sb.append(str);// for loop 앞에 있으면 right패드

		return sb.toString();
	}

	public String rightPad(String str, int size, char padChar) {
		// StaticX - 인스턴스 메소드
		//new 키워드가 필요함  heap영역에 right가 올라감
		//로컬변수 : 함수가 호출될때 잠깐 쓰이고 다 사용되면 사라짐
		//멤버변수 : 
		 

		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for (int i = 0; i < size - str.length(); i++) {

			sb.append(padChar);
		}

		return sb.toString();
	}
}