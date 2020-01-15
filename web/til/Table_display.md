# Table display

#### html

````html
<body><center>
		<table id="staff" border=0 cellpadding=5>
			<thead>
				<tr><th>이름<th>혈액형<th>지역
			</thead>
			<tbody>
				<tr><td>강민수<td>AB형<td>서울특별시 송파구
				<tr><td>구지연<td>B형<td>미국 캘리포니아
				<tr><td>김미화<td>AB형<td>미국 메사추세츠
				<tr><td>김선화<td>O형<td>서울특별시 강서구
				<tr><td>남기주<td>A형<td>서울특별시 노량진구
				<tr><td>윤하린<td>B형<td>서울특별시 용산구
			</tbody>
		</table>
		</center>
	</body>
</html>
````

* `<CENTER>` 가운데 정렬 
* `<table id="staff" border=0 cellpadding=5>` table id가 staff인 표 생성 
  * border : 표 선굵기
  * cellpadding : 테이블 안의 너비
* `<thead>`  열의 제목으로 구성된 행의 집합
  * `<tbody>` 도표의 본문에 해당하는 영역
  * `<tfoot>` 도표의 하단에 나오는 열의 요약으로 구성된 행의 집합

#### style

````css
	<style>
		
			.style1{ background-color:#CFCFE7; color:#000000; }
		</style>
````

* sytle1에 배경색과 색 설정



#### script

````javascript
<script>
		$(document).ready( function(){
			$("#staff thead tr").css("background", "#8A8AFF");
			$("#staff tbody tr:odd").css("background", "#C9C9C9");
			$("#staff tbody tr:even").css("background", "#FF99CC");
			$("#staff tbody tr").hover( 
				function( ){
					$(this).find("td").addClass("style1");
				},
				function( ){
					$(this).find("td").removeClass("style1");
				}
			);
						$("#staff thead th").hover( 
							
				function( ){
					var no=$(this).index( )+1;
					$("#staff tbody td:nth-child("+no+")").addClass("style1");
				},
				function( ){
					$("#staff tbody td").removeClass("style1");		
				}
			);

		});

		</script>
````

* `$(document).ready( function(){` 기능 시작
* `$("#staff thead tr").css("background", "#8A8AFF");`
  * tread 영역의 tr에 배경색 지정
* `$("#staff tbody tr:odd").css("background", "#C9C9C9");`
  * tboby의 tr의 홀수 영역에 색깔 지정
  * ==태그:odd== 홀수영역
  * ==태그:even== 짝수영역
* `$("#staff tbody tr").hover(` 
  * staff 테이블의 tbody의 tr영역에 hover 추가
  * ==hover(F1,F2)== :마우스를 올려놓으면 F1 실행 마우스를 내려놓으면  F2 실행
* `$(this).find("td").addClass("style1");`
  * 마우스를 올려놓으면 그 요소에 style1 클래스를 추가한다 (css파일 추가)
  * ==addClass (클래스명)== 클래스 추가
  * ==removeClass(클래스명)== 클래스 삭제
  *  
* `$("#staff thead th").hover( `
  * staff 표의 머리쪽에 가져다 대면
* `var no=$(this).index( )+1;`
  * 마우스가 올라간 th태그의 순서번호를 저장한다
* `$("#staff tbody td:nth-child("+no+")").addClass("style1");`
  * ==nth-chile== 형제 요소 중 특정 순서에 있는 요소를 선택
  * no번째에 있는 tbody 안의 td 요소에 style1 삽입
* `$("#staff tbody td").removeClass("style1");`
  * 마우스를 떼어놓으면 효과 삭제



기본 모양

![image-20200115191837884](../../../../혜/til/img/image-20200115191837884.png)

마우스를 올려놓을 때

![image-20200115191916395](../../../../혜/til/img/image-20200115191916395.png)

표 상단에 마우스

![image-20200115191937088](../../../../혜/til/img/image-20200115191937088.png)