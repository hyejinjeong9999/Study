package di4;

import java.util.Scanner;

public class ScoreShowImp implements ScoreShow{

	private ScoreImp record;
	
	

	
	public ScoreShowImp() {}
	public ScoreShowImp(ScoreImp record) {
		this.record = record;
	}
	

		

	public ScoreImp getRecord() {
		return record;
	}

	public void setRecord(ScoreImp record) {
		this.record = record;
	}

	
	
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 입력");
		record.setKor(sc.nextInt());
		
		System.out.println("수학 입력");
		record.setEng(sc.nextInt());
		
		System.out.println("영어 입력");
		record.setEng(sc.nextInt());
		
		
	}

	@Override
	public void print() {
		System.out.println("입력값 : "+ record.getKor() +"/"+ record.getMath()+"/"+record.getEng());
		System.out.println( "총점은 :"+record.total());
		System.out.println( "평균은 :"+ record.avg());
		
		
	}

}
