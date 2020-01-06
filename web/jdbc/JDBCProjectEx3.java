package ex01.jdbc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbConn.util.ConnectionHelper;

//jdbc7 이후 fx이용해서 인터페이스 구현.
//ctrl+shift+o import 필요값들, 쓸모없는것들 처리.
public class JDBCProjectEx3 extends JFrame implements ActionListener {
	// component 객체 선언
	JPanel panWest, panSouth; // 왼쪽텍스트필드, 아래쪽 버튼
	JPanel p1, p2, p3, p4, p5;
	JTextField txtNo, txtName, txtEmail, txtPhone;
	JButton btnTotal, btnAdd, btnDel, btnSearch, btnCancel;

	JTable table; // 검색과 전체 보기를 위한 테이블 객체 생성
	// 상태변화를 위한 변수 선언
	private static final int NONE = 0;
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	int cmd = NONE;

	MyModel model; // 객체 선언.

	public JDBCProjectEx3() { // 생성자함수 떠도는값 잡기 or 초기화 담당.
		// component 등록
		panWest = new JPanel(new GridLayout(5, 0)); // 행 5개
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JLabel("번    호"));
		p1.add(txtNo = new JTextField(12));
		panWest.add(p1);

		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(new JLabel("이    름"));
		p2.add(txtName = new JTextField(12));
		panWest.add(p2);

		p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(new JLabel("이  메  일"));
		p3.add(txtEmail = new JTextField(12));
		panWest.add(p3);

		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(new JLabel("전화번호"));
		p4.add(txtPhone = new JTextField(12));
		panWest.add(p4);

		p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add(new JLabel(""));
		panWest.add(p5);

		add(panWest, "West"); // 추가 메서드.

		// button 화면 아래 등록
		panSouth = new JPanel();
		panSouth.add(btnTotal = new JButton("전체보기"));
		panSouth.add(btnAdd = new JButton("추     가"));
		panSouth.add(btnDel = new JButton("삭     제"));
		panSouth.add(btnSearch = new JButton("검     색"));
		panSouth.add(btnCancel = new JButton("취     소"));
		add(panSouth, "South");

		// event 처리 이벤트 추가. 버튼 클릭
		btnTotal.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancel.addActionListener(this);

		// 테이블 객체 생성
		add(new JScrollPane(table = new JTable()), "Center");
		// close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 메인 창 출력
		setBounds(100, 100, 700, 300); // setSize(W,H); pack();
		setVisible(true);

