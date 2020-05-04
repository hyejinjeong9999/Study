package test;

import java.util.HashMap;

public class HandlerMapping {
	
	HashMap<String, Controller> mappings;
	// url에 hello가 입력되면 hellocontroller를 호출하겠다
	//mapping : 짝지어준다
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController());
	}
	
	public Controller getController(String name) {
		return mappings.get(name);
		
	}

}
