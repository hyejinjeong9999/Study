package javaNetworkReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EXAM02_EchoServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 가동되었습니다");
			Socket s = server.accept();
			System.out.println("클라이언트가 접속");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			
			String msg ="";
			while(true) {
				msg = br.readLine();
				if(msg=="" || msg.equals("@EXIT")) break;
				
				pr.println(msg);
				pr.flush();
			
			}
			if(pr != null) pr.close();
			if(br != null) br.close();
			if(s != null) s.close();
			if(server != null) server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
