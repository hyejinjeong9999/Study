package day06;

public class Account {

	// 1. 데이터와 기능 나누기
	// 명사 / ~하다
	/**
	 * @author 정혜진
	 * @since 2019.12
	 */

	private String name;
	private String number;
	private int money;

	public Account() {
	
		this("","",0);
		//나와 같은 생성자호출(3개의 파라미터짜리로), 코드중복 회피를 위해
//		setNumber("");
//		setName("");
//		setMoney(0);
//		
		
	
	}

	public Account(String num, String name, int money) {

		setNumber(num);
		setName(name);
		setMoney(money);
	}

	// 중요한정보 -> 인캡슐레이션 : 외부에서 노출 안되게

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	/*
	 * @param money 입금금액
	 */

	public void intput(int money) {// 메소드의 선언부
		if (money > 0)
			this.money += money; // 메소드의 구현부

	}
	/*
	 * @param money 출금금액
	 * 
	 * @return 출금액
	 */

	public int output(int money) {
		if (this.money <= money) {
			return 0;
		} else {
			this.money -= money;
		}

		return money;
	}

	/**
	 * 계좌정보 출력
	 */
	public void print() {

		System.out.printf("%s님의 계좌번호 %s 의 잔고는 %d원 입니다 %n", name, number, money);
	}

	/**
	 * 
	 * @param from        출금계좌
	 * @param to          입금계좌
	 * @param money계좌이체금액
	 */
	public static void transfer(Account from, Account to, int money) {
		System.out.println("계좌이체");
		System.out.println(from.number + "->" + to.number);
		to.intput(from.output(money));

	}// this 사용 안함으로 static 사용 가능

}
