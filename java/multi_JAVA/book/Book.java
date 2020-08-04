package book;

public class Book {

	private String title;
	private int price;
	// 연산이 가능해야함 정수/실수 타입
	// 인캡슐레이션 : private로 막기
	// private : 같은 클래스 안에서만 사용 가능
	// defalut : 같은 패키지 안에서만 사용 가능
	// public : import하면 어디서나 사용 가능

	public Book() {

	} // 기본생성자

	public Book(String title, int price) {
		// super();
		this.setTitle(title);
		this.setPrice(price);

	}

	// getter, setter생성

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void print() {
		System.out.printf("제목: %s가격 : %d %n", title, price);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
