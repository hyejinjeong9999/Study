package di;

public class Mainentry {

	public static void main(String[] args) {
		
		show();
		
		MessageBean m = new MessageBean();
				m.sayHello("혜진");
		
		

	}
	
	public static void show() {
		
		System.out.println("show method call~");
	}

}

