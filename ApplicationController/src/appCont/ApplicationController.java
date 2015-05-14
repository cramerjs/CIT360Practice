package appCont;

import java.util.HashMap;

public class ApplicationController {

	// instantiate private handlerMap
	private HashMap<String, ACHandler> handlerMap = new HashMap<String, ACHandler>();
	
	// 
	public void handleRequest(String cmd, HashMap<String, ?> parameters) {
		
		ACHandler aHandler = (ACHandler)handlerMap.get(cmd);
		aHandler.handleIt(parameters);
		
	}
	
	public ApplicationController() {
		
		handlerMap.put("+", new AddHandler());
		handlerMap.put("login", new LoginHandler());
		
	}

}