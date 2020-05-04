package javaNetworkReview;

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

public class EXAM02_EchoClient extends Application {

	private TextArea ta;
	private Button connBtn;
	private TextField tf;
	
	Socket s;
	BufferedReader br;
	PrintWriter pr;



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
			
			try {
				Socket s = new Socket("localhost",7777);
				printMSG("서버접속성공");
				
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());
				
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
		tf.setDisable(true);
		tf.setOnAction(e -> {
			String msg = tf.getText();
			pr.println(msg);
			pr.flush();
			tf.clear();
		
		if(!(msg.equals("@EXIT"))) {
			String revSring;
			try {
				revSring = br.readLine();
				printMSG(revSring);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		else {
			printMSG("서버와의 연결 종료");
			tf.setDisable(true);
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
