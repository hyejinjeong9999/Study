package javaNetworkReview;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// 서버쪽 프로그램
// 클라이언트가 접속하면 현재 시간을 알아내서
// 클라이언트에게 전송하는 서버 프로그램

public class EXAM01_DateServer {

	// 프로그램의 entry point
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(5555);
			System.out.println("서버가 생성됨");
			Socket s = server.accept();
			System.out.println("클라이언트가 접속함");
			String date = (new Date()).toLocaleString();
			
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			out.println(date);
			out.flush();
			out.close();
			s.close();
			server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
}