		dbConnect(); // db 연결 함수 호출
		total();
	} // constuctor end

	//////////////// db setting ////////////////////

	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtTotal, pstmtTotalScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll;

	private String sqlInsert = "INSERT INTO CUSTOMERS VALUES(?,?,?,?)"; // ctrl + shift + x 대문자 변경.
	private String sqlDelete = "DELETE FROM CUSTOMERS WHERE NAME = ?";
	private String sqlTotal = "SELECT * FROM CUSTOMERS";
	private String sqlSearch = "SELECT * FROM CUSTOMERS WHERE NAME = ?";

	public void dbConnect() {
		try {
			conn = ConnectionHelper.getConnection("oracle"); // alt 왼쪽 방향키 -> ctrl클릭 복귀.
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtSearch = conn.prepareStatement(sqlSearch);

			pstmtTotalScroll = conn.prepareCall(sqlTotal, ResultSet.TYPE_SCROLL_SENSITIVE, // 커서 이동을 자유롭게하고 업데이트 내용을
																							// 반영한다.
					ResultSet.CONCUR_UPDATABLE // resultset object의 변경이 가능.
			// ResultSet.CONCUR_READ_ONLY // CONCUR_UPDATABLE 의 반대.
			); // 반환값 있음 execute query
			pstmtSearchScroll = conn.prepareCall(sqlSearch, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end dbConnect()

	////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnAdd) {
			if (cmd != ADD) {
				setText(ADD); // user method
				return;
			} // if in
			setTitle(e.getActionCommand());

			add();

			// 추가

		} else if (obj == btnDel) {
			if (cmd != DELETE) {
				setText(DELETE); // user method
				return;
			} // if in
			setTitle(e.getActionCommand());

			del(); // 삭제

		} else if (obj == btnSearch) {
			if (cmd != SEARCH) {
				setText(SEARCH); // user method
				return;
			} // if in
			setTitle(e.getActionCommand());

			search(); // 검색

		} else if (obj == btnTotal) {
			setTitle(e.getActionCommand());
			total(); // 전체보기
		}
		setText(NONE);
		init(); // 초기화 메소드, user method
	}// actionPerformed end

	private void init() { // 초기화 메소드
		txtNo.setText("");
		txtNo.setEditable(false);
		txtName.setText("");
		txtName.setEditable(false);
		txtEmail.setText("");
		txtEmail.setEditable(false);
		txtPhone.setText("");
		txtPhone.setEditable(false);
	}// init() end

	private void setText(int command) {
		switch (command) {
		case ADD:
			txtNo.setEditable(true);
			txtName.setEditable(true);
			txtEmail.setEditable(true);
			txtPhone.setEditable(true);
			break;
		case DELETE:
		case SEARCH:
			txtName.setEditable(true);
			break;
		}// switch end

		setButton(command); // user method
	}// setText() end

	private void setButton(int command) {
		// cancel button 제외하고 어떤 버튼이 눌리더라도 모든 버튼이 비활성화
		btnTotal.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnSearch.setEnabled(false);

		switch (command) {
		case ADD:
			btnAdd.setEnabled(true);
			cmd = ADD;
			break;
		case DELETE:
			btnDel.setEnabled(true);
			cmd = DELETE;
			break;

		case SEARCH:
			btnSearch.setEnabled(true);
			cmd = SEARCH;
			break;
		case TOTAL:
			btnTotal.setEnabled(true);
			cmd = TOTAL;
			break;
		case NONE:
			btnTotal.setEnabled(true);
			btnAdd.setEnabled(true);
			btnDel.setEnabled(true);
			btnSearch.setEnabled(true);
			btnCancel.setEnabled(true); //
			cmd = NONE;
			break;
		}// switch end
	}// setButton end

	//////////////////////////// button event 처리 ////////////////////////
	public void search() {  //검색
		String strName = Util.toKor(txtName.getText());
		if( strName.length() < 1 ) {
			JOptionPane.showMessageDialog(null, "이름은 필수 입니다");
			return;
		}// if end
		
		try {
			pstmtSearchScroll.setString(1, Util.toKor(strName));
			ResultSet rsScroll = pstmtSearchScroll.executeQuery(); // 반환값이 있는 경우 - select
			
			pstmtSearch.setString(1, Util.toKor(strName));
			ResultSet rs = pstmtSearch.executeQuery();
			
			if( model == null ) model = new MyModel();
			model.getRowCount(rsScroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// end search()

	private void del() {
		// 이름으로 삭제하기
		total();
		String strName = null;

		try {
			strName = Util.toKor(txtName.getText());
			if (strName.length() < 1) {
				JOptionPane.showMessageDialog(null, "이름은 필수 사항입니다");
				return;
			} // if end

			// JOptionPane.showMessageDialog(null, "삭제성공");
			// 삭제성공 - 확인만 뜸

			// JOptionPane.showConfirmDialog(null, "delete success");
			// 취소도 같이뜸 delete success - 예/아니오 / 취소

			switch (JOptionPane.showConfirmDialog(null, "(" + strName + ")", "삭제하시겠습니까",
					JOptionPane.YES_NO_CANCEL_OPTION)) {
			case 0:
				break;

			case 1:
				return;
			}

//삭제 실행부분
			pstmtDelete.setString(1, strName);
			pstmtDelete.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} /// try end

		total();

	}// end del()

	// add함수 - 추가버튼을 누르면 db에 추가
	private void add() {

		try {
			String strNo = txtNo.getText();
			String strName = txtName.getText();
			String strMail = txtEmail.getText();
			String strPhone = txtPhone.getText();
			// 값을 가져오는 메소드
			// 값을 가져와서 strNo...에 저장해놨다

//		   System.out.println(strNo);
//		   System.out.println(strName);
//		   System.out.println(strMail);
//		   System.out.println(strPhone);
			// 잘 가져왔는지 확인용...

			// set자료형(0,0) 순서, 값
			// get자료형 (0) 가지고 올 데이터 (index, field명)

			// 숫자 , 이름 = not null ,
//			// 빈값일 경우 다시 입력시키기
			// 방식1
//			if (strNo.length() < 1 || strName.length() < 1) {
//				JOptionPane.showMessageDialog(null, "번호와 이름은 필수 사항입니다. 입력요망");
//				return;
//
//			} // if end

			// JOptionPane.showConfirmDialog -> 예 아니요
			// JOptionPane.YES_NO_OPTION -> 버튼 방식
			switch (JOptionPane.showConfirmDialog(null,
					"(" + strNo + ", " + strName + ", " + strMail + ", " + strPhone + ")", "추가하시겠습니까?",
					JOptionPane.YES_NO_OPTION)) {

			case 0:

				break;

			case 1:

				return;

			}

			//// sqlInsert에 물음표 네개 중 1번째자리, 2번째자리 저장값지정

			pstmtInsert.setInt(1, Integer.parseInt(strNo));
			// 데이터베이스의 자료형이 숫자기 때문에 숫자형으로 변환해서 저장
			// try catch문으로 에러처리를 한다(안하면오류남)
			pstmtInsert.setString(2, strName);
			pstmtInsert.setString(3, strMail);
			pstmtInsert.setString(4, strPhone);

			pstmtInsert.executeUpdate();
			// 반환할 값이 없으면 exeupdate해야한다. 실제 실행

			// **자바는 자동커밋__오라클땐 직접 commit 입력

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void total() { // 전체보기 = (select) 버튼 이벤트 처리 함수

		try {
			ResultSet rsScroll = pstmtTotalScroll.executeQuery(); // 반환값이 있음. executeQuery()
			ResultSet rs = pstmtTotal.executeQuery();

			if (model == null)
				model = new MyModel(); // 생성함.

			model.getRowCount(rsScroll);
			model.setData(rs);

			table.setModel(new DefaultTableModel(model.data, model.columnName));
			table.updateUI();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end total()

	////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		new JDBCProjectEx3();

	}
}
