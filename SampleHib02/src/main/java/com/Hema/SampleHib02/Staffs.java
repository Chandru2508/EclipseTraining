package com.Hema.SampleHib02;

// Importing necessary classes for JPA annotations and collections
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity; // Marks this class as a JPA entity
import jakarta.persistence.FetchType; // Used to specify fetch strategy (EAGER or LAZY)
import jakarta.persistence.Id; // Marks a field as the primary key
import jakarta.persistence.OneToMany; // Defines a one-to-many relationship between entities

// Marking the class as a JPA entity (mapped to a database table)
@Entity
public class Staffs {

	// Defining the primary key field for the Staffs entity
	@Id
	private int staff_id;

	// Defining a simple column for the staff name
	private String Name;
	
	// Defining a one-to-many relationship with the Laptop entity
	// `mappedBy="satffs"` indicates that the "satffs" field in the Laptop entity is responsible for this relationship
	// `fetch = FetchType.EAGER` ensures that the Laptop collection is loaded immediately when the Staffs entity is loaded
	
	@OneToMany(mappedBy = "satffs", fetch = FetchType.EAGER)
	private Collection<Laptop> laptop = new ArrayList<>();

	// Getter for staff_id
	public int getStaff_id() {
		return staff_id;
	}

	// Setter for staff_id
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	// Getter for Name
	public String getName() {
		return Name;
	}

	// Setter for Name
	public void setName(String sName) {
		this.Name = sName;
	}

	// Getter for the Laptop collection
	public Collection<Laptop> getLaptop() {
		return laptop;
	}

	// Setter for the Laptop collection
	public void setLaptop(Collection<Laptop> laptop) {
		this.laptop = laptop;
	}

	// Overriding the `toString()` method to provide a custom string representation of the Staffs object
	@Override
	public String toString() {
		return "Staffs [staff_id=" + staff_id + ", Staff Name=" + Name + "]";
	}

	/*
	 * Explanation of EAGER Fetching:
	 * 1. `fetch = FetchType.EAGER` means the associated Laptop collection will be fetched
	 *    from the database along with the Staffs entity, even if the collection is not accessed explicitly.
	 * 2. This is useful when the related data (Laptop in this case) is always required with the parent entity.
	 * 3. However, EAGER fetching can lead to performance issues if the associated collection is large,
	 *    as it results in additional queries or a single large query with joins.
	 * 4. Use EAGER fetching carefully to avoid unnecessary data loading and memory usage.
	 */

}
