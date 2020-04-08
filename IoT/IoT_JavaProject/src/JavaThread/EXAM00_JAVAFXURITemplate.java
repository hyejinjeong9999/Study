package JavaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//JAVAFX를 이용한 화면UI 생성
//JAVAFX library가 있어야 한다

public class EXAM00_JAVAFXURITemplate extends Application {

	private TextArea ta;
	private Button btn;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage PrimaryStage) throws Exception {

		BorderPane root = new BorderPane();

		// BorderPane의 size 설정

		root.setPrefSize(700, 500);

		ta = new TextArea(); // 글 상자 생성
		root.setCenter(ta); // 중앙에 글상자 넣기

		btn = new Button("버튼 클릭"); // 버튼 생성
		btn.setPrefSize(250, 50);

		// Button을 클릭했을 때 이벤트 처리

		/*
		 * btn.setOnAction(new EventHandler() {
		 * 
		 * 
		 * @Override public void handle(Event arg0) {
		 * 
		 * 코드
		 * 
		 * }
		 * 
		 * });
		 */
		// 람다식 인자가 하나일때는 () 생략 가능
		// 인자가 아예 없거나, 둘 이상 () 필요
		btn.setOnAction(e -> {

			Platform.runLater(() -> {
				ta.appendText("버튼이 클릭되었어요" + "\n");

			});
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn); // FlowPane에 Button을 부착

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
