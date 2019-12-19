package day06;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account a1 = new Account("2019-12-09-001", "홍길동", 10);

		a1.print();

		Account a2 = new Account("2019-02-09-008", "박길동", 7000);

		a2.print();

		Account a3 = new Account();

		a3.print();

	}

}
