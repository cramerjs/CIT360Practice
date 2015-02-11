package view;

import javax.swing.JOptionPane;

public class StartView {
	
	// initial input interface
	
	private int zipCode;
	
	StartView() {
		
		// no arg constructor
		
		zipCode = Integer.parseInt(JOptionPane.showInputDialog("Enter your zipCode."));
		
	}
	
	public int getZipCode() {
		
		return zipCode;
		
	}
	
}