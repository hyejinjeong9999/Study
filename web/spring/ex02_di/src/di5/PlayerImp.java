package di5;

public class PlayerImp implements Player {

	String name;
	String position;
	String gameName;

	public PlayerImp(){
		
	}

	public PlayerImp(String name, String position, String gameName){
		super();
		this.name = name;
		this.position = position;
		this.gameName = gameName;
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public void play() {

		System.out.println(this.getName() + "이 " + this.getPosition()+"에서 "+this.getGameName()+" 을(를)합니다");

	}

}