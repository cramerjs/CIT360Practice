package calorieCounter;

import java.io.Serializable;

public class PersonBean implements Serializable {

	private String firstName;
	private String lastName;
	private int weight;
	private int dailyCalorieNeed;
	
	public PersonBean() {
		
	}
	
	public PersonBean(String firstName, String lastName, int weight, int dailyCalorieNeed) {
		
		firstName = this.firstName;
		lastName = this.lastName;
		weight = this.weight;
		dailyCalorieNeed = this.dailyCalorieNeed;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDailyCalorieNeed() {
		return dailyCalorieNeed;
	}

	public void setDailyCalorieNeed(int dailyCalorieNeed) {
		this.dailyCalorieNeed = dailyCalorieNeed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dailyCalorieNeed;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PersonBean))
			return false;
		PersonBean other = (PersonBean) obj;
		if (dailyCalorieNeed != other.dailyCalorieNeed)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}