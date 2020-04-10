package JavaThread.procon;

public class Consumer implements Runnable {
	private SharedObject obj;

	Consumer() {
	}

	Consumer(SharedObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " Cunsumer 시작");

		while (true) {

			if (Thread.currentThread().isInterrupted()) {
				break; //while 문을 빠져나옴
			}

			System.out.println(Thread.currentThread().getName() + "-" + obj.pop());
		}
		System.out.println(Thread.currentThread().getName() + " Thread 종료");

		// 반복적으로 공용객체(Obj)가 가지고 있는 데이터를 뽑아내서 출력
	}

}
