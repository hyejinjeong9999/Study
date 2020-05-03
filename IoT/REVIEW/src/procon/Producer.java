package procon;

public class Producer implements Runnable{
	private SharedObject obj;
	
	Producer(){}
	Producer(SharedObject obj){
		this.obj = obj;
	}

	@Override
	public void run() {
		System.out.println("생성자thread 시작");
		int i = 1;
		while(!(Thread.currentThread().isInterrupted())) {
			obj.push(new Integer(i++).toString());
		}
		System.out.println("Producer가 종료");
		
	}

}
