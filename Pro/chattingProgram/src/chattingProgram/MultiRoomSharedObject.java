package chattingProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//공유객체
//Thread에 의해서 공유되어야 하는 Data
public class MultiRoomSharedObject {
	
//모든 클라이언트에 대한 Thread를 만들기 위해 필요한 Runnable 객체 저장
	List<MultiRoomChatRunnable> clients = new ArrayList<MultiRoomChatRunnable>();
	
	//방 목록을 담기 위한 Map
	Map<String,List<MultiRoomChatRunnable>> roomList = new HashMap<>();
	
	//공유객체를 제어하기 위해 필요한 메서드 add, remove
	
	//새로운 사용자가 접속했을 때 클라이언트 안에 새로운 사용자에 대한 Runnable 객체 저장
	public void add(MultiRoomChatRunnable runnable) {
		clients.add(runnable);
	}
	
	//사용자가 접속을 종료했을 때 client 안에 있는 사용자 삭제
	public void remove(MultiRoomChatRunnable runnable) {
		clients.remove(runnable);
	}
	
	//방 생성
	public void createRoom(String roomName) {
		//이미 존재하면 메시지 전송
		if(roomList.containsKey(roomName)) {
			
		}else {
			//Map에 새로운 채팅방 생성
			//key : 채팅방 이름
			//value : userList 최초 생성시 user는 접속하지 않았기 때문에 비어있음 , 하지만 null이면 안됨
			roomList.put(roomName,new ArrayList<MultiRoomChatRunnable>());
		}
		
	}
	//방 입장
	public void connRoom(String roomName, MultiRoomChatRunnable runnable) {
		//user가 채팅방 접속하며 채팅방 roomList에 key값으로 들어간다
		//roomList에 value를 담아 user를 추가하고 추가된 List로 기존 value를 대체한다
		//회원을 추가함
		List<MultiRoomChatRunnable> roomMember = roomList.get(roomName);
		//현재 ruunable(현재 유저)의 값을 추가한다
		roomMember.add(runnable);
		
		//map 자료구조의 특징으로 같은 key 값을 가진다면 이후에 입력된 value 값으로 value가 대체됨
		//같은 방에 있는 경우 회원만 바뀐다
		roomList.put(roomName, roomMember);
	} 
	
	
	public void disconnRoom(String roomName, MultiRoomChatRunnable runnable) {
		// user가 채팅방 접속 하며 해당 채팅방 dms roomList 에 key값으로 들어있다.
		// roomList 에 value(ArrayList)를 객체에 담아 user를 추가하고 추가된 List로 기존 value를 대체한다.
		List<MultiRoomChatRunnable> roomMember = roomList.get(roomName);
		roomMember.remove(runnable);
		// map 자료구조의 특징으로 같은 key값을 가진다면, 이후에 입력된 value값으로 value가 대체 된다.
		roomList.put(roomName, roomMember);
	}
	
	
	//특정 채팅방에 Message를 전송하는 메서드
	public void broadcast(String roomName, String userID, String msg) {
		//특정 채팅방의 모든 User를 지정
		//방목록의 위치값을 가진 roomMember -> 해당 방의 멤버 리스트
		List<MultiRoomChatRunnable> roomMember = roomList.get(roomName);
		
		// 특정 채팅방의 모든 User에게 Message 전송
		for(MultiRoomChatRunnable client : roomMember) {
			//roomMember에 속해있는 client들에게 msg를 전송함
			client.getPrintWriter().println("" + userID+" : "+msg);
			//아이디 : 보낸 값으로 서버에 전송
			client.getPrintWriter().flush();
			
			
		}
	}
	//client 창에서 RoomList 보여주는 Method
	public String getRooms() {
		//모든 채팅방을 String[] 으로 선언 (roomList -> String[]으로 변환)
		//keySet() : roomList를 set자료구조로 변환
		// toArray() : String[]으로 반환
		String[] tmp = roomList.keySet().toArray(new String[] {});
		
		//Client가 명령으로 인식하도록 하기 위한 명령어 지정
		String rooms = "/getRoom";
		//명령어 이후의 인자 선언
		//방 List 보여줌
		for(String room : tmp) {
			rooms +="" + room;
		}
		//client들에게 방목록 전송
		for(MultiRoomChatRunnable user : clients) {
			user.getPrintWriter().println(rooms);
			user.getPrintWriter().flush();
		}
		
		return rooms;
	}
	
	//client에서 채팅방에 접속안 모든 User를 보여주는 Method
	public String getUsers(String roomName) {
		//현재 roomName List들을 room Member에 저장
		List<MultiRoomChatRunnable> roomMember = roomList.get(roomName);
		String userID = "/getUser";
		//roomMember에 있는 client의 아이디를 userID에 저장
		for(MultiRoomChatRunnable client : roomMember) {
			userID += "" + client.getUserID();
		}
		//roomMember의 client에게 저장한ID 값들을 전송
		for(MultiRoomChatRunnable client : roomMember) {
			client.getPrintWriter().println(userID);
			client.getPrintWriter().flush();
		}
		return userID;
	}
	
	

}
