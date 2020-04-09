package JavaThread;

class Shared {

	public synchronized void printNum() {
		// Thread의 이름과 숫자를 찍어주는 로직 처리

		for (int i = 0; i < 10; i++) {

			System.out.println(i + " : " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000);
				notify();  //wait으로 block으로 block되어있는 Thread를 깨우는 method
				wait();		//자기가 가지고 있는 monitor를 반납하고 자기자신을 wati block 시키는 method
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class PrintRunnable implements Runnable {
	private Shared obj;

	PrintRunnable() {
	}

	PrintRunnable(Shared obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		obj.printNum();

	}

}

public class EXAM04_ThreadWaitNotify {

	public static void main(String[] args) {

		Shared obj = new Shared(); // 공용객체 생성

		PrintRunnable r1 = new PrintRunnable(obj);
		PrintRunnable r2 = new PrintRunnable(obj);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}
