package JavaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EXAM01_ThreadBasic extends Application {

	private TextArea ta;
	private Button btn;

	private void printMSG(String msg) {
		//Thread.currentThread() : 현재 사용되는 Thread의 reference를 알아오는 방법
		
		Platform.runLater(() -> {
			System.out.println(Thread.currentThread().getName()); 
			ta.appendText(msg + "\n");

		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage PrimaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName()); 

		BorderPane root = new BorderPane();

		root.setPrefSize(700, 500);

		ta = new TextArea();
		root.setCenter(ta);

		btn = new Button("버튼 클릭");
		btn.setPrefSize(250, 50);

		btn.setOnAction(e -> {

			printMSG("버튼클릭");
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("예제용 JavaFx");

		PrimaryStage.setOnCloseRequest(e -> {

			System.exit(0);

		});

		PrimaryStage.show();
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); 
					//현재 수행하고잇는 쓰레드확인
		launch();

	}

}
