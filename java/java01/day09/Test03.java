package day09;

import javax.swing.JOptionPane;

public class Test03 {

	public static void main(String[] args) {
		Controller cmd = null;

		Controller insert = new Controller() {
			// (implements 생략)
			@Override
			public void exec() {

				System.out.println("insert 수행");

			}

		};
		// 이위치에서 직접 클래스를 정의하고 디자인할 것임

		Controller update = new Controller() {

			@Override
			public void exec() {

				System.out.println("update 수행");

			}
		};

		Controller delete = new Controller() {

			@Override
			public void exec() {
				System.out.println("delete 수행");
			}
		};

		String msg = JOptionPane.showInputDialog("명령을 입력하세요 1. delete 2. insert 3.update");

		switch (msg) {
		case "1":
		case "delete":
			cmd = delete;

			break;

		case "2":
		case "insert":
			cmd = insert;

			break;

		case "3":
		case "update":
			cmd = update;

			break;

		default:
			System.out.println("명령 선택을 다시 해주세요");
			break;
		}

		if (cmd != null) {
			cmd.exec();

		}

	}

}

interface Controller {

	void exec();

}

class DeleteController implements Controller {

	@Override
	public void exec() { // interface를 완성

		System.out.println("DeleteController 수행");

	}

}