package day08;

public class Test06 {

	public static void main(String[] args) {
		//Animal a = new Animal(); 
		
		Animal[] a= new Animal[10];//타입선언 가능
		
		

	}

}

class Product{
	
	String number;
	int price;
	
}

class TV extends Product{
	
}

class Computer extends Product{
	
}

class Buyer{
	
	void buy(Product P ){} //부모타입 으로 선언 딱 :  
	void buy (Computer i) {} //메소드 오버로딩
	
}