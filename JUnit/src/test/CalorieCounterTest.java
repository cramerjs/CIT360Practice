package test;

import static org.junit.Assert.*;

import org.junit.*;

import calorieCounter.CalorieCounter;
import calorieCounter.PersonBean;

import java.lang.reflect.Field;
import java.util.*;

public class CalorieCounterTest {
	
	@Before
	public void setup() throws Exception {
		// resets all variables to null before running tests
		
		CalorieCounter testCalorieCounter = null;
		PersonBean joe, jeff, kosmo, jerry, noFirstName, noLastName = null;
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddPerson() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		CalorieCounter testCalorieCounter = new CalorieCounter();
		PersonBean joe = new PersonBean("Joe", "Cramer", 137, 3000);
		PersonBean noFirstName = new PersonBean(null, "Dude", 150, 2000);
		
		// add 1 person test
		Field peopleField = testCalorieCounter.getClass().getDeclaredField("people");
		peopleField.setAccessible(true); // make field temporarily accessible for the test
		HashMap people = (HashMap)peopleField.get(testCalorieCounter);
		testCalorieCounter.addPerson(joe);
		int numPeople = people.size();
		assertEquals(1, numPeople);
		people.clear();
		
		// add a null person test
		peopleField.setAccessible(true); // make field temporarily accessible for the test
		people = (HashMap)peopleField.get(testCalorieCounter);
		testCalorieCounter.addPerson(null);
		numPeople = (int) people.get(null);
		assertNull(numPeople);
		
		// add an empty string test
		peopleField.setAccessible(true); // make field temporarily accessible for the test
		people = (HashMap)peopleField.get(testCalorieCounter);
		testCalorieCounter.addPerson(noFirstName);
		numPeople = people.size();
		assertEquals(1, numPeople);
		people.clear();
		
	}
	
	@Test
	public void testGetPerson() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		CalorieCounter testCalorieCounter = new CalorieCounter();
		PersonBean joe = new PersonBean("Joe", "Cramer", 137, 3000);
		PersonBean jeff = new PersonBean("Jeff", "Cramer", 150, 2500);
		PersonBean kosmo = new PersonBean("Kosmo", "Kramer", 200, 3500);
		PersonBean jerry = new PersonBean("Jerry", "Seinfeld", 200, 3500);
		PersonBean noFirstName = new PersonBean(null, "Dude", 150, 2000);
		PersonBean noLastName = new PersonBean("Dudett", null, 70, 1500);
		
		// make field temporarily accessible for the test
		Field peopleField = testCalorieCounter.getClass().getDeclaredField("people");
		peopleField.setAccessible(true);
		HashMap<String, PersonBean> people = (HashMap)peopleField.get(testCalorieCounter);
		
		people.put("Joe", joe);
		people.put("Jeff", jeff);
		people.put("Kosmo", kosmo);
		people.put("Jerry", jerry);
		people.put(null, noFirstName);
		people.put("Dudett", noLastName);
		
		PersonBean joeFromMap = testCalorieCounter.getPerson("Joe");
		assertEquals(joe, joeFromMap);
		
		PersonBean jeffFromMap = testCalorieCounter.getPerson("Jeff");
		assertEquals(jeff, jeffFromMap);
		
		PersonBean noFirstNameFromMap = testCalorieCounter.getPerson(null);
		assertEquals(noFirstName, noFirstNameFromMap);
		
		PersonBean noLastNameFromMap = testCalorieCounter.getPerson("Dudett");
		assertEquals(noLastName, noLastNameFromMap);
		
		PersonBean notPerson = testCalorieCounter.getPerson("Serial No");
		assertNull(notPerson);
		
		people.clear();
		
	}
	
	@Test
	public void testGetWeight() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		CalorieCounter testCalorieCounter = new CalorieCounter();
		PersonBean joe = new PersonBean("Joe", "Cramer", 137, 3000);
		PersonBean jeff = new PersonBean("Jeff", "Cramer", 150, 2500);
		PersonBean kosmo = new PersonBean("Kosmo", "Kramer", 200, 3500);
		PersonBean jerry = new PersonBean("Jerry", "Seinfeld", 200, 3500);
		PersonBean noFirstName = new PersonBean(null, "Dude", 150, 2000);
		PersonBean noLastName = new PersonBean("Dudett", null, 70, 1500);
		
		// make fields temporarily accessible for the test
		Field weightsField = testCalorieCounter.getClass().getDeclaredField("weights");
		weightsField.setAccessible(true);
		HashMap<String, Integer> weights = (HashMap)weightsField.get(testCalorieCounter);
		
		Field weightField = testCalorieCounter.getClass().getDeclaredField("weight");
		weightField.setAccessible(true);
		Integer weight = (Integer)weightField.get(testCalorieCounter);
		
		// get Joe's weight test
		weightsField.setAccessible(true);
		weights = (HashMap)weightsField.get(testCalorieCounter);
		weights.put("Joe", 137);
		int joeWeight = testCalorieCounter.getWeight("Joe");
		assertEquals(137, joeWeight);
		
		// get null weight test
		int nullWeight = testCalorieCounter.getWeight(null);
		assertEquals(0, nullWeight);
		
		int notWeight = testCalorieCounter.getWeight("Nobody");
		assertEquals(0, notWeight);
		
		weights.clear();
		
	}
	
}
