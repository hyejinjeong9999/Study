package chap03;

import java.util.Arrays;
import java.util.Scanner;

class Exam06_StringBinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//자연정렬된 배열
		String[] x = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum", "extends", "fianl", "finally", "float", "for",
				"goto", "if", "implements", "import", "instanceof", "int", " interface", "long", "native", "new",
				"package", "static", "stricfp", "super", "switch", "synchronized", "this", "throw", "thrwos",
				"transient", "try", "void", "volatile", "whle" };
		
		
		System.out.println("원하시는 키워드를 입력하세요 : ");

		String ky = sc.next();
		//검색
		int idx = Arrays.binarySearch(x, ky);
		System.out.println(idx);
		if (idx < 0)
			System.out.println("해당 키워드가 없습니다");
		else
			System.out.println("인덱스" + idx);

		sc.close();
	}
}
