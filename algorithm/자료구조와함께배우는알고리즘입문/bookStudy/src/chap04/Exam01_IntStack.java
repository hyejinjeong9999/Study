package chap04;

public class Exam01_IntStack {
	private int max; // 스택 용량
	private int ptr; // 스택 포인터
	private int[] stk; // 스택 본체

	// 스택이 비어있을 때 실행 예외
	public class EmptyIntStackExeption extends RuntimeException {

		public EmptyIntStackExeption() {
		}

	}

	// 스택이 가득 찼을때 실행 예외
	public class OverflowIntStackException extends RuntimeException {

		public OverflowIntStackException() {
		}
	}
	
	//생성자
	public Exam01_IntStack(int capacity) {
		ptr = 0;
		max = capacity; //설정한 용량만큼 생성
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) { //생성할 수 없을 때 예외처리
			max = 0;
		}
	}
	//스택에 데이터를 push :  값을 넣은후 포인터 ++
	//스택이 가득 차서 push하지 못하는 경우 예외처리
	public int push(final int x) throws OverflowIntStackException {
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
 
	//스택에 데이터를 pop : 포인터의 위치 앞으로
	//스택이 비어있어서 pop을 못하는 경우 예외처리
	public int pop() throws EmptyIntStackExeption {

		if (ptr <= 0)
			throw new EmptyIntStackExeption();

		return stk[--ptr];
	}

	//스택의 꼭데기에 있는 데이터를 봄 : 포인터 -1값을 봄
	//스택이 비어있는 경우 예외발생
	public int peek() throws EmptyIntStackExeption {
		if (ptr <= 0)
			throw new EmptyIntStackExeption();
		return stk[ptr - 1];
	}
	
	//검색 x : x값을 찾아서 거꾸로 내려감
	//같은 값의 데이터가 있을 경우 후에 넣은 데이터를 알려줘야 함
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			if (stk[i] == x)
				return i;
		return -1;
	}
	//스택에 쌓여있는 데이터 삭제
	//ptr을 0으로
	public void clear() {
		ptr = 0;
	}
	//저장용량 반환
	public int capacity() {
		return max;
	}
	//현재 사이즈 반환, 포인터 값 보여주면 됨
	public int size() {
		return ptr;
	}

	//비어있는지 확인
	public boolean isEmpty() {
		return ptr <= 0;
	}
	//스택이 가득 찼는지 확인
	public boolean isFull() {
		return ptr >= max;
	}
	//스택 안에 쌓여있는 모든 데이터 출력
	//바닥 -> 꼭데기
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어있습니다");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}

	}

}
