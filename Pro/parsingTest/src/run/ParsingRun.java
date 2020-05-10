package run;

import dao.ParsingDAO;
import vo.ParsingVO;

public class ParsingRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParsingDAO dao = new ParsingDAO();
		ParsingVO vo = new ParsingVO();
		dao.getVilageWeather(vo);
		
		System.out.println("체감온도"+vo.getFeelsLike());
		System.out.println("습도"+vo.getHumidity());
		System.out.println("온도"+vo.getTemp());
		System.out.println("최대온도"+vo.getTempMax());
		System.out.println("지역"+vo.getName());
		
		

	}

}
