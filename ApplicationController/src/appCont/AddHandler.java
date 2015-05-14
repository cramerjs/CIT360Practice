package appCont;

import java.util.HashMap;

public class AddHandler implements ACHandler {

	@Override
	public void handleIt(HashMap<?,?> parameters) {
		
		int first = (int) parameters.get("firstNum");
		int second = (int) parameters.get("secondNum");
		int sum = first + second;
		System.out.println(first + " + " + second + " = " + sum);
		
	}
	
}
