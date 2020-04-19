package JavaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EXAM07_ThreadpoolBasic extends Application {

	private TextArea ta;
	private Button initBtn, startBtn, shutdownBtn;

	private ExecutorService executorService;

	private void printMSG(String msg) {

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

		initBtn = new Button("Thrad pool 생성");
		initBtn.setPrefSize(250, 50);
		initBtn.setOnAction(e -> {

			//executorService = Executors.newFixedThreadPool(5); //5개로 고정된 pool
			executorService = Executors.newCachedThreadPool();   //필요한 만큼 사용 개수 늘어남 thread는 VM이 판단 
			printMSG("pool 안의 Thread 개수" + ((ThreadPoolExecutor) (executorService)).getPoolSize());

		});

		startBtn = new Button("Thrad 생성");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(e -> {
			for (int i = 0; i < 10; i++) {
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						
						String msg = "Thread Pool 안의 개수" + 
						((ThreadPoolExecutor)(executorService)).getPoolSize();
						
						msg += ", Thread Name : " + Thread.currentThread().getName();

						printMSG(msg);
					}

				};
				
				executorService.execute(runnable);
			}

		});

		shutdownBtn = new Button("Thrad pool 종료");
		shutdownBtn.setPrefSize(250, 50);
		shutdownBtn.setOnAction(e -> {
			executorService.shutdown();

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(initBtn); // FlowPane에 Button을 부착
		flowpane.getChildren().add(startBtn); // FlowPane에 Button을 부착
		flowpane.getChildren().add(shutdownBtn); // FlowPane에 Button을 부착

		root.setBottom(flowpane); // 전체화면의 아랫부분에 FlowPane 부착

		Scene scene = new Scene(root); //
		PrimaryStage.setScene(scene); // window의 화면을 Scene으로 설정
		PrimaryStage.setTitle("예제용 JavaFx"); // 윈도우 창의 제목

		PrimaryStage.setOnCloseRequest(e -> {

		});

		// Close버튼을 눌렀을때 이벤트 처리

		PrimaryStage.show();
	}

	public static void main(String[] args) {

		// 화면에 창을 띄우기

		launch();

	}

}
