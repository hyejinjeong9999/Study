package day09;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class Test06 {

	public static void main(String[] args) {

		System.out.println("start");
		try {
			Thread.sleep(7000);
			// 멈춘 후 7초 후 진행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("--------------");

		try {
			throw new Exception("예외실습~~");
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(e.getMessage());
		}

		System.out.println("end");

	}

}
