package view;

import model.DBConnection;
import view.PriceView;
import view.StartView;
import controller.PriceDataController;

public class MilkBuddy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StartView theStartView = new StartView();
		PriceView thePriceView = new PriceView();
		DBConnection theDB = new DBConnection();
		PriceDataController thePDC = new PriceDataController(theStartView, thePriceView, theDB);

	}

}
