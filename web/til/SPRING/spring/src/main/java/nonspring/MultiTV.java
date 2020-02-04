package nonspring;

public class MultiTV  implements TV{
	//TV 상속
	//상속받았으면 의무적으로 오버라이딩 해야한다!

	@Override
	public void powerOn() {
		System.out.println("멀티tv:전원켜다");
		
	}

	@Override
	public void powerOff() {
		System.out.println("멀티tv:전원끄다");
		
	}

	@Override
	public void SoundUp() {
		System.out.println("멀티tv:볼륨 높이다");
		
	}

	@Override
	public void SoundDown() {
		System.out.println("멀티tv:볼륨 낮추다");
	}
	
	
	//==============전원 켜다, 끄다 [상속 전 방식]================ 
	
//	public void powerOn() {
//		System.out.println("멀티tv:전원켜다");
//		
//	}
//	public void powerOff() {
//		System.out.println("멀티tv:전원끄다");
//		
//	}
//	
//	//볼륨 업, 다운
//	
//	public void volumeUp() {
//		System.out.println("멀티tv:볼륨 높이다");
//		
//	}
//	public void volumeDown() {
//		System.out.println("멀티tv:볼륨 낮추다");
//		
//	}
//	
	
	

}
