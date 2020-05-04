package tvspring;

public class OtherTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("other:볼륨 낮추다");

	}

	@Override
	public void powerOff() {
		System.out.println("other:볼륨 낮추다");
	}

	@Override
	public void SoundUp() {
		System.out.println("other:볼륨 낮추다");
	}

	@Override
	public void SoundDown() {
		System.out.println("other:볼륨 낮추다");
	}

	// 전완 켜다/끄다/ 볼륨 =================상속 전===============
//	public void turnOn() {
//		System.out.println("other : 전원 키다");
//	}
//	public void turnOff() {
//		System.out.println("other : 전원 끄다");
//	
//	}
//	public void SoundUp() {
//		System.out.println("other : 볼륨 높이다");
//	
//	}
//	public void SoundDown() {
//		System.out.println("other : 볼륨 낮추다");
//	
//	}
//	

}
