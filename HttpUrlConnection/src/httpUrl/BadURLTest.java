package httpUrl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;

public class BadURLTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {
			
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=lostwages");
			HttpURLConnection link = (HttpURLConnection) url.openConnection();
			JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
			HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
			Weather theWeather = new Weather(jsonWeather);
			printWeather(theWeather);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	
	}

	private static void printWeather(Weather theWeather) {
		
		System.out.println("City: " + theWeather.getCityName());
		System.out.println("Current Temperature: " + convertKelvinToFahrenheit(theWeather.getCurrentTemp()));
		System.out.println("Low Temperature: " + convertKelvinToFahrenheit(theWeather.getLowTemp()));
		System.out.println("High Temperature: " + convertKelvinToFahrenheit(theWeather.getHighTemp()));
		
	}
	
	private static long convertKelvinToFahrenheit(double kelvin) {
		
		long fahrenheit = (long) Math.round((kelvin - 273.15) * 1.8 + 32);
		return fahrenheit;
		
	}
	
}
