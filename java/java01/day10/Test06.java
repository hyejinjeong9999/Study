package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class Test06 {

	public static void main(String[] args) {

		Set<Book> bookList = new HashSet<Book>();
		// 예전엔 배열생성의 걱정을 했는데 이제 걱정할 필요없음
		// 프레임워크는 배열의 관리 쉬움
		// curd : 기본적인 데이터기능인 등록 삭제 수정 검색

		// 등록작업
		
		if(bookList.add(new Book("java", 500))) {
			System.out.println("등록완료");
		}else {
			System.out.println("이미 등록된 데이터가 있습니다");
		}

		//add의 타입 booeaan
		bookList.add(new Book("sql", 1500));
		bookList.add(new Book("jsp", 5500));
		if(bookList.add(new Book("java", 500))) {
			System.out.println("등록완료");
		}else {
			System.out.println("이미 등록된 데이터가 있습니다");
		}
		//중복데이터 < 뒤의 java는 fale이 된다

		// 출력
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {// 다음값이 있을 때 까지
			
			Book book = (Book) it.next(); // 값 출력
		System.out.println(book);
//			// 순서 상관 없음
//			// hashset -> equals 메소드를 위해 오버라이딩 필수~~

		}

		// 검색 (부분출력)
		String keyword = JOptionPane.showInputDialog("도서명입력");
		System.out.println(keyword + " 검색결과 ");
		//검색을 위한 창 띄우기
		
		
		while (it.hasNext()) {
			Book book = (Book) it.next();

			if (book.title.toUpperCase().contains((keyword.toUpperCase()))) {
				System.out.println(book);
				
			//값 비교해서 같으면 출력
			}
		}

		// 삭제

		Scanner scanner = new Scanner(System.in);
		// 시스템으로부터 데이터 받아오기

		System.out.println("삭제할 도서명 입력");

		String msg = scanner.nextLine().trim();
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();

			if (book.title.contains(msg)) {
				System.out.println(book);
				System.out.println("삭제할까요? y를 누르면 삭제됩니다");
				msg = scanner.nextLine().trim();
				if (msg.equalsIgnoreCase("y"))
					it.remove();

			}
		}

		// 수정
		System.out.println("수정 도서 이름 입력");
		msg = scanner.nextLine().trim();
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();

			if (book.title.contains(msg)) {
				book.title = book.title + "____";
			}
		}
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);
		}

		scanner.close();
		scanner = null;
		// 스캐너 사용후엔 항상 비우기

	}

}

class Book {

	String title;
	int price;

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}