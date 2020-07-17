package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bookFinal.Book;

public class Test07 {

	public static void main(String[] args) {

		System.out.println("========start=========");

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("bookdata.txt"));

			while (scanner.hasNextLine()) {
				// 스트링 스플릿 스트링 ㅌ
				String[] data = scanner.nextLine().split(" ");
				// 한줄읽음
				// " "기준으로 쪼개짐 책이름 / 가격
				Book book = new Book(data[0], Integer.parseInt(data[1]));
				// book만들어서 첫번째(제목 ), 두번째에 있는 값(가격) 저장
				System.out.println(book);
				// book 출력

			}

		} catch (FileNotFoundException e) {
			System.out.println("bookdata.txt 파일 확인해주세요");

		} finally {
			if (scanner != null) // null은 try catch로 못잡아서 if로잡는다
									// scanner에 값이 있을대 자원반납 수행
				scanner.close(); // 자원반납

		}

		System.out.println("========end=========");
	}

}
