package readingBankbook;

import java.util.Scanner;

public class Menu {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		String cmd = null;
		while (true) {
			System.out.println("å ���� �Է� ���� ����...");
			System.out.println("====���Ͻô� �޴��� �Է����ּ���====\n");

			System.out.println("1.��                      ��\n");
			System.out.println("2.��                     ��\n");
			System.out.println("3.��                     ��\n");
			System.out.println("4.��     ��     ��     ��\n");
			System.out.println("9. ����\n");

			cmd = scanner.nextLine().trim();

			switch (cmd) {
			case "1":

				System.out.println("å�� �������ּ���...");

				break;
			case "2":

				System.out.println("������ ������ �Է��ϼ���...");

				break;
			case "3":
				System.out.println("������ å ������ �Է����ּ���...");

				break;

			case "4":
				System.out.println("====�˻� ���===");

				break;
			case "5":
				System.out.println("===�������� ���===");
				System.out.println("�˻��� å ������ �Է����ּ���...");

				break;
			case "9":
				System.out.println("����â");
				System.out.println("���Ḧ ���Ͻø� q�� �Է��ϼ���");
				if (scanner.nextLine().equalsIgnoreCase("q")) {
					System.out.println("�������α׷� ����...");
					scanner.close();
					scanner = null;
					return;
				} else {
					break;
				}

			default:
				System.out.println("����� �� ���� �Է����ּ���");

			}

		}
	}

}
