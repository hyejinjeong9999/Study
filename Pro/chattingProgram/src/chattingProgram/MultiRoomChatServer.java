package chattingProgram;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MultiRoomChatServer extends Application {

	TextArea textArea;
	Button serverStartBtn;
	Button serverStopBtn;
	ServerSocket server;
	Socket socket;

	MultiRoomChatRunnable chatRunnable;
	ExecutorService excutorService = Executors.newCachedThreadPool();
	MultiRoomSharedObject sharedObject = new MultiRoomSharedObject();

	// 출력하는 메서드
	public void printMsg(String msg) {
		Platform.runLater(() -> {
			textArea.appendText(msg + "\n");
		});
	}

	// 화면
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		textArea = new TextArea();
		root.setCenter(textArea);

		serverStartBtn = new Button("Server Start");
		serverStartBtn.setPrefSize(150, 40);
		// 서버 시작 버튼을 누르면
		serverStartBtn.setOnAction(e -> {
			printMsg("server start");
			Runnable runnable = () -> {

				try {
					server = new ServerSocket(9999);// 소켓 번호 할당

					while (true) {
						socket = server.accept(); // 클라이언트의 접속 기다림
						// Runnable 생성 : sokcet과 공유객체 주입
						chatRunnable = new MultiRoomChatRunnable(socket, sharedObject);

						// client Thread를 공용객체 List에 저장
						sharedObject.add(chatRunnable);
						// Threadpool에 chatRunnable 쓰레드 넣어 실행
						excutorService.execute(chatRunnable);
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			};
			// 해당 쓰레드 실행
			excutorService.execute(runnable);
		});

		// 서버 닫기
		serverStopBtn = new Button("Server Start");
		serverStopBtn.setPrefSize(150, 40);
		// 서버닫기 버든 누르면
		serverStopBtn.setOnAction(e -> {
			// sverstop 값 출력
			printMsg("server stop");
			try {
				// 창 닫기
				socket.close();
				server.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			excutorService.shutdownNow(); // 서버 쓰레드닫기
		});

		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(700, 40);
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 상,하,좌,우 Padding
		flowPane.setHgap(10); // Horizontal gap 10 pixel 간격
		flowPane.getChildren().add(serverStartBtn);
		flowPane.getChildren().add(serverStopBtn);

		root.setBottom(flowPane); // 전체 화면의 아래부분에 FlowPane 부착

		Scene scene = new Scene(root);
		primaryStage.setScene(scene); // window(primaryStage) 화면을 Scene로 설정
		primaryStage.setTitle("Multi Room Chatting Server");
		primaryStage.setOnCloseRequest(e -> {
			System.out.println("Server 종료");
			System.exit(0); // 0 => program 강제종료
		});
		primaryStage.show();
	}

	// 실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
