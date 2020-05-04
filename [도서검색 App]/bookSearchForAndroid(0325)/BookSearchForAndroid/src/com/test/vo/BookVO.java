package com.test.vo;

// 이 클래스의 객체는 책의 세부정보를 담을 수 있는 객체
// 객체 1개마다 책 1권의 데이터를 저장할 수 있어요!
// VO를 만드는 기본 원칙은 Database Table을 기반으로 생성.
public class BookVO {	

	// field
	private String bisbn;  // 책의 고유번호(isbn)
	private String btitle;
	private String bdata;
	private int bpage;
	private int bprice;
	private String bauthor;
	private String btranslator;
	private String bsupplement;
	private String bpublisher;
	private String bimgurl;
	private String bimgbase64;
	
	// constructor
	public BookVO() {}   // 인자도 없고 하는일도 없는 default
	                     // 생성자(package에 상관없이 사용가능하도록 
	                     // public을 붙여줘요!!)

	// private field를 사용하기 위한 특수한 형태의 method
	// setter, getter
	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdata() {
		return bdata;
	}

	public void setBdata(String bdata) {
		this.bdata = bdata;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	public String getBimgbase64() {
		return bimgbase64;
	}

	public void setBimgbase64(String bimgbase64) {
		this.bimgbase64 = bimgbase64;
	}
	
	
}





