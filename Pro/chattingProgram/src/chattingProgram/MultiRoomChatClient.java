package chattingProgram;

import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MultiRoomChatClient extends Application {
	String userID; // Client Chatting ID
	TextArea textArea; // 체팅창
	Button connBtn; // Chatting Server 와 Connection BTN
	Button disconnBtn; // Chatting Server 와 disConnection BTN
	Button creatRoomBtn; // Chatting Room Create BTN
	Button connRoomBtn; // Chatting Room 입장 BTN
	Button disconnRoomBtn; // Chatting Room EXIT BTN
	BorderPane root;
	FlowPane menuFlowPane;
	ListView<String> roomListView; // 체팅방 목록 보여주는 listVIew
	ListView<String> participantsList; // 체팅방 참여 List
	String entered = "";
	String roomName = "";

	MultiRoomSharedObject sharedObject;
	Socket socket;
	PrintWriter printWriter;
	BufferedReader bufferedReader;
	ExecutorService executorService = Executors.newCachedThreadPool();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		root = new BorderPane(); // 화면을 동서남북 중앙 5개의 영역으로 분할

		root.setPrefSize(700, 500); // 크기 setting
		// 화면 중앙에 TextArea 붙여줌
		textArea = new TextArea();
		textArea.setEditable(false);
		root.setCenter(textArea);

		// 방목록을 표현하는 ListView 생성
		roomListView = new ListView<String>();
		// 방안에서 체팅하는 사람들의 목록을 표현하는 ListView 생성
		participantsList = new ListView<String>();
		// 화면을 격자로 나누어component를 표현하는 layout
		GridPane gridPane = new GridPane();
		// GridPane의 padding 수정
		gridPane.setPadding(new Insets(0, 10, 0, 10));
		// gridPane 안에 Component 간에 여백 설정
		gridPane.setVgap(10); // Vertical 방향으로 10 pixel 주는의미
		gridPane.add(roomListView, 0, 0); // (componnet, 행, 열) 0행 0열
		gridPane.add(participantsList, 0, 1); // 0행 1열
		root.setRight(gridPane); // gridPane 를 오른쪽으로 배치

		connBtn = new Button("Chat 서버 접속");
		connBtn.setPrefSize(100, 40);
		connBtn.setOnAction(e -> {
			Dialog<String>dialog = new TextInputDialog("자신의 이름을 입력하세요");
			
		}
		

	}

	public static void main(String[] args) {
		launch();
	}

}
