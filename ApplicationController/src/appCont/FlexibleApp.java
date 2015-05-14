package appCont;

import java.util.HashMap;
import java.util.Scanner;

public class FlexibleApp {

	public FlexibleApp() {
		
//		calculator();
//		login();
		loginEmptyParams();
//		logoutNoHandler();
		
	}
	
	public static void main(String[] args) {
		
		FlexibleApp theFlexibleApp = new FlexibleApp();
		
	}
	
	public void calculator() {
		
		ApplicationController theController = new ApplicationController();
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("First number: ");
		int firstNum = Integer.parseInt(userInput.nextLine());
		System.out.print("Operator (+): ");
		String cmd = userInput.nextLine();
		System.out.print("Second number: ");
		int secondNum = Integer.parseInt(userInput.nextLine());
		userInput.close();
		
		HashMap<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("firstNum", firstNum);
		parameters.put("secondNum", secondNum);
		
		theController.handleRequest(cmd, parameters);
		
	}
	
	public void login() {

		ApplicationController theController = new ApplicationController();	
		Scanner userInput = new Scanner(System.in);
		
		String cmd = "login";
		System.out.print("Username: ");
		String username = (String) userInput.nextLine();
		System.out.print("Password: ");
		String pwd = (String) userInput.nextLine();
		userInput.close();
		
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", username);
		parameters.put("pwd", pwd);
		
		theController.handleRequest(cmd, parameters);
		
	}

	// The next two methods are badly written on purpose for testing/experimentation
	
	// the LoginHandler
	public void loginEmptyParams() {
		
		ApplicationController theController = new ApplicationController();	
		Scanner userInput = new Scanner(System.in);
		
		String cmd = "login";
		System.out.print("Username: ");
		String username = (String) userInput.nextLine();
		System.out.print("Password: ");
		String pwd = (String) userInput.nextLine();
		userInput.close();
		
		HashMap<String, String> parameters = new HashMap<String, String>();
		
		theController.handleRequest(cmd, parameters);
		
	}
	
	public void logoutNoHandler() {
		
		ApplicationController theController = new ApplicationController();	
		Scanner userInput = new Scanner(System.in);

		String cmd = "logoutNoHandler";
		System.out.print("Type L then Enter to Logout: ");
		String logout = (String) userInput.nextLine();
		userInput.close();
		
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("logoutNoHandler", logout);
		
		theController.handleRequest(cmd, parameters);
		
	}

}
