package day08;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Point{
	int x;
	int y;
	
}

class Circle2 {
	int x;  
	int y; 
	//point에 이미 있음 가져다 쓰고싶음 
	//extentd 사용 -> 하지만 그후 아무것도 상속 못받음
	//is a 관계가 성립되야되는데 성립안됨
	//has a 관계가 더 적합함
	
	Point p; 
	//has a 관계!
	int r;
	
}


