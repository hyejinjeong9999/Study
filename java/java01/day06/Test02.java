package day06;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Time t1 = new Time();
		t1.setHour(13);
		t1.setMinute(30);
		t1.setSecond(20);

		t1.print();

	}

}

class Time {

	private int hour;
	private int minute;
	private int second;

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour <= 24)
			this.hour = hour;
		// private hour / 메소드 안의 hour
	}

	public void setMinute(int minute) {
		if (minute >= 0 && minute <= 59)
			this.minute = minute;

	}

	public void setSecond(int second) {
		if (second >= 0 && second <= 59)
			this.second = second;

	}

	public void print() {
		System.out.printf("(%d시 %d분 %d초) %n", hour, minute, second);
	}
	// static은 this 사용 불가능
	// hour, minute, second는 time 클래스의 멤버들 this.hour this.minute..의 생략

}
