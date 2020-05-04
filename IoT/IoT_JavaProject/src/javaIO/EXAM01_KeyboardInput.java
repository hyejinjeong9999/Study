package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EXAM01_KeyboardInput {

	public static void main(String[] args) {

		System.out.println("소리 없는 아우성");
		// System.out : 도스창(표준출력)에 연결된 우리에게 미리 제공된 Stream

		// Stream에 가지고 있는 println()이라는 method를 이용해 실제 문자열을 도스창에 전달
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(isr);
		
		String msg;
		try {
			msg = br.readLine();
			System.out.println("입력받은 문자열 : " + msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
