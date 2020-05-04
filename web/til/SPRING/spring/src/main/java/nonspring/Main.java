package nonspring;

public class Main {

	public static void main(String[] args) {
		
	
		
//		MultiTV tv = new MultiTV();
//		
//		tv.powerOn();
//		tv.SoundUp();
//		tv.SoundDown();
//		tv.powerOff();
//		
//		OtherTV tv2 = new OtherTV();
//		
//
//		tv2.powerOn();
//		tv2.SoundUp();
//		tv2.SoundDown();
//		tv2.powerOff();
//		
//		//상속 후 메소드가 통일됨
//		
//		
//		TV tv3  = new MultiTV();
//		TV tv4  = new MultiTV();
//		//인터페이스로 형변환해도 된다
		
		
		//tv변수 생성 객체가 MultiTV, Other TV 중 하나라면 powerOn이 멀티일 수 도 있고 
		//other일 수 있다
		//앞의 MultiTV, OtherTV에 따라 달라진다 : 의존성 dependency
		//dependency : 의존하는 객체를 직접 객체 생성 ---> 위임하자 TV factory
		
		TVFactory factory = new TVFactory();
		TV tv5 = factory.getTv("멀티");
		tv5.powerOn();
		tv5.SoundUp();
		tv5.SoundDown();
		tv5.powerOff();
		TV tv6 = factory.getTv("아더");
		//factory한테 만들어달라고 한거
		
		tv6.powerOn();
		tv6.SoundUp();
		tv6.SoundDown();
		tv6.powerOff();
		
		
		
		
		
//		tv2.powerOn();
//		tv2.volumeUp();
//		tv2.volumeDown();
//		tv2.powerOff();
		//오류 : 다른 메서드기 때문
		//메서드 이름이 다르기 때문에
		//객체 변경시 코드 수정이 불가피하다 = 결합도가 높다 coupling이 높다(나쁜 코드)
		
		
		

	}

}
