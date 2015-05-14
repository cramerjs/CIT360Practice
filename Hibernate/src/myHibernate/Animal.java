package myHibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {

	@Id 			// PRIMARY KEY
	@GeneratedValue // AUTO INCREMENT
	@Column(name="animal_id") // Since the names are different, indicate which column this attribute is associated with
	private Integer animal_id;
	
	// This line is needed to associate the table's column to the this class attribute because
	// their names do not match. If they did, we would not need this.
	@Column(name="name") 
	private String name;
	
	// Declare the variable that will hold the set of animals
//	private Set<Animal> animals;

	// GETTERS AND SETTERS
	public int getAnimalId(){
		return animal_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	public Set<Animal> getAnimals() {
//		return animals;
//	}
//	
//	public void setAnimals(Set<Animal> animals) {
//		this.animals = animals;
//	}
}