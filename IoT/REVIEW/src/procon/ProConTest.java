package procon;

public class ProConTest {

	public static void main(String[] args) {
		
		SharedObject obj = SharedObject.getObject();
		 
		Thread p1 = new Thread(new Producer(obj));
		Thread c1 = new Thread(new Consumer(obj));
		Thread c2 = new Thread(new Consumer(obj));
		Thread c3 = new Thread(new Consumer(obj));
		 
		
		p1.start();
		c1.start();
		c2.start();
		c3.start();
		
		
		try {
			Thread.sleep(2);
			p1.interrupt();
			Thread.sleep(2);
			c1.interrupt();
			c2.interrupt();
			c3.interrupt();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
