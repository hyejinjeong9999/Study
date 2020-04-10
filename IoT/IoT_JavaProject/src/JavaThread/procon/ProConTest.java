package JavaThread.procon;

public class ProConTest {


	public static void main(String[] args) {
		SharedObject obj = SharedObject.getInstan();
			//static메서드를 이용해서 new를 안하소고 바로 이용 가능
		
		Thread producer = new Thread(new Producer(obj));
		Thread con1 = new Thread(new Consumer(obj));
		Thread con2 = new Thread(new Consumer(obj));
		Thread con3 = new Thread(new Consumer(obj));
		
		
		//각 Thread 시작 3
		con1.start();
		con2.start();
		con3.start();
		
		producer.start();
		
		
		try {
			Thread.sleep(2);  //0.002초동안 main Thread를 잠깐 쉼 => producer Thread를 2초만 구동시킴
			
			producer.interrupt();
			Thread.sleep(2);
			
			con1.interrupt();
			con2.interrupt();
			con3.interrupt();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//중지시키기
	
	}

}
