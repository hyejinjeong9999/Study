package day08;

public class Test02 {

	public static void main(String[] args) {

		SingleTone s1 = SingleTone.getInstance();
		SingleTone s2 = SingleTone.getInstance();
		SingleTone s3 = SingleTone.getInstance();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

}

class SingleTone {

	private static SingleTone s;

	private SingleTone() {
	}

	public static SingleTone getInstance() {

		// 외부에서 접근을 못하기 때문에 Static으로 미리 생성
		// 딱 한번만 객체생성해서 이것만 공유한다

		if (s == null)
			s = new SingleTone();
		return s;

	}

}
