package day06;

public class TVTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV t1 = new TV();

		t1.model = "S-tv";
		t1.size = 25;
		t1.powerOn();
		t1.setChannel(11);
		t1.ChannelUp();
		t1.ChannelUp();

		t1.print();

		TV t2 = new TV();
		t2.model = "L-tv";
		t2.size = 32;
		t2.powerOn();
		t2.setChannel(21);
		t2.ChannelDown();

		t2.print();

//		t2 = t1; // 기존값은 gc의 대상이 돼 버린다
//
//		t2.print();
//

		// null로 기존의 값은 gc의 대상이 돼 버린다

		System.out.println("============");
		new TV().print(); // temporary한 객체 힙에 저장됨 -> 주소가 없음 -> 사용이 안됨 ->사용하자마자 버린다
		System.out.println("============");

		TV[] tvs = new TV[30];
		// tvs라는 주소 -> tv타입으로 주소가 저장될 방 3개 [null] [null] [null] (기본값 null)

		tvs[0] = t1;
		tvs[1] = t2;

		// 주소값 저장한다

		t2 = null;
		t1 = null;

		for (int i = 0; i < tvs.length; i++) {

			if (tvs[i] != null) {
				tvs[i].powerOn();
				tvs[i].print();
			}

			if (tvs[i] == null)
				break;

		}

	}

}

class TV {

	int size;
	String model;
	int channel;
	boolean power;

	public void print() {
		System.out.printf("(모델 : %s, 사이즈 : %d, 파워 : %b, 채널 : %d)%n", model, size, power, channel);
	}

	public void powerOn() {
		power = true;

		// this.power
	}

	public void powerOff() {
		power = false;

		// this.power
	}

	public void setChannel(int c) {
		channel = c;
		// this.channel
	}

	public void ChannelUp() {
		channel++;
		// this.channel
	}

	public void ChannelDown() {
		channel--;
		// this.channel
	}

}