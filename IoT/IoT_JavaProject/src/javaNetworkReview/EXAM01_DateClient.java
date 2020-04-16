package javaNetworkReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EXAM01_DateClient extends Application {

	private TextArea ta;
	private Button btn;

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

		ta = new TextArea();
		root.setCenter(ta);

		btn = new Button("서버에 접속!!");
		btn.setPrefSize(250, 50);
		btn.setOnAction(e -> {
			
			try {
				Socket s = new Socket("localhost",5555);
				
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String msg = br.readLine();
			printMSG(msg);
			
			br.close();
			s.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
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
