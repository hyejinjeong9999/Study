package chap04;

public class Q07_Dequeue {
	private int max; // 덱(deck)의 용량
	private int num; // 현재의 데이터 수
	private int front; // 맨 앞 커서
	private int rear; // 맨 뒤 커서
	private int[] que; // 덱(deck)의 본체

	// 실행할 때 예외：큐가 비어 있음
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}
	
	// 생성자
		public Q07_Dequeue(int capacity) {
			num = front = rear = 0;
			max = capacity;
			try {
				que = new int[max]; // 덱(deck)본체용 배열을 생성
			} catch (OutOfMemoryError e) { // 생성할 수 없습니다
				max = 0;
			}
		}
		
		//앞쪽부터 값을 채우는 인큐<= 이방향
		public int enqueFront(int x) throws OverflowIntDequeException {
			if (num >= max)
				throw new OverflowIntDequeException(); // 덱(deck)이 가득 참
			num++;
			if (--front < 0) //front가 맨 앞일 때 front가 뒤로 이동
				front = max - 1;
			que[front] = x;
			return x;
		}
		
		//뒤쪽으로 값을 넣는 인큐 => 이방향
		public int enqueRear(int x) throws OverflowIntDequeException {
			if (num >= max)
				throw new OverflowIntDequeException(); // 덱(deck)은 가득 참
			que[rear++] = x;// 뒤에 값을 넣음
			num++;
			if (rear == max) //rear가 맨 뒤로 이동할 경우 앞으로 이동
				rear = 0;
			return x;
		}
		
		// 덱(deck)의 머리부터 데이터를 디큐
		public int dequeFront() throws EmptyIntDequeException {
			if (num <= 0)
				throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
			int x = que[front++]; //맨 앞값 꺼내기
			num--;
			if (front == max) //front가 맨 뒤면 앞으로 이동
				front = 0;
			return x;
		}

		// 덱(deck)의 꼬리부터 데이터를 디큐
		public int dequeRear() throws EmptyIntDequeException {
			if (num <= 0)
				throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
			num--;
			if (--rear < 0) //감소시긴 rear가 0보다 작으면 맨 뒤임
				rear = max - 1;
			return que[rear]; //맨 뒷값 
		}
		// 덱(deck)의 머리부터 데이터를 피크(머리데이터를 살펴봄)
		public int peekFront() throws EmptyIntDequeException {
			if (num <= 0)
				throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
			return que[front];
		}

		// 덱(deck)의 꼬리부터 데이터를 피크(꼬리데이터를 살펴봄)
		public int peekRear() throws EmptyIntDequeException {
			if (num <= 0)
				throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
			//rear가 0이면 맨 뒷값, 아니면 rear-1
			return que[rear == 0 ? max - 1 : rear - 1];
		}

		// 덱(deck)에서 x를 검색하여 index(찾지 못하면 -1)를 반환
		public int indexOf(int x) {
			for (int i = 0; i < num; i++)
				if (que[(i + front) % max] == x) // 검색성공
					return i + front;
			return -1; // 검색실패
		}

		// 덱(deck)에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 0)를 반환
		public int search(int x) {
			for (int i = 0; i < num; i++)
				if (que[(i + front) % max] == x) // 검색성공
					return i + 1;
			return 0; // 검색실패
		}

		// 덱(deck)을 비움
		public void clear() {
			num = front = rear = 0;
		}

		// 덱(deck)의 용량을 반환
		public int capacity() {
			return max;
		}

		// 덱(deck)에 쌓인 데이터 수를 반환
		public int size() {
			return num;
		}

		// 덱(deck)이 비어 있는가?
		public boolean isEmpty() {
			return num <= 0;
		}

		// 덱(deck)이 가득 찼는가?
		public boolean isFull() {
			return num >= max;
		}

		// 덱(deck)내의 데이터를 머리→꼬리의 차례로 나타냄
		public void dump() {
			if (num <= 0)
				System.out.println("덱(deck)이 비었습니다.");
			else {
				for (int i = 0; i < num; i++)
					System.out.print(que[(i + front) % max] + " ");
				System.out.println();
			}
		}

	
	
}
