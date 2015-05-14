package mbSockets;

import java.io.IOException;
import java.net.Socket;
import org.quickconnectfamily.json.*;

public class EmptyStringClient {

	public static void main(String[] args) throws IOException, JSONException {
		
		// set up the socket
		Socket toServer = new Socket("localhost", 9292);
		System.out.println("Connection opened");
		
		// set up the JSON streams
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		
		// send GrocerBean to server
		outToServer.writeObject("");
		System.out.println("Client: Empty String sent");
		
		// read message from server
		String message = (String)inFromServer.readObject();
		System.out.println("Message from Server: " + message);
		
		// close connection
		toServer.close();
		System.out.println("Connection closed");
		
	}

}
