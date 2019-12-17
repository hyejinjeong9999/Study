package book;

import javax.swing.JOptionPane;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BookMgr mgr = new BookMgr();
		// 기본으로 10개짜리 배열 생성
		BookMgr mgr = new BookMgr(3);
		// 3개짜리 배열 생성

		Book book = new Book("java ", 33000);

		mgr.addBook(new Book("SQL", 22000));
		mgr.addBook(new Book("HTML5", 27000));
		mgr.addBook(new Book("ORACLE", 17000));

		// 3칸짜리의 배열인데 사이즈 오버 -> 오류
		// 리사이징 필요

		mgr.addBook(book);
		// book 정보 필요
		mgr.printBookList();
		mgr.printTotalPrice();

		String title = JOptionPane.showInputDialog("검색할 도서를 입력하세요");
		mgr.printSearchTitle(title);// 책검색

	}

}
