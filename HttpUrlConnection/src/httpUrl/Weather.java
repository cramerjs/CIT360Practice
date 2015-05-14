package httpUrl;

import java.util.HashMap;

public class Weather {

	private String cityName;
	private double currentTemp;
	private double lowTemp;
	private double highTemp;
	
	public Weather() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Weather(HashMap<String, ?> weatherHashMap) {
		
		HashMap<String, ?> mainBlock = (HashMap<String, ?>) weatherHashMap.get("main");
		this.cityName = (String)weatherHashMap.get("name");
		this.currentTemp = (Double)mainBlock.get("temp");
		this.lowTemp = (Double)mainBlock.get("temp_min");
		this.highTemp = (Double)mainBlock.get("temp_max");
		
	}

	public String getCityName() {
		return this.cityName;
	}

	public double getCurrentTemp() {
		return this.currentTemp;
	}

	public double getLowTemp() {
		return this.lowTemp;
	}

	public double getHighTemp() {
		return this.highTemp;
	}
	
}
