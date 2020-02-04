package edu.multi.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardlistController {
	@Autowired 
	//beans:bean id = "dao" class = xxx.boardDAO 태그가 있거나
	//혹은@Repository("dao) BoardDAODAO
	BoardDAO dao;
	@RequestMapping("/boardlist")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardListController 실행 중");
		ModelAndView mv = new ModelAndView();
		ArrayList<BoardVO> list = dao.getList();
		mv.addObject("list", list);
		mv.setViewName("boardlist");

		return mv;

	}

}
