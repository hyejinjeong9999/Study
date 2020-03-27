package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Database 처리 전문 class
// JDBC의 처리 순서
// 1. 내가 사용하는 DMBS에 Driver Loading
// 2. Connection (데이터베이스 연결)
// 3. Statement 생성
// 4. Query 실행(SQL문을 실행)
// 5. 결과처리
// 6. 사용한 Resource 해제(Database close)

// Transaction(일의 최소단위)
// 이체 ( A로부터 B한테 5000원을 이체 )
// 1. A계좌에 5000원이 있는지 select
// 2. B계좌가 존재하는지 확인 select
// 3. A계좌의 잔액에서 5000원을 차감 update
// 4. B계좌의 잔액에서 5000원을 증가 update
// ===> 왜 코드상에서 Transaction을 설정해야 하는가?????
// Transaction을 설정하면 DBMS에서 ACID를 보장받을 수 있어요!!
// ACID ( Atomicity, Consistency, Isolation, Durability )
// Atomicity : all or nothing


public class BookDAO {

	// 단위 Database 처리를 담당
	public ArrayList<String> select(String keyword) {
		// JDBC에 대한 기본 처리를 해보아요!!
		// Database 연결과 Driver Loading은 JNDI를 이용해 보아요!
		// 제공된 context.xml 파일을 webContent > META-INF 폴더안에
		// 저장해요!!
		Connection con = null;
		// 결과가 저장될 ArrayList를 생성
		ArrayList<String> result = 
				new ArrayList<String>();
		try {
			// Database 연결
			Context initContext = new InitialContext(); 
			DataSource ds = 
					(DataSource)initContext.lookup("java:comp/env/jdbc/mySQLDB");
			// Database Connection 획득
			con = ds.getConnection();
			
			// SQL문장을 만들어요!
			String sql = 
					"select btitle from book where btitle like ?";
			// SQL문장을 Database에서 실행시키 위해서 PreparedStatement생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?를 채워서 SQL문장을 완성!!
			pstmt.setString(1, "%" + keyword + "%");
			
			// SQL문장을 실행한 후 결과를 ResultSet으로 받아와요!
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				result.add(rs.getString("btitle"));
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}






