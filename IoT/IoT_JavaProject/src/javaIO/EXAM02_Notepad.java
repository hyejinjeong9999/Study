package javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EXAM02_Notepad extends Application {
	private TextArea ta;
	private Button opeBtn, SaveBtn;

	private void printMSG(String msg) {

		Platform.runLater(() -> {
			ta.appendText(msg + "\n");

		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage PrimaryStage) throws Exception {

		BorderPane root = new BorderPane();

		root.setPrefSize(700, 500);

		ta = new TextArea();
		root.setCenter(ta);

		opeBtn = new Button("파일 열기");
		opeBtn.setPrefSize(250, 50);

		opeBtn.setOnAction(e -> {
			ta.clear(); // TA 초기화

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("open할 file을 선택해 주세요");
			File file = fileChooser.showOpenDialog(PrimaryStage); // 창을 띄움

			FileReader fr;
			try {
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while ((line = br.readLine()) != null) {
					// null이 아닌 동안 읽기
					printMSG(line);

				}

			} catch (FileNotFoundException e1) { //FileReader 예외사항

			} catch (IOException e2) { //readLine 예외사항

			}
		});

		SaveBtn = new Button("save");
		SaveBtn.setPrefSize(250, 50);

		SaveBtn.setOnAction(e -> {

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(opeBtn);
		flowpane.getChildren().add(SaveBtn);

		root.setBottom(flowpane); // 전체화면의 아랫부분에 FlowPane 부착

		Scene scene = new Scene(root); //
		PrimaryStage.setScene(scene); // window의 화면을 Scene으로 설정
		PrimaryStage.setTitle("예제용 JavaFx"); // 윈도우 창의 제목

		PrimaryStage.setOnCloseRequest(e -> {

			System.exit(0);

		});

		// Close버튼을 눌렀을때 이벤트 처리

		PrimaryStage.show();
	}

	public static void main(String[] args) {

		// 화면에 창을 띄우기

		launch();

	}

}
