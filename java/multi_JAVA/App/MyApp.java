package App;

import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cmd = null;

		while (true) {
			System.out.println("메뉴를 선택해주세요. . .  \n\n");
			System.out.println("1. 입		력\n");
			System.out.println("2. 수		정\n");
			System.out.println("3. 삭		제\n");
			System.out.println("4. 검		색\n");
			System.out.println("5. 목   록   보   기\n");
			System.out.println("9. 종		료\n");

			cmd = scanner.nextLine().trim();
			// trim : 공백처리
			System.out.println(cmd + "입력");

			switch (cmd) {
			case "1":
				System.out.println("========입력========");
				break;
			case "2":
				System.out.println("========수정========");
				break;
			case "3":
				System.out.println("========삭제========");
				break;
			case "4":
				System.out.println("========검색========");
				break;
			case "5":
				System.out.println("=======목록보기=======");
				break;
			case "9":
				System.out.println("=======종료수행=======");
				System.out.println("종료를 원하면 q를 입력해주세요");

				if (scanner.nextLine().equalsIgnoreCase("q")) {
					System.out.println("종료되었습니다");
					scanner.close();
					scanner = null;
					return;
				} else
					break;

			default:
				System.out.println("잘못입력했습니다");
				break;

			}

		}

	}

}
