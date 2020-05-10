package procon;

public class Consumer implements Runnable{
	
	private SharedObject obj;
	Consumer(){}
	Consumer(SharedObject obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + "Consumer 시작");
		
		while(!(Thread.currentThread().isInterrupted())) {
			System.out.println(Thread.currentThread().getName()+"-"+obj.pop());
		}
		System.out.println(Thread.currentThread().getName()+"Thread 종료");
		
		
	}

}
