package mbSockets;

import java.io.IOException;
import java.net.Socket;
import org.quickconnectfamily.json.*;

public class ValidClient {

	public static void main(String[] args) throws IOException, JSONException {
		
		GrocerBean aGrocer = new GrocerBean("1.10", "Piggly Wiggly", "89145", "900 N 900 W");
		
		// set up the socket
		Socket toServer = new Socket("localhost", 9292);
		System.out.println("Connection opened");
		
		// set up the JSON streams
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		
		// send GrocerBean to server
		outToServer.writeObject(aGrocer);
		System.out.println("Client: GrocerBean sent");
		
		// read message from server
		String message = (String)inFromServer.readObject();
		System.out.println("Message from Server: " + message);
		
		// close connection
		toServer.close();
		System.out.println("Connection closed");
		
	}

}
