package chap04;

public class Exam03_IntQueue {

	private int max; //큐의 용량
	private int front; //맨 앞 요소
	private int rear; //마지막 요소 커서
	private int num; //현재 데이터 수
	private int[] que; //queue 본체
	//큐가 비어있을 때
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	//큐가 가득 차 있을때
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	//생성자 : 초기화
    public Exam03_IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }
    
    //enqueue 값을 넣음
    public int enqueue(int x) throws OverflowIntQueueException{
        if(num >=max)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if(rear == max)
            rear = 0;
        return x;
    }
    //dequeue 값을 뺌 (맨 앞 값)
    public int deque() throws EmptyIntQueueException{
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if(front ==max)
            front = 0;
        return x;
    }
    
    //peek : 맨 앞의 데이터를 봄
    public int peek() throws EmptyIntQueueException{
    	if(num<=0)
    		throw new EmptyIntQueueException();
    	return que[front];
    }
    
    //indexOf : 큐에서 x를 검색하여 인덱스를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x) // 검색성공
				return idx;
		}
		return -1; // 검색실패
	}
    
    //clear : queue를 비움
    public void clear(){
        num = front = rear =0;
    
    }
    //capacity : 용량
    public int capacity(){
        return max;
    }
    //size : 현재 용량
    public int size(){
        return num;
    }
    //isEmpty : 비었는지
    public boolean isEmpty(){
        return num <=0;
    }
    
    public boolean isFull(){
        return num>=max;
    }
    
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비었습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}

    
    
	
}
