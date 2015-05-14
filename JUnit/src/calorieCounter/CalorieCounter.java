package calorieCounter;

import java.util.*;

// written using test-driven development concepts

public class CalorieCounter {

	private HashMap<String, PersonBean> people = new HashMap<String, PersonBean>();
	private HashMap<String, Integer> weights = new HashMap<String, Integer>();
	private PersonBean person = null;
	private int weight = 0;
	
	public CalorieCounter() {
		
		HashMap<String, PersonBean> people = this.people;
		HashMap<String, Integer> weights = this.weights;
		PersonBean person = this.person;
		int weight = this.weight;
		
	}
	
	public void addPerson(PersonBean person) {
		
		try {
			people.put(person.getFirstName(), person);
		} catch(Exception e) {
			people.put(null, null);
		}
		
	}
	
	public PersonBean getPerson(String firstName) {
		
		PersonBean person = null;
		if(people.containsKey(firstName)) 
			person = people.get(firstName);
		return person;
		
	}
	
	public int getWeight(String firstName) {
		
		try {
			int weight = weights.get(firstName);
			return weight;
		} catch(Exception e) {
			int weight = 0;
			return weight;
		}
		
	}
	
}