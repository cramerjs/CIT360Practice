package view;

import javax.swing.JOptionPane;

public class PriceView {
	
	// output interface
	
	private double price;
	private String storeName;
	private String storeAddress;
	
	PriceView() {
		
	}
	
	public void displayStoreNameStoreAddressPrice() {
		
		JOptionPane.showMessageDialog(null, "Store: " + storeName + "\nAddress: " + storeAddress + "\nPrice: " + price);
		
	}
	
	public void setPrice(double price) {
		
		this.price = price;
		
	}
	
	public void setStoreName(String storeName) {
		
		this.storeName = storeName;
		
	}
	
	public void setStoreAddress(String storeAddress) {
		
		this.storeAddress = storeAddress;
		
	}
	
	public void displayErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog(null, errorMessage);

	}
	
}