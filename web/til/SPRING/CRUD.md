# CRUD

* 홈페이지의 기본기능

* 조회 read

* 생성creat

* 수정update

* 삭제delete

* board 테이블로 생성



##### 글쓰기 

1. 글쓰기 폼 화면   (c - m - v)
2. 폼에서 입력받은 내용을 DB에 insert 기능 수행하는 (c - m - v)

##### 수정

1. 글을 수정할 수 있는 폼 화면 (수정하기 이전의 제목, 내용 보여주기) (c - m - v)

1. detail. 폼을 보여주면서 주성할 수 있으면 수정할 수 있게하기

##### 삭제



##### boarddetail.jsp

````jsp
<!-- 수정폼 -->
<form action = "http://localhost:8081/mvc/boardupdate">
번호 : <input type="text" name = "seq" value = '${detail.seq}' readonly><br>
제목 : <input type="text" name = "title" value = '${detail.title}'> <br>
내용 : <input type="text" name = "contents" value = '${detail.contents}'><br>
작성자 : <input type="text" name = "writer" value = '${detail.writer}'><br>
작성시간 : <input type="text" name = "time" value = '${detail.time}'readonly><br>
조회수 : <input type="text" name = "viewcount" value = '${detail.viewcount}' readonly><br>

<input type = submit value = "수정">
</form>

<!-- 삭제폼 -->
<form action = "http://localhost:8081/mvc/boarddelete">
 <input type="hidden" name = "seq" value = '${detail.seq}' readonly>
<input type = submit value = "삭제">
</form>

````

* 수정을 누르면 action에 지정된 곳으로 전송한다 
  * boardupdate와 매핑되는 곳
  * MVC방식은 jsp파일을 직접보여주는 것이 아니라 컨트롤러를 통해서 매핑시켜서 호출되는것이다

* 글번호 / 작성시간/조회수는 수정하지 못하게 하고 보여주게 하기

* readonly 읽기만 가능
  * readonly  = readonly 기본형식 뒤는 생략가능
* hidden
  * form이 나오지 않음
  * 브라우저에 보일 필요는 없지만 서버로 파라미터 값을 전달해야 하는 경우 사용
  * 삭제의 경우 게시물번호를 보여줄 필요 없이 삭제버튼만 누르면 되니까 hidden 사용



##### boardController.java

````java
//수정	
	@RequestMapping("/boardupdate")
	public String updateBoard(@ModelAttribute("vo") BoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:/boardlist";
	}

//삭제
	@RequestMapping("/boarddelete")
	public String deleteBoard(int seq) {
		dao.deleteBoard(seq);
		
		return "redirect:/boardlist";
	}
````

* 파라미터 값 넣기
  1. int seq String title.. 직접 변수명 설정
     * 파라미터 값이 길어진다
  2.  BoardVO를 넣어준다
     * VO 안에는 값이 다 들어있기 때문에 간편함
     * 
* 제목, 내용, 글쓴이만 수정한다
* 수정할 값을 파라미터에서 받아와라 (파라미터 변수는 jsp의 name과 같아야 한다)
* 게시물을 찾기위한 글번호 수도 가져오기





##### BoardDAO.java

`````java
public BoardVO updateBoard(BoardVO vo) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			String updatesql = "update board set title =?, contents = ?, writer =? where seq=? ";

			PreparedStatement pt = con.prepareStatement(updatesql);

			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getSeq());

			pt.executeUpdate();

			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

`````

* 데이터

`````java


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			String updatesql = "delete board where seq=? ";

			PreparedStatement pt = con.prepareStatement(updatesql);

			pt.setInt(1, seq);

			pt.executeUpdate();

			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

`````

