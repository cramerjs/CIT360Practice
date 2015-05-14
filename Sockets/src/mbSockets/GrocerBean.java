package mbSockets;

import java.io.Serializable;
import java.util.HashMap;

public class GrocerBean implements Serializable {

	private String price;
	private String name;
	private String zipCode;
	private String streetAddress;
	
	public GrocerBean() {
		
	}
	
	public GrocerBean(String aPrice, String aName, String aZipCode, String aStreetAddress) {
		
		price = aPrice;
		name = aName;
		zipCode = aZipCode;
		streetAddress = aStreetAddress;
		
	}
	
	public GrocerBean(HashMap<String, ?> aHashMap) {
		
		price = (String)aHashMap.get("price");
		name = (String)aHashMap.get("name");
		zipCode = (String)aHashMap.get("zipCode");
		streetAddress = (String)aHashMap.get("streetAddress");
		
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "GrocerBean [price=" + price + ", name=" + name + ", zipCode="
				+ zipCode + ", streetAddress=" + streetAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GrocerBean))
			return false;
		GrocerBean other = (GrocerBean) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
}