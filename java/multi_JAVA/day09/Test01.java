package day09;

import javax.swing.JOptionPane;

public class Test01 {

	public static void main(String[] args) {

		Command cmd = null;

		String msg = JOptionPane.showInputDialog("명령을 입력하세요 1. delete 2. insert 3.update");

		switch (msg) {
		case "1":
		case "delete":
			cmd = new DeleteCommand();

			break;

		case "2":
		case "insert":
			cmd = new InsertCommand();

			break;

		case "3":
		case "update":
			cmd = new UpdateCommand();

			break;

		default:
			System.out.println("명령 선택을 다시 해주세요");
			break;
		}

		if (cmd != null) {
			cmd.exec();
			cmd.bases();
		}

	}

}

interface Command {

	void exec();

	default public void bases(){ //인터페이스에서 기능 추가가 쉬워지는 기능
		System.out.println("command base()기능");
	}

}

class DeleteCommand implements Command {

	@Override
	public void exec() {
		System.out.println("DeleteCommand 수행");
	}

}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		System.out.println("UpdateCommand 수행");
	}
	public void bases(){
		System.out.println("command base()기능 재정의");
	}

}

class InsertCommand implements Command {

	@Override
	public void exec() {
		System.out.println("InsertCommand 수행");
	}

}
