package day06;

import javax.swing.JOptionPane;

public class AccountTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account[] accounts = { new Account("2019-12-09-001", "홍길동", 10), new Account("2019-02-09-008", "박길동", 7000),
				new Account("2019-12-09-001", "김길동", 1000), new Account("2019-02-09-011", "최길동", 400),
				new Account("2019-12-09-044", "이길동", 18), new Account("2019-02-09-021", "정길동", 700),

		};

		System.out.println("Account 검색");
		String name = JOptionPane.showInputDialog("검색할 이름을 입력해주세요");
		// 입력 받음

		for (int i = 0; i < accounts.length; i++) {

			if (name.trim().equalsIgnoreCase(accounts[i].getName())) {

				accounts[i].print();
				return;
			}

		}

	}

}
