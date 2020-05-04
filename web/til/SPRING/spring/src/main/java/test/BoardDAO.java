package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	// 데이터에 직접 접근하는 객체
	public ArrayList<BoardVO> getList() {
		//
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// jdbc driver 로드 //오라클 드라이버 (ojdbc6.jar)

		// sql 정의 - 전송
		// sql 실행 결과 이용
		// dvb 연결해제
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// db정보를 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// jdbc:oracle:this은 고장 : 이후는 IP : 포트 : db명
			PreparedStatement pt = con.prepareStatement("select*from board");

			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				// select 레코드가 있을 때 까지 반복
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
