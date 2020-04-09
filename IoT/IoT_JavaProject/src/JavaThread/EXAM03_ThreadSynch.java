package JavaThread;

//공유객체를 만들기 위한 class define
//일반적으로 singleton으로 만들어진다 ((지금은 singleton 사용안함))
class sharedObject {
	// Thread가 공유해서 사용하는 공유객체는 Thread가 사용하는 데이터의 로직을 포함하고 있다

	private int number;
	private Object monitor = new Object();
	
	// thread에 의해서 공유되는 field
	// 일반적으로 private으로 처리되기 때문이 이 filed를 이용하기 위해서 당연히 setter와 getter 필요

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		//동기화가 필요 없는 코드
		System.out.println("소리없는 아우성");
		//동기화가 필요한 코드
		//모니터가 필요함
		synchronized (monitor) {
			this.number = number;

			try {
				Thread.sleep(1000);
				System.out.println("현재 number : " + getNumber());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("테스트");
	}

}

class NumberRunnable implements Runnable {

	private sharedObject obj;
	private int number;

	NumberRunnable() {
	} // 기본 생성자

	// 공유객체를 받아들여서 저장하는 생성자 작성
	// constructor injection
	NumberRunnable(sharedObject obj, int number) {
		this.obj = obj;
		this.number = number;

	}

	@Override
	public void run() {
		// 공유객체가 가지는 기능을 이용해서 숫자를 출력
		obj.setNumber(number);

	}

}

public class EXAM03_ThreadSynch {

	// 프로그램의 entry point
	public static void main(String[] args) {

		// Thread에 의해서 공유되는 공유객체 한개를 생성
		// 일반적으로 공유객체는 class로부터 객체가 딱 한개만 생성되는 형태로 만들어짐
		// singleton pattern
		// Thread는 로직처리를 공유객체를 이용해서 로직처리를 하고 데이터 처리 역시 공유객체를 통해서 처리
		// 실제 일은 Thread가 가지고 있는 공유객체

		sharedObject obj = new sharedObject();

//		Thread를 생성하기 위해서 Runnable interface를 구현한 객체가 있어야 함
//		그래서 Runnable interface를  구현한 객체를 만들기 위한 class를 define

		NumberRunnable r1 = new NumberRunnable(obj, 100);
		NumberRunnable r2 = new NumberRunnable(obj, 200);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}
