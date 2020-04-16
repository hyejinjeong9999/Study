package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EXAM03_chatServer extends Application {

	private TextArea ta;
	private Button btn;

	ServerSocket server;
	Socket s = null;
	NetwortRunnable net = null;

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

		btn = new Button("서버 가동!!");
		btn.setPrefSize(250, 50);
		btn.setOnAction(e -> {
			try {
				server = new ServerSocket(1111);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			while (true) {
				try {
					s = server.accept();
					net = new NetwortRunnable(s);
					Thread t = new Thread(net);
					t.start();
					printMSG(t.getName() + "접속");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn); // FlowPane에 Button을 부착

		root.setBottom(flowpane); // 전체 화면의 아래부분에 FlowPane 부착

		Scene scene = new Scene(root); // BorderPane을 포함하는 장면생성
		primaryStage.setScene(scene); // Window의 화면을 Scene으로 설정
		primaryStage.setTitle("예제용 JavaFX");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(); // start() method가 호출되요!!

	}

}

class NetwortRunnable implements Runnable {

	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

	NetwortRunnable(Socket s) {
		this.s = s;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pr = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String str = "";
		try {
			while (true) {

				str = br.readLine();

				if (str != null) {
					if (str.equals("@EXIT"))
						break;
					pr.println(str);
					pr.flush();
				}else {
					break;
				}
				
			}
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
