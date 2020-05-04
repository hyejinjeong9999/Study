package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EXAM02_EchoServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(7770);
			System.out.println("서버가 기동되었습니다");

			Socket s = server.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			PrintWriter pr = new PrintWriter(s.getOutputStream());

			String msg = "";
			while (true) {
				msg = br.readLine(); // 비정상 종료됐을때 exception 발생함
				if ((msg == null) || (msg.equals("@EXIT"))) {
					break;
				}
				pr.println(msg);
				pr.flush();

			}
			if (pr != null)
				pr.close();
			if (br != null)
				br.close();
			if (s != null)
				s.close();
			if (server != null)
				server.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("비정상종료");
		}

	}
}
