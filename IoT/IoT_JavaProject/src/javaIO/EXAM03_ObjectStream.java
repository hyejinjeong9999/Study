package javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class EXAM03_ObjectStream {
	
	public static void main(String[] args) {
		//로직처리를 통해서 만들어진 데이터 구조를 준비
		//최종 결과 데이터가 HashMap으로 만들어 졋다고 가정
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1","홍길동");
		map.put("2","김길순");
		map.put("3","박길훈");
		map.put("4","최길석");
		File file = new File("asset/StringData.txt");
		//대표적인 입력 Stream : Buffered Reader
		//대표적인 출력 Stream : PrintWirter
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos); //객체를 그냥 저장할 수 있음
			oos.writeObject(map);
			oos.flush();
			oos.close();
			fos.close();
//			PrintWriter pr = new PrintWriter(file);
//			pr.print("이것은 소리없는 아우성!!");
//			pr.flush(); //통로에서 실제 데이터를 보낸다
//			pr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
