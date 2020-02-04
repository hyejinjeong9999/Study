package nonspring;

public class TVFactory {
	//spring에는 factory를 대신할 library가 있다

	public TV getTv(String name) {
		if(name.equals("멀티")) {
			
			return new MultiTV();
			//인터페이스 자체는 객체를 가질 수 없음
			
		}
		else if (name.equals("other")) {
			
			return new OtherTV();
			
		}
		return null;
	}

}
