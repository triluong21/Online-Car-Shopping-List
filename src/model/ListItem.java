package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class ListItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="YEAR")
	private String year;

	public ListItem() {
		
	}
	
	/* Helper methods*/
	public ListItem (String m, String o, String y) {
		this.make = m;
		this.model = o;
		this.year = y;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		System.out.println("I am in toString");
		return "ListItem [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + "]";
		
	}
	
	public String returnItemDetails() {
		return make + ": " + model + ": " + year;
	}
}
