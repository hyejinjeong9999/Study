package day09;

public class Test09 {

	public static void main(String[] args) {
		Account account = new Account("홍길동", "001", 1000);
		try {
			account.output(700);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// 시스템에서 받는게 아니라 클라이언츠가 받을 수잇음
			// 클라이언츠가 봐야되는 상황은 클래스상단에 작성우 메인에 try cathch
			// 서버에서 받아야 되는 경우 try catch 안에서 작성
		}

	}

}

class MoneyException extends Exception {
	// 예외처리하려면 필수
	MoneyException() {
		super("계좌잔고예외발생");
	}

	MoneyException(String msg) {
		super(msg);
	}

}

class Account extends Object {
//자동으로 오브젝트 상속후 toString과 equals 오버라이딩
	String name;
	String number;
	int money;

//생성자
	public Account(String name, String number, int money) {
		super();
		this.name = name;
		this.number = number;
		this.money = money;
	}

	public void input(int money) {
		this.money += money;

	}

	public void output(int money) throws MoneyException {
		// 내가 안하고 메소드 호출하는 곳에서 try catch할거야~~
		// 아웃풋이 실행될 때 예외가 발생하루 수 있습니다

		//

		if (this.money < money)
			throw new MoneyException();

		// 이런 경우일때 money exception 생성해서 던져줘

		this.money -= money;

	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", money=" + money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
