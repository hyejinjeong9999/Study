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

public class EXAM05_ThreadInterrupt extends Application {

	private TextArea ta;
	private Button startBtn, stopBtn;
	private Thread countThread;

	// TextArea에 문자열을 출력하기 위한 method 만들기

	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");

		}); // 쓰레드를 이용해서 화면 출력
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage PrimaryStage) throws Exception {

		BorderPane root = new BorderPane();

		// BorderPane의 size 설정

		root.setPrefSize(700, 500);

		ta = new TextArea(); // 글 상자 생성
		root.setCenter(ta); // 중앙에 글상자 넣기

		// Button click - Thread start

		startBtn = new Button("Start Thread"); // 버튼 생성
		startBtn.setPrefSize(250, 50);

		startBtn.setOnAction(e -> {

			countThread = new Thread(() -> {
				
				
				for(int i = 0; i<10; i++) {
					try {
						Thread.sleep(1000); //sleep 하려면 try/catch문 !
						printMSG(i+"값이 출력됨");
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						break;
					}
					
				}
				
			});
			countThread.start();


		});

		// Button click -Thread end

		stopBtn = new Button("Stop Thread");
		stopBtn.setPrefSize(250, 50);

		stopBtn.setOnAction(e ->

		{

///			countThread.stop();  : 기존의 방식, 위험성이 커서 이제 사용하지 않음
			
			countThread.interrupt(); 

			
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(startBtn); // FlowPane에
	
		flowpane.getChildren().add(stopBtn); // FlowPane에 Button을 부착

		root.setBottom(flowpane); // 전체화면의 아랫부분에 FlowPane 부착

		Scene scene = new Scene(root); //
		PrimaryStage.setScene(scene); // window의 화면을 Scene으로 설정
		PrimaryStage.setTitle("Thread Interrupt 예제"); // 윈도우 창의 제목

		PrimaryStage.setOnCloseRequest(e -> {
		

			// 이 창의 x버튼을 눌럿을 때 해야 하는 일

		});

		// Close버튼을 눌렀을때 이벤트 처리

		PrimaryStage.show();
	}

	public static void main(String[] args) {

		// 화면에 창을 띄우기

		launch();

	}

}
