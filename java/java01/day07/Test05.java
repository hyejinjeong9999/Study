package day07;

public class Test05 {
	public static void main(String[] args) {
		Dog[] d; // Dog만 모아서 관리
		Fish[] f; // fish만 모아서 관리

		Animal[] animals = { new Dog("진돗개", "개리"), new Fish("쿠피"), new Dog("시베리안허스키", "해리"), new Fish("재피") };
		// dog+ fish 둘다 활용측면에서 더 좋음
		// animal타입은 fish/dog 함수 실행못함

		for (Animal data : animals) {
			if (data instanceof Dog)
				((Dog) data).print();
			if (data instanceof Fish)
				((Fish) data).print();
			data.breath(); // 오버라이딩을 해서

		}
	}

}
