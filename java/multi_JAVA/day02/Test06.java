package day02;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 99;
		num = num+1; //100
		
		num += 1 ; 
		//num =num(99)+1  101
		
		
		
		System.out.println(num); //101
		System.out.println(num %10);  //1
		System.out.println(num / 10); //10
		System.out.println(num++);
		System.out.println("=========");
		System.out.println(num);
		
		int jumsu = -70;
		
		boolean flag = jumsu>=0 && jumsu<=100;
		
		
		System.out.println("우수?"+(jumsu>=80));
		System.out.println("유효성?"+flag);
		
		System.out.println("==============");
		System.out.printf("%c => %d %n",'0',(int)'0');
		System.out.printf("%c => %d %n",'a',(int)'a');
		System.out.printf("%c => %d %n",'A',(int)'A');
		System.out.printf("%c => %d %n",'b',(int)'b');
		System.out.printf("%c => %d %n",'B',(int)'B');
		//소문자-32 = 대문자
		
		char c = 'a';
		
		flag = c>='a' || c<='z';
		System.out.printf("소문자니? %b %n" , flag);
		//입력값이 소문자인지 판별
		System.out.println((char)(c-32));
		//소문자->대문자로 변경
		
		
		//<<삼항연산자>>
	
		int score = 60;
		
		String result = score >=70 ? "pass" : "재시험";
		//70점 이상이면 "pass"출력 아니면 "재시험" 출력
		
		System.out.println(score + " : " +result);
		
		System.out.println("=========");
		//소문자일때 대문자로 변환
		char ch = 'D';
		
		char r = (ch>='a'&&c<='z')? (char)(ch-32):(ch>='A'&&ch<='Z')? (char)(ch+32):ch;
		System.out.println(r);
		
		//삼항연산자 뒤에 또 삼항연산자가 올 수 있음
		
		

	}

}
