package readingBankbook;

import java.util.Scanner;

public class Menu {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		String cmd = null;
		while (true) {
			System.out.println("책 통장 입력 서비스 실행...");
			System.out.println("====원하시는 메뉴를 입력해주세요====\n");

			System.out.println("1.입                      력\n");
			System.out.println("2.수                     정\n");
			System.out.println("3.삭                     제\n");
			System.out.println("4.목     록     보     기\n");
			System.out.println("9. 종료\n");

			cmd = scanner.nextLine().trim();

			switch (cmd) {
			case "1":

				System.out.println("책을 기입해주세요...");

				break;
			case "2":

				System.out.println("수정할 내용을 입력하세요...");

				break;
			case "3":
				System.out.println("삭제할 책 제목을 입력해주세요...");

				break;

			case "4":
				System.out.println("====검색 목록===");

				break;
			case "5":
				System.out.println("===독서통장 목록===");
				System.out.println("검색할 책 제목을 입력해주세요...");

				break;
			case "9":
				System.out.println("종료창");
				System.out.println("종료를 원하시면 q를 입력하세요");
				if (scanner.nextLine().equalsIgnoreCase("q")) {
					System.out.println("독서프로그램 종료...");
					scanner.close();
					scanner = null;
					return;
				} else {
					break;
				}

			default:
				System.out.println("제대로 된 값을 입력해주세요");

			}

		}
	}

}
