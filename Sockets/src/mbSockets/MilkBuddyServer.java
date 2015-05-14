package mbSockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.*;

public class MilkBuddyServer {

	public static void main(String[] args) throws IOException, JSONException {

		while (true) {

			// set up server socket
			ServerSocket aListeningSocket = new ServerSocket(9292);
			System.out.println("Waiting for client connection request.");
			Socket clientSocket = aListeningSocket.accept();
			// aListeningSocket.setSoTimeout(5000);

			// set up the JSON streams
			JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
			JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());
			// read until the client closes the connection

			try {

				System.out.println("Waiting for a message from the server.");
				HashMap<String, ?> parsedJSONMap = (HashMap<String, ?>) inFromClient.readObject();
				System.out.println("Object read");

				// create a GrocerBean from the JSONInputStream
				GrocerBean aGrocer = new GrocerBean(parsedJSONMap);

				String message = "The Grocer has been created.";
				outToClient.writeObject(message);

				
				System.out.println(aGrocer.getName() + " - " + aGrocer.getPrice());
				

			} catch (Exception e) {

				e.printStackTrace();
				System.exit(1);

			}

			aListeningSocket.close();
			
		}

	}

}