package com.Hema.SampleHib02;

// Importing necessary JPA annotations
import jakarta.persistence.Entity; // Marks the class as a JPA entity
import jakarta.persistence.Id; // Marks a field as the primary key
import jakarta.persistence.ManyToOne; // Defines a many-to-one relationship between entities

// Marking the class as a JPA entity, meaning it will be mapped to a database table
@Entity
public class Laptop {
	
	// Marking the lap_id field as the primary key for the Laptop entity
	@Id
	private int lap_id;

	// Simple column to store the brand of the laptop
	private String brand;

	// Simple column to store the price of the laptop
	private int price;
	
	// Defining a many-to-one relationship with the Staffs entity
	// This means multiple Laptop entities can be associated with a single Staffs entity
	@ManyToOne
	private Staffs satffs;

	// Getter for lap_id
	public int getLap_id() {
		return lap_id;
	}

	// Setter for lap_id
	public void setLap_id(int lapId) {
		this.lap_id = lapId;
	}

	// Getter for brand
	public String getBrand() {
		return brand;
	}

	// Setter for brand
	public void setBrand(String brand) {
		this.brand = brand;
	}

	// Getter for price
	public int getPrice() {
		return price;
	}

	// Setter for price
	public void setPrice(int price) {
		this.price = price;
	}

	// Getter for satffs (the associated Staffs entity)
	public Staffs getSatffs() {
		return satffs;
	}

	// Setter for satffs (the associated Staffs entity)
	public void setSatffs(Staffs satffs) {
		this.satffs = satffs;
	}

	// Overriding the toString() method to provide a custom string representation of the Laptop object
	@Override
	public String toString() {
		return "Laptop [lapId=" + lap_id + ", brand=" + brand + ", price=" + price + "]";
	}

	/*
	 * Explanation of @ManyToOne:
	 * 1. This annotation defines the relationship between the Laptop entity and the Staffs entity.
	 * 2. In a many-to-one relationship, multiple Laptop objects can reference a single Staffs object.
	 * 3. The `satffs` field will store the reference to the associated Staffs entity.
	 * 4. The relationship is bidirectional because the Staffs entity has a @OneToMany mapping to Laptop.
	 * 5. The foreign key column for this relationship will be created in the Laptop table.
	 */
}
