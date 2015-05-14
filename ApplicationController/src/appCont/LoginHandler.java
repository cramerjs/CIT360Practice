package appCont;

import java.util.HashMap;

public class LoginHandler implements ACHandler {

	@Override
	public void handleIt(HashMap<?,?> parameters) {
		
		String username = (String) parameters.get("username");
		String pwd = (String) parameters.get("pwd");
		if (username.equals("username") && pwd.equals("password")) {
			System.out.println("Welcome back, " + username + "!");
		} else {
			System.out.println("Incorrect username or password.");
		}
		
	}
	
}
