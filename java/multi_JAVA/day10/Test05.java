package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import util.MyUtil;

public class Test05 {

	public static void main(String[] args) {
		//Set<String> set = new HashSet<String>();
		// hashset : 복주머니
		// tree : 정렬된 주머니
		
		Set<String> set = new TreeSet<String>();
		//정렬되서 관리
		set.add("lee");
		set.add("kim");
		set.add("park");
		set.add("ko");
		set.add("lee"); // 같은 데이터-> 중복안됨
		
		MyUtil.iteratorPrint(set);

		Iterator<String> it = set.iterator();

//		while (it.hasNext()) {
//			String data = (String) it.next();
//			System.out.println(data + "");
//		}
		System.out.println();

	};

}
