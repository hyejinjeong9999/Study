package day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test04 {

	public static void main(String[] args) {

	//	List<String> list = new ArrayList<String>();
		// java.util.List 임!!
		// 타입 선언 안하면 Object
		// 내부에서 배열을 관리해주는 List
		List<String> list = new Vector<String>();
		//ArrayList = vector 출력값은 같당
		list.add("홍길동");
		list.add("김길동");
		list.add("박길동");
		list.add("최길동");
		list.add("홍길동"); //중복도 가능합니당
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("고길동?" + list.contains("김길동"));

		System.out.println("--------for--------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("---------Iterator--------");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) { // 읽어올 요소 있으면 받아오기
			String data = it.next(); // data에 값 가져오기
			System.out.println(data.charAt(0) + "**"); // 1번째문자 + **

		}

//		System.out.println("---------Iterator삭제--------");
//		it = list.iterator();
//		String rname = JOptionPane.showInputDialog("삭제할이름기입");
//		it = list.iterator();
//		while (it.hasNext()) {
//			String data = (String) it.next();
//			if (rname.equals(data)) {
//				it.remove();
//			}
//		}
		System.out.println("---------list add---------");
		System.out.println(list);
		list.add(2,"~~~");
		
		System.out.println(list);

	}

}
