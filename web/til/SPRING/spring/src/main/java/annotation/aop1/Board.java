package annotation.aop1;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component //이름을 안주는 경우 board 로 아이디가 된당
public class Board {
	
	
	public Integer insertBoard(int seq) {
		System.out.println(seq+"번째 게시물을 등록합니다");
		return seq;
	}
	public ArrayList<String> getList(){
		System.out.println("게시물 리스트를 출력합니다");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1 : 1번게시물 : 스프링수업중입니다");
		list.add("2 : 2번게시물 : 안드로이드수업중입니다");
		list.add("3 : 3번게시물 : 하둡수업중입니다");
		return list;
	}

}
