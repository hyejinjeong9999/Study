package chap04;

public class Q02_Gstack<E> {
	private int ptr;
	private int max;
	private E[] stk;

	// 예외처리
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {

		}
	}

	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {

		}
	}

	// 생성자
	Q02_Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}

	}

	// 푸시
	public E push(E x) throws OverflowGstackException {
		if (ptr >= max)
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	// 팝
	public E pop() throws EmptyGstackException {
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	// 피크

	public E peek() throws EmptyGstackException {
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}

}
