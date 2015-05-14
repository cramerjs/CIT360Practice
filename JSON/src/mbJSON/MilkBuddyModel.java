package mbJSON;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.quickconnectfamily.json.*;	

public class MilkBuddyModel {
	
	public static void main(String[]args) {
		
		GrocerBean pigglyWiggly = new GrocerBean("1.10", "Piggly Wiggly", "89145", "900 N 900 W");
		String jsonString = null;
		
		// Convert an object into a JSON String
		System.out.println("Object -> JSON String:");
		
		try {
			
			jsonString = JSONUtilities.stringify(pigglyWiggly);
			System.out.println("     " + jsonString);
			
		} catch(JSONException e) {
			
			e.printStackTrace();
			
		}
		
		// Convert a JSON String back into an object
		System.out.println("JSON String -> Object:");
		
		try {
			
			HashMap aMap = (HashMap)JSONUtilities.parse(jsonString);
			String priceStr = (String)aMap.get("price");
			String nameStr = (String)aMap.get("name");
			String zipCodeStr = (String)aMap.get("zipCode");
			String streetAddressStr =  (String)aMap.get("streetAddress");
			
			GrocerBean pigglyWiggly2 = new GrocerBean(priceStr, nameStr, zipCodeStr, streetAddressStr);
			
			if (pigglyWiggly2 != null) {
				System.out.println("     Conversion successful!");
			}
			
		} catch(JSONException e) {
			
			e.printStackTrace();
			
		}
		
		// Write JSON to a File
		System.out.println("JSON -> File:");
		
		File aFile = new File("test.json");
		
		try {
			
			FileOutputStream aFileStream = new FileOutputStream(aFile);
			JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
			jsonOut.writeObject(pigglyWiggly);
			jsonOut.close();
			
			if(jsonOut != null) {
				System.out.println("     Conversion Successful!");
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		// Read JSON from a File
		System.out.println("File -> JSON:");
		
		try {
			
			FileInputStream aFileStream = new FileInputStream(aFile);
			JSONInputStream jsonIn = new JSONInputStream(aFileStream);
			HashMap aMap = (HashMap)jsonIn.readObject();
			jsonIn.close();
			System.out.println("     " + aMap);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		// Binary Serialization Out
		System.out.println("Object -> Binary File");
		
		File aBinaryFile = new File("test.bserial");
		
		try {
			
			FileOutputStream aFileStream = new FileOutputStream(aBinaryFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(aFileStream);
			objectOut.writeObject(pigglyWiggly);
			objectOut.close();
			
			if(objectOut != null) {
				System.out.println("     Conversion successful!");
			}
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		// Binary Serialization In
		System.out.println("Binary File -> Object");
		
		try {
			
			FileInputStream aFileStream = new FileInputStream(aBinaryFile);
			ObjectInputStream objectIn = new ObjectInputStream(aFileStream);
			GrocerBean pigglyWiggly3 = (GrocerBean)objectIn.readObject();
			objectIn.close();
			System.out.println("     " + pigglyWiggly3.toString());
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		// XML Serialization Out
		System.out.println("Object -> XML File");
		
		File anXMLFile = new File("test.xml");
		
		try {
			
			FileOutputStream aFileStream = new FileOutputStream(anXMLFile);
			XMLEncoder objectOut = new XMLEncoder(aFileStream);
			objectOut.writeObject(pigglyWiggly);
			objectOut.close();
			
			if(objectOut != null) {
				System.out.println("     Conversion successful!");
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}
		
		// XML Serialization In
		System.out.println("XML File -> Object");
		
		try {
			
			FileInputStream aFileStream = new FileInputStream(anXMLFile);
			XMLDecoder objectIn = new XMLDecoder(aFileStream);
			GrocerBean pigglyWiggly4 = (GrocerBean)objectIn.readObject();
			objectIn.close();
			System.out.print("     " + pigglyWiggly4);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}
	
	}
	
}