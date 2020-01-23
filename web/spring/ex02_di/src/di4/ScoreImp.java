package di4;

public class ScoreImp implements Score {

	private int kor, eng, math;

	public ScoreImp() {
		this(0, 0, 0);
	} // 디폴트 생성자 : 기본 값 0,0,0

	//construtor 이용한 DI
	public ScoreImp(int kor, int eng, int math) {// 매개변수 있는생성자
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	@Override
	public int total() {

		return this.kor + this.eng + this.math;
	}

	@Override
	public double avg() {
		// TODO Auto-generated method stub
		return total() / 3.0f;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
