package day07;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object f = new Fish();
		Animal f1 = new Fish();
		Fish f2 = new Fish("쿠피");
		
		f2.print();
		
		((Fish)f1).print(); //다운캐스팅
		
		System.out.println(f1.kind);
		System.out.println(((Fish)f1).kind);
		
		f2.breath();
		f1.breath();
		//물고기인데 폐로 숨..-> 잘못된 기능

	}

}
