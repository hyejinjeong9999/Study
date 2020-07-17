package day06;

import java.util.Arrays;

import day05.Calc; // 임포트
import util.MyUtil;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Calc.add(1, 1, 2, 5, 6, 7));
		System.out.println(Calc.add(1, 1, 1));

		System.out.println();

		int[] d = { 1, 21, 3, 43, 15, 6, 7, 8, 9, 10 };

		int [] r = MyUtil.sort(d);
		
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(r));

	}

}
