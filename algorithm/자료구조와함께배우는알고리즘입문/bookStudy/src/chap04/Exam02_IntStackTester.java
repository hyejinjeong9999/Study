package chap04;

import java.util.Scanner;

public class Exam02_IntStackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Exam01_IntStack s = new Exam01_IntStack(64);
		// 최대 64개를 푸시할 수 있음

		while (true) {
			System.out.println("현재 데이터 수" + s.size() + "/" + s.capacity());
			System.out.println("(1)푸시   (2)팝   (3)피크   (4)덤프   \n(0)종료");

			int menu = sc.nextInt();
			// 종료
			if (menu == 0)
				break;

			int x;

			switch (menu) {
			// 푸시
			case 1:
				System.out.println("넣을 데이터 입력");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch (Exam01_IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다");
				}
				break;
			// 팝
			case 2:
				try {
					x = s.pop();
					System.out.println("꺼낸 데이터는" + x + "입니다");
				} catch (Exam01_IntStack.EmptyIntStackExeption e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			// 피크
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는" + x + "입니다");
				} catch (Exam01_IntStack.EmptyIntStackExeption e) {
					System.out.println("스택이 비어있습니다");
				}
				break;
			// 덤프
			case 4:
				s.dump();
				break;

			}
		}
		sc.close();

	}

}
