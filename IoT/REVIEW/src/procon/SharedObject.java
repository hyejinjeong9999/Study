package procon;

import java.util.LinkedList;

public class SharedObject {
	
	private static final Object MONITOR = new Object();
	
	private SharedObject() {}
	
	private LinkedList<String>list = new LinkedList<String>();
	
	private static SharedObject obj = new SharedObject();
	
	
	public static SharedObject getObject() {
		return obj;
	}
	
	public void push(String s) {
		synchronized (MONITOR) {
			list.addLast(s);
			MONITOR.notify();
			
		}
		
		
	}
	
	public String pop() {
		synchronized (MONITOR) {
			
			if(list.isEmpty()) {
				try {
					MONITOR.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return list.removeFirst();
		}
	}
	

}
