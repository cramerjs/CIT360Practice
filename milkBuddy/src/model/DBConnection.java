package model;

public class DBConnection {
	
	// this class will interact with the database of various stores' milk prices by location
	
	private String storeName = "Walmart";
	private String storeAddress = "110 S Yellowstone Dr.";
	private double price = 1.90;
	
	public double getPrice() {
		
		return this.price;
		
	}
	
	public String getStoreName() {
		
		return this.storeName;
		
	}
	
	public String getStoreAddress() {
		
		return this.storeAddress;
		
	}
	
}