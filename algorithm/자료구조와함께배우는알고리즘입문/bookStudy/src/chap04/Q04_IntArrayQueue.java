package chap04;

public class Q04_IntArrayQueue {
	private int max; //큐 용량
	private int num; //현재 데이터 수
	private int front; //첫번째 데이터 수
	private int rear; //마지막 요소 커서
	private int[]que;//큐본체

	//생성자
	public Q04_IntArrayQueue(int max) {
		this.max = max;
		num = 0;
		front = 0;
		rear = 0;
		que = new int[max];
		
	}
	
	//인큐
	
	public int inque(int x) {
		if(num >=max) 
			System.out.println("queue가 가득 참");
		que[rear++] = x;
		num++;
		if(rear == max) 
			rear = 0;
		return x;
	}
	
	//디큐
	public int dequeue() {
		if(num<=0){
			System.out.println("queue가 비어 있음");
		}
		int x = que[front++];
		num--;
		if(front == max)
			front = 0;
		return x;
	}
}
