package javaNetwork;

import java.util.Optional;

import javax.swing.text.html.Option;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EXAM05_MultiRoomChatClent extends Application {

	// Field 정의

	private String userID; // client 채팅 ID;
	private TextArea textarea; // 채팅창 역할을 하는 TextArea
	private Button connBtn; // 채팅 서버와 연결을 하기 위한 버튼
	private Button disconnBtn; // 채팅서버와 연결을 종료하기 위한 버튼
	private Button createRoomBtn; // 새로운 채팅 방을 만드는 버튼
	private Button connRoomBtn; // 채팅방에 입장하기 위한 버튼
	private ListView<String> roomListView; // 채팅방 목록을 보여주는 listView
	private ListView<String> participantsListView; // 참여자 ListView

	// TextArea에 내용을 출력하기 위한 method를 정의
	private void printMSG(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}

	// 실제 우리가 띄우는 창 : primaryStage
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane(); // 화면을 동서남북 중앙 5개의 영역으로 분할
		root.setPrefSize(700, 500); // 크기 조절

		// 화면 중앙에 TextArea를 붙임
		textarea = new TextArea();
		textarea.setEditable(false); // textarea는 글을 보여주는 곳이지 쓰는 곳이 아님 : editing 안되게
		root.setCenter(textarea); // 화면 중앙에 textArea를 배치

		// 방 목록을 표현하는 ListView를 생성
		roomListView = new ListView<String>();
		// 방 안에서 채팅하는 사람들의 목록을 표현하는 ListView를 생성
		participantsListView = new ListView<String>();

		// 화면을 격자로 나누어 component를 표현하는 layout
		GridPane gridpane = new GridPane();
		// gridpane의 padding (여백)부터 설정
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		// gridpane 안에 여러 component가 붙음 이 component 간에 여백을 설정
		gridpane.setVgap(10); // component간에 10px 간격을
		gridpane.add(roomListView, 0, 0); // 방목록은 0행 0열에 위치시킨다
		gridpane.add(participantsListView, 0, 1); // 참여자 목록은 0행 1열에 위치

		root.setRight(gridpane); // 화면 오른쪽에 gridpane을 붙임

		// ---버튼---//

		// ---1. 서버 접속---//
		connBtn = new Button("Chat 서버와 접속");
		connBtn.setPrefSize(150, 40);

		connBtn.setOnAction(e -> {
			// 서버 접속 버튼을 누르면 사용자 ID부터 받음

			Dialog<String> dialog = new TextInputDialog("자신의 NickName을 입력하세요");
			dialog.setTitle("닉네임설정");
			dialog.setHeaderText("닉네임 설정입니다. 적절한 이름을 입력하세요");

			Optional<String> result = dialog.showAndWait();
			// 창 띄우기 확인, 취소창 누를 때까지 기다리기
			// 입력받은 값을 result에 저장한다

			String entered = "";
			if (result.isPresent()) { // 닉네임을 누르고 확인버튼을 누른경우 (값이 있는 경우)
				entered = result.get(); // 결과를 entered에 저장한다.

			}

			// ---서버에 접속해서 방 목록을 받아오기---

			roomListView.getItems().add("서울, 경기 등산모임");
			roomListView.getItems().add("기사시험 공부방");
			roomListView.getItems().add("JAVA 공부방");

			printMSG("채팅 서버에 접속했어요");
			printMSG(entered + "님 환영합니다");
			userID = entered;

		});
		// --채팅방 생성 버튼---

		createRoomBtn = new Button("채팅방 생성");
		createRoomBtn.setPrefSize(150, 40);
		createRoomBtn.setOnAction(e -> {
			Dialog<String> dialog = new TextInputDialog("생성할 방 이름을 입력하세요!");
			dialog.setTitle("채팅방생성");
			dialog.setHeaderText("채팅방 생청입니다. 적절한 이름을 입력하세요!");
			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if (result.isPresent()) {
				entered = result.get();
			}
			roomListView.getItems().add(entered);
			printMSG("채팅방 : " + entered + "가 추가되었습니다");

		});

		// 채팅방 접속 버튼
		connRoomBtn = new Button("채팅방 접속");
		connRoomBtn.setPrefSize(150, 40);
		connRoomBtn.setOnAction(e -> {
			String roomName = roomListView.getSelectionModel().getSelectedItem();
			// List에서 선택된 모델 가져오고 모델에서 가져온 Item을 가져온다
			printMSG(roomName + "방에 입장했습니다");

			participantsListView.getItems().add("홍길동");
			participantsListView.getItems().add("유관순");
			participantsListView.getItems().add("신사임당");
			participantsListView.getItems().add("얼큰우동");
			FlowPane inputFlow = new FlowPane();
			inputFlow.setPadding(new Insets(10, 10, 10, 10));
			inputFlow.setPrefSize(700, 40);
			inputFlow.setHgap(10);

			TextField inputTF = new TextField();
			inputTF.setPrefSize(400, 40);
			inputFlow.getChildren().add(inputTF);
			inputTF.setOnAction(v -> {
				printMSG(userID + ": " + inputTF.getText());
				inputTF.clear();
			});
			root.setBottom(inputFlow);
		});

		// 화면 아랫쪽에 연결버튼 붙이기
		FlowPane menuFlowPane = new FlowPane();
		menuFlowPane.setPadding(new Insets(10, 10, 10, 10));
		menuFlowPane.setPrefSize(700, 40);
		menuFlowPane.setHgap(10); // 가로여백

		menuFlowPane.getChildren().add(connBtn);
		menuFlowPane.getChildren().add(createRoomBtn);
		menuFlowPane.getChildren().add(connRoomBtn);

		root.setBottom(menuFlowPane);

		// ---창을 띄우기 위한 코드---//
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MultiRoom Chat client");
		primaryStage.setOnCloseRequest(e -> {

		});
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(); // java fx 실행

	}

}
