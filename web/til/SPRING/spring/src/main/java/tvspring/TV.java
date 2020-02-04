package tvspring;

public interface TV {
	//모든 tv들은 메소드 선언을 일치시키자
	public void powerOn();
	public void powerOff();
	public void SoundUp();
	public void SoundDown();
	
	//인터페이스의 특징 : 메소드 구현 불가능 하다 선언만 가능하다
	//tv들은 네가지 메소드를 기본으로 가지고 있어야한다

}
