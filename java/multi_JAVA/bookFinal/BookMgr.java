package bookFinal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class BookMgr {
	Set<Book> bookList = new HashSet<Book>();

	public BookMgr() {

		System.out.println("책관리프로그램 시작");

	}

	public void addBook(Book book) {

		bookList.add(book);
	}

	public void printBookList() {
		System.out.println("===책 목록===");
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {

			Book book = (Book) it.next();
			System.out.println(book);
		}

	}

	public void printTotalPrice() {
		System.out.println("===책 가격===");
		Iterator<Book> it = bookList.iterator();
		int total = 0;
		while (it.hasNext()) {
			Book book = (Book) it.next();
			total += book.getPrice();

		}
		System.out.println("총합 :" + total);

	}

	public void printSearchTitle() {
		String keyword = JOptionPane.showInputDialog("도서명입력");
		System.out.println(keyword + " 검색결과 ");
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();

			if (book.getTitle().toUpperCase().contains((keyword.toUpperCase()))) {
				System.out.println(book);

				// 값 비교해서 같으면 출력
			}

		}

	}

	public void delete() {
		String keyword = JOptionPane.showInputDialog("삭제할도서명입력");
		Iterator<Book> it = bookList.iterator();
	
		while (it.hasNext()) {
			Book book = (Book) it.next();

			if (book.getTitle().contains(keyword)) {
				System.out.println(book);
				keyword = JOptionPane.showInputDialog("삭제할까요? y를 누르면 삭제됩니다");

				if (keyword.equalsIgnoreCase("y"))
					it.remove();

			}
		}

		System.out.println(keyword + " 삭제완료");
	}

}