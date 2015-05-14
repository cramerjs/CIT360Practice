package myHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exhibit")
public class Exhibit {
	
	@Id 			   // PRIMARY KEY
	@GeneratedValue    // AUTO INCREMENT
	@Column(name="exhibit_id") // As the names are different, indicate which column this attribute is associated with
	private Integer exhibit_id;
	
	@Column(name="name")
	private String name;
	
	// Getters and Setters for attributes/columns
	public Integer getExhibitId() {
		return exhibit_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}