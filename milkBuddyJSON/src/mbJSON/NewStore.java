package mbJSON;

import java.io.FileOutputStream;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class NewStore {

	HashMap aMap = new HashMap();
	
	aMap.put("storeName", "Piggly Wiggly");
	
//	String store Name = new String("Piggly Wiggly");
	String storeAddress = new String("1301 W. Sahara Ave.");
	int storeZipCode = 89145;
	double price = 2.10;

	NewStore() {

		try {

			FileOutputStream aFileOutStream = new FileOutputStream("testFile.txt");

			JSONOutputStream aJSONFileStream = new JSONOutputStream(aFileOutStream);
			
			aJSONFileStream.writeObject(aMap);
			
		}

		catch (Exception e) {

			
			
		}

	}
	
}
