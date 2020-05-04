package JavaThread;

//하나의 java파일에서는 public이 붙는 class는 오직 한개만 존재할 수 있다
class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i의 값은 " +i);
		}

	}

}

public class Thread_State {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();		//Runnable 객체 생성
		Thread t1 = new Thread(runnable); 			//Thread  객체 생성
		Thread t2 = new Thread(runnable); 			//Thread  객체 생성
		
		t1.start();									//Thread 실행
		t2.start();	
		
//		t1.start();									//오류! 한번 실행한 thread는 재사용불가

	}

}
