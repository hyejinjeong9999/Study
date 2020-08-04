package book;

public class BookMgr {
	Book[] booklist;
	int cnt = 0; // 알수 없는 배열 개수를 위해 진짜 카운트용 cnt

	public BookMgr() {
		booklist = new Book[10];
		// 생성할 때 10개자리 방 만들기
		// 초기화 생성자
		// 생성자는 리턴타입에 언급하면 오류가 난다
	}

	public BookMgr(int size) { // 사이즈를 설명해주면 사이즈 추가
		booklist = new Book[size];

	}

	public void addBook(Book book) { // book을 booklist에 등록, 배열이 차면 리사이징

		if (booklist.length == cnt) {

			Book[] temp = new Book[booklist.length * 2];

			System.arraycopy(booklist, 0, temp, 0, booklist.length);

			booklist = temp;
			temp = null;

		}

		booklist[cnt] = book;

		cnt++;
	}

	public void printBookList() {
		System.out.println("===책 목록===");
		for (int i = 0; i < cnt; i++) {

			booklist[i].print();
		}
	} // 출력

	public void printTotalPrice() { // 총 금액 출력
		int sum = 0; // 로컬변수 : 반드시 초기화 필요
		System.out.println("===책 가격===");

		for (int i = 0; i < cnt; i++) {
			sum += booklist[i].getPrice();
		}
		System.out.println(sum);

	}

	public void printSearchTitle(String title) {// 검색

		for (int i = 0; i < cnt; i++) {

			if (booklist[i].getTitle().toUpperCase().contains((title.trim().toUpperCase()))) {

				booklist[i].print();
			}

		}

	}
}
