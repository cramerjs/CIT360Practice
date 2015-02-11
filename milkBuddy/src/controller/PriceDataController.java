package controller;

import view.PriceView;
import view.StartView;
import model.DBConnection;

public class PriceDataController {

	private StartView theStartView;
	private PriceView thePriceView;
	private DBConnection theDB;

	public PriceDataController(StartView theStartView, PriceView thePriceView,
			DBConnection theDB) {

		this.theStartView = theStartView;
		this.thePriceView = thePriceView;
		this.theDB = theDB;

		try {

			int zipCode = theStartView.getZipCode();
			double price = 0;
			String storeName = null;
			String storeAddress = null;
			
			String errorDBDisconnected = " ***Database Unreachable*** ";
			
			if (zipCode == 89145) {
				
				storeName = theDB.getStoreName();
				storeAddress = theDB.getStoreAddress();
				price = theDB.getPrice();
				
			} else {
			
			thePriceView.displayErrorMessage(errorDBDisconnected);
			
			}
			
			thePriceView.setPrice(price);
			thePriceView.setStoreAddress(storeAddress);
			thePriceView.setStoreName(storeName);
			
			thePriceView.displayStoreNameStoreAddressPrice();
			
		} 
		
		catch (NumberFormatException ex) {
			
			System.out.println(ex);
			
			thePriceView.displayErrorMessage("We're sorry. We cannot find any prices for that zip code.");
			
		}

	}

}