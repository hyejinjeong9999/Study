package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//controller를 spring에서 제공해 주는 것으로 함
public class BoardlistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardListController 실행 중");
		ModelAndView mv = new ModelAndView();

		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getList();

		mv.addObject("boardlist", list);

		mv.setViewName("boardlist");

		return mv;

	}

}
