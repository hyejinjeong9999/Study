package JavaThread.procon;

public class Producer implements Runnable {

	private SharedObject obj;

	Producer() {
	}

	Producer(SharedObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		// 생성자 Thread하는 일을 여기에 명시

		System.out.println("생성자Thread 시작");
		int i = 1;
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			obj.put(new Integer(i++).toString());
		}
		System.out.println("Producer가 종료되었어요");

	}

}
