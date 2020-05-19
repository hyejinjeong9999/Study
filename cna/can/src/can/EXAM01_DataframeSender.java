package can;

import java.io.BufferedInputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//JAVAFX�� ���
public class EXAM01_DataframeSender extends Application {

	private TextArea textArea;
	private Button connBtn, sendBtn, receiveBtn;

	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private SerialPort serialPort;

	private OutputStream out;

	private BufferedInputStream bis;

	// CAN DataFrame을 받기
	// 1. 환경설정 쓰기 : 환경설정에 대한 내용을 dataframe으로 만들어서 can에 전송
	// 2 . 데이터 수신 Enable 작업

	// 데이터 있으면
	class MyportListener implements SerialPortEventListener {

		@Override
		public void serialEvent(SerialPortEvent event) {

			if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				byte[] readBuffer = new byte[128];
				try {
					while (bis.available() > 0) {
						bis.read(readBuffer);
					}
					String result = new String(readBuffer);
					printMSG("받는 메세지 : " + result);

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private void printMSG(String msg) {

		Platform.runLater(() -> {
			textArea.appendText(msg + "\n");

		});

	}

	// 접속
	private void connectPort(String portName) {

		try {

			portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("이미 있는 포트번호");
			} else {
				commPort = portIdentifier.open("portOpen", 4000);
				if (commPort instanceof SerialPort) {
					serialPort = (SerialPort) commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, serialPort.STOPBITS_1,
							serialPort.PARITY_NONE);

					serialPort.addEventListener(new MyportListener());
					serialPort.notifyOnDataAvailable(true);
					printMSG("접속 성공");

					bis = new BufferedInputStream(serialPort.getInputStream());

					out = serialPort.getOutputStream();

				}

			}

		} catch (Exception e) {
			System.out.println("여긴가봐요" + e);
		}

	}

	// 실제 데이터를 전송하는 method
	private void sendDataFrame(String msg) {

		// 프로토콜을 알아야지 그 형식대로 message를 만들어서 전송
		// CRC를 계산하기 위해서 약간의 처리가 필요하다
		// W28000000060000000000000011
		int checksomData = 0;
		msg = msg.toUpperCase();
		char c[] = msg.toCharArray();
		for (char cc : c) {
			checksomData += cc; // 각각의 캐릭터들을 더해서 누적
		}

		checksomData = (checksomData & 0XFF);

		// 숫자를 받아서 hex문자열로 변환
		String sendMSG = ":" + msg + Integer.toHexString(checksomData) + "\r";

		printMSG("보내려는 데이터는 " + sendMSG + "입니다");

		byte[] send = sendMSG.getBytes();
		try {
			out.write(send);
			System.out.println("성공적으로 전송");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		textArea = new TextArea();
		root.setCenter(textArea);

		connBtn = new Button("Com통신 ");
		connBtn.setPrefSize(200, 50);
		connBtn.setPadding(new Insets(10));
		connBtn.setOnAction(e -> {
			String portNum = "COM10";
			connectPort(portNum);

		});

		sendBtn = new Button("DATA Frame 전송");
		sendBtn.setPrefSize(200, 50);
		sendBtn.setPadding(new Insets(10));
		sendBtn.setOnAction(e -> {
			String msg = "W28000000060000000000000011";
			sendDataFrame(msg);

		});

		// 데이터를 받기위한 버튼
		receiveBtn = new Button("DATA Frame 받기");
		receiveBtn.setPrefSize(200, 50);
		receiveBtn.setPadding(new Insets(10));
		receiveBtn.setOnAction(e -> {
			String msg = "Z380f3400000006";
			sendDataFrame(msg);

			// CANPro 환경 설정 쓰기 참고
			// 수신자 환경설정

			String datareceiveStart = ":G11A9\r";
			// G11 : 데이터를 받기 시작하겠다
			try {
				byte[] inputData = datareceiveStart.getBytes();
				out.write(inputData);
				printMSG("수신");
			} catch (Exception e1) {
				System.out.println(e1);

			}
			// CAN 데이터 수진 여부 환경읽기 및 설정 - 동작 요청 명령

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.getChildren().add(connBtn);
		flowpane.getChildren().add(sendBtn);
		flowpane.getChildren().add(receiveBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CAN통신");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
