package chatServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//한명의 클라이언트와 통신하도록 하는 클라이언트 클래스
public class Client {

	Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}

	// 반복적으로 클라이언트로부터 메시지를 받는 메소드
	public void receive() {
		Runnable thread = new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {

						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						if (length == -1)
							throw new IOException();
						
						//어떤쓰레드가 접속되었는지 확인
						System.out.println("[ 메시지 수신 성공 ]" + socket.getRemoteSocketAddress() + ":"
								+ Thread.currentThread().getName());
						//main의 클라이언트에 있는 메시지받기
						String message = new String(buffer, 0, length, "UTF-8");
						for (Client client : Main.clients) {
							client.send(message);
						}

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		Main.threadPool.submit(thread);

	}

	// 해당 클라이언트에게 메시지를 전송하는 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		Main.threadPool.submit(thread);

	}

}
