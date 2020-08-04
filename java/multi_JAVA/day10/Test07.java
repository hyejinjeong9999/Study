package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test07 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		// 자주쓰이는 구조중 하나!!!
		map.put("java01", "1234");
		map.put("java02", "1333");
		map.put("java03", "1224");
		map.put("java04", "1244");
		map.put("java05", "2234");
		map.put("java06", "1224");
		map.put("java07", "1234");
		map.put("java08", "1234");
		map.put("java09", "1234");
		// 이부분중복X -> 중복되면 데이터는 마지막 것 밖에 안들어감

		// 맵 구조 순회
		Set<String> keys = map.keySet();
		// key값의 목록만 set구조로 뽑아주는 api
		Iterator<String> it = keys.iterator();
		// 컬렉션 접근 방식 iterator

		while (it.hasNext()) {
			String id = (String) it.next();
			System.out.println(id + " = " + map.get(id));
		}

//		System.out.println(map);
		// 하나의 string으로 전부 출력 (사용에는 적합하지 않음 )
		// System.out.println(map.get("java01"));
		// java01의 비밀번호 1234 출력
//		System.out.println(map.get("java00"));
		// 존재하지 않는 값 입력 : null 값 출력

		// 로그인
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("ID입력");
			String id = scanner.nextLine().trim();
			System.out.println("PW입력");
			String pw = scanner.nextLine().trim();
			if (!map.containsKey(id)) {
				// map.containsKey(key) : 키값 존재하는지 체크

				System.out.println("id가 존재하지 않음");
				continue;
				// 다시 while 처음으로 돌아감

			} else {// 아이디 존재할 경우
				if (map.get(id).equals(pw)) {
					// map.get(id) 비밀번호 꺼냄 .equals(pw) pw값과 비교
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("로그인 실패 비밀번호 확인");
				}
			}

		}

		scanner.close();
		scanner = null;
		// 항상 자원반납 잊지말기

		System.out.println("END");

	}

}
