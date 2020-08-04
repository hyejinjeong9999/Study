package chap04;

import chap04.Exam03_IntQueue.EmptyIntQueueException;
import chap04.Exam03_IntQueue.OverflowIntQueueException;

public class Q06_GQueue<E> {
	private int max; // 큐의 용량
	private int front; // 맨 앞 요소
	private int rear; // 마지막 요소 커서
	private int num; // 현재 데이터 수
	private E[] que; // queue 본체
	// 큐가 비어있을 때

	public static class EmptyGqueueException extends RuntimeException {
		public EmptyGqueueException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public static class OverflowGqueueException extends RuntimeException {
		public OverflowGqueueException() {
		}
	}

	// 생성자 : 초기화
	public Q06_GQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = (E[]) new Object[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

	// enqueue 값을 넣음
	public E enqueue(E x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowGqueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// dequeue 값을 뺌 (맨 앞 값)
	public E deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// peek : 맨 앞의 데이터를 봄
	public E peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		return que[front];
	}

	// indexOf : 큐에서 x를 검색하여 인덱스를 반환
	public int indexOf(E x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x) // 검색성공
				return i + front;
		return -1; // 검색실패
	}

	// clear : queue를 비움
	public void clear() {
		num = front = rear = 0;

	}

	// capacity : 용량
	public int capacity() {
		return max;
	}

	// size : 현재 용량
	public int size() {
		return num;
	}

	// isEmpty : 비었는지
	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max].toString() + " ");
				System.out.println();
			}
		}
	}

}
