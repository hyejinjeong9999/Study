package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import bookFinal.Book;

public class Test08 {

	public static void main(String[] args) {

		System.out.println("========start=========");

		try (Scanner scanner = new Scanner(new File("bookdata.txt"));) {

			StringTokenizer st = null;
			while (scanner.hasNextLine()) {
				st = new StringTokenizer(scanner.nextLine());
				String title = st.nextToken();
				int price = Integer.parseInt(st.nextToken());

				Book book = new Book(title, price);
				System.out.println(book);

			}

		} catch (

		FileNotFoundException e) {
			System.out.println("bookdata.txt 파일 확인해주세요");

		}

		System.out.println("========end=========");
	}

}
