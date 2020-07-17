package day09;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("start");

		String msg = "-5";
		int num = 100;
		int res = 0;

		try {

			num = Integer.parseInt(msg);
			res = 1000 / num;
			int[] number = new int[num];
		} catch (NumberFormatException e) {
			System.out.println("문제발생 : " + e);
			System.out.println("숫자로 입력된 문자열이 필요합니다");

		} catch (ArithmeticException e) {

			System.out.println("0을 제외한 숫자로 숫자로 입력된 문자열로 입력하세요");

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("문제발생");

		} finally {// 예외가 발생하든 방생하지 않든 수행
			System.out.println("자우너받납코드 항상 수행");

		}

		System.out.println(num);
		System.out.println(res);
		System.out.println("end");

	}

}
