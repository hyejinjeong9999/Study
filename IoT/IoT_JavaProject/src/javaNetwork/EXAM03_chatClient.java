package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EXAM03_chatClient extends Application {

	private TextArea ta;
	private Button connBtn;
	private TextField tf;

	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		ta = new TextArea(); // 글상자를 생성
		root.setCenter(ta); // BorderPane가운데에 TextArea 부착

		connBtn = new Button("서버에 접속!!");
		connBtn.setPrefSize(250, 50);
		connBtn.setOnAction(e -> {

			ta.clear();
			try {
				s = new Socket("localhost", 1111);
				printMSG("서버접속성공");
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());

				// 접속 성공했으니 입력상자 활성화
				tf.setDisable(false);

			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		tf = new TextField();
		tf.setPrefSize(400, 50);
		tf.setDisable(true); // 처음엔 text필드 사용 불가능
		// 입력상자에서 글을 입력하고 enter를 치면 action 수행
		tf.setOnAction(e -> {
			
			String msg = tf.getText(); //문자열 얻어오기 
			pr.println(msg); //데이터 전송
			pr.flush(); 
			tf.clear(); //text창 비우기
			
			//입력한 값이 @EXIT 아니면 보낸 값 다시 받아와 출력하기
			if(!(msg.equals("@EXIT"))) {
				try {
					String revString = br.readLine();
					printMSG(revString);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			//@EXIT 입력했을 경우 서버 끊기
			else {
				printMSG("서버와의 연결 종료");
				tf.setDisable(true);  //입력상자 사용 못하게 만들기
			}

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(connBtn);
		flowpane.getChildren().add(tf);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("에코프로그램");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(); // start() method가 호출되요!!

	}

}
