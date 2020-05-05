package com.test.service;

import java.util.ArrayList;

import com.test.dao.BookDAO;
import com.test.vo.BookVO;

// 이 class는 Service class이기 때문에 무조건 business logic처리만 담당

public class BookService {

	// 키워드를 이용해서 책 제목의 ArrayList를 구해오는 method
	public ArrayList<String> getBookTitle(String keyword) {
		// DB처리를 제외한 따로 처리해야 하는 로직코드가 없어요!!
		
		// DB처리코드가 나와야 해요!! 하지만 Service는 DB처리를 하지 않아요!
		// DB처리를 하는 객체를 만들어서 그 객체한테 Database처리를 시켜요!!
		BookDAO dao = new BookDAO();
		ArrayList<String> result = dao.select(keyword);
		// 그 결과를 받아와요!!
		return result;
	}

	// 키워드를 이용해서 책 제목과 책의 고유번호(ISBN)을 얻어와서 ArrayList형태로
	// 구해오는 method
	public ArrayList<BookVO> getBookInfo(String keyword) {
		// 크게 다른 로직처리할 게 없어요!!
		// DB처리가 다예요!! => Database처리는 DAO가 담당.
		// Database 처리를 담당하는 객체를 생성(DAO)
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> result = dao.selectInfo(keyword);
		
		return result;
	}

}
