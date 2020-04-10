package JavaThread.procon;

import java.util.LinkedList;

public class SharedObject {
	
	private static final Object MONITOR = new Object();
	
	
	private static SharedObject obj = new SharedObject(); // 객체를 하나 만듦
	// 메서드가 static -> 사용되는 객체도 static으로

	// 숫자를 저장하는 자료구조 생성
	private LinkedList<String> list = new LinkedList<String>();

	private SharedObject() {
	};
	// 우리 클래스에서만 생성자 사용할 수 있게
	// 객체를 못만들게 하기 위해

	public static SharedObject getInstan() {
		// return new SharedObject() getInstance를 호출할때마다 객체 계속 생성 -> singleton에 어긋남
		return obj; // 만들러놓은 "하나의" 객체를 내보냄
	}

	// 생산자 Thread에 사용되는 method
	public void put(String s) {
		
		synchronized (MONITOR) {
			list.addLast(s);
			MONITOR.notify();
		}


	}

	// FIFO 방식으로
	public String pop() {

		String result = null;
		
		synchronized (MONITOR) {
			
			if (list.isEmpty()) {
				
				try {
					MONITOR.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {

				result = list.removeFirst();
			}
			
			
		}

		
		return result;

	}
}
