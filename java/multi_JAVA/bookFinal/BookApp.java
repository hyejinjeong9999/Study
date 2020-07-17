package bookFinal;






public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println(ㅂ);
			
			switch (key) {
			case value:
				
				break;

			default:
				break;
			}
			
			
			}
			
			
		}
		BookMgr bookList = new BookMgr();

	
		bookList.addBook(new Book("sql", 1500));
		bookList.addBook(new Book("sql3", 12500));
		bookList.addBook(new Book("sql4", 13500));
		bookList.addBook(new Book("java", 12500));
		
		bookList.printBookList();
		
		bookList.printTotalPrice();
		
		bookList.printSearchTitle();
		
		bookList.delete();
		
		bookList.printBookList();

	

	
	

	}

}
