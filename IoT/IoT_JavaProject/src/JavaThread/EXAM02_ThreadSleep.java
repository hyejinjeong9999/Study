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

public class EXAM02_ThreadSleep extends Application {

	private TextArea ta;
	private Button btn;

	private void printMSG(String msg) { // text Area의 출력 담당
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");

		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage PrimaryStage) throws Exception {

		BorderPane root = new BorderPane();

		// BorderPane의 size 설정

		root.setPrefSize(700, 500);

		ta = new TextArea(); // 글 상자 생성
		root.setCenter(ta); // 중앙에 글상자 넣기

		btn = new Button("버튼 클릭");

		// Button을 누르면 Thread를 5개 생성
		// 각 Thread는 1초마다 자싿 깻다 하면서 숫자를 하나 출력
		btn.setPrefSize(250, 50);

		btn.setOnAction(e -> {

			for (int i = 0; i < 5; i++) { //쓰레드를 다섯개 만듦

				Thread t = new Thread(() -> {

					try {
						for (int k = 0; k < 3; k++) {
							Thread.sleep(1000);
							printMSG(k + "-" + Thread.currentThread().getName()); // thread의 이름가져오기
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // 1초간 자기

				}

				);
				t.start();

			}

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
