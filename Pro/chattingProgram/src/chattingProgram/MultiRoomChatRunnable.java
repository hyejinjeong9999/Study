package chattingProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Thread에 넣을 Runnable
public class MultiRoomChatRunnable implements Runnable {

	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	MultiRoomSharedObject sharedObject;
	String userID = "";
	String roomName = "";

	// 보낸값 보내줌
	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	// 유저아이디를 제공
	public String getUserID() {
		return userID;
	}

	// 생성자
	// socket과 공용객체를 담아와 초기화한다
	// bufferedReader와 printwriter 생성
	public MultiRoomChatRunnable(Socket socket, MultiRoomSharedObject sharedObject) {
		this.socket = socket;
		this.sharedObject = sharedObject;

		try {
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.printWriter = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// client로부터 넘어온 MSG를 반별해 기능 수행
		String msg = "";
		try {
			while ((msg = bufferedReader.readLine()) != null) {

				System.out.println(msg);
				// EXIT로 시작하는 메시지를 수신하면 DisRoomConnection -> 방 나감

				if (msg.equals("/EXIT")) {
					sharedObject.disconnRoom(roomName, MultiRoomChatRunnable.this);
					printWriter.print("/EXIT");
					printWriter.flush();
					continue;
				}
				// userID로 시작하는 메시지를 수신하면 user가 userID로 접속
				if (msg.startsWith("/userID")) {
					this.userID = msg.replaceFirst("userID", "");
					System.out.println("userID==" + this.userID);
					continue;
				}

				if (msg.startsWith("/createRoom")) {
					String roomName = msg.replaceFirst("createRoom", "");
					printWriter.println(roomName + " 채팅방 생성");
					sharedObject.createRoom(roomName);
					System.out.println("CreateRoom ==" + roomName);
					continue;
				}
				if (msg.startsWith("/userID")) {
				}
				if (msg.startsWith("/connRoom")) {
					String roomName = msg.replaceFirst("/connRoom", "");
					sharedObject.connRoom(roomName, MultiRoomChatRunnable.this);
					this.roomName = roomName;
					System.out.println(this.userID);
					continue;
				}
				if (msg.equals("/getRoom")) {
					String rooms = sharedObject.getRooms();
					System.out.println("RoomList print" + rooms);
					continue;
				}
				if (msg.equals("/getUser")) {
					String users = sharedObject.getUsers(roomName);
					System.out.println(roomName + " 방 UserList print");
					continue;
				}
				sharedObject.broadcast(roomName, userID, msg);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}