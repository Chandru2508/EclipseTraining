package com.hema.sampleHib;

import jakarta.persistence.Column;
//Import the necessary annotations from Jakarta Persistence API
import jakarta.persistence.Entity; // Marks the class as a JPA entity, meaning it maps to a database table
import jakarta.persistence.Id;    // Specifies the primary key of the entity
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//Marks the class as a JPA entity, indicating it will map to a table in the database

//@Entity

//@Table(name="Student_Table") // This annotation specifies the name of the database table that the entity is mapped to. 
//If this annotation is not present, Hibernate assumes the table name is the same as the entity name or the class name.

@Entity(name="Student_Table")  // This annotation marks the class as a Hibernate entity. 
//The "name" attribute here defines the entity name that can be used in JPQL queries. 
//If not specified, the default entity name is the class name.

public class Student {

 // Specifies the 'sid' field as the primary key column in the database table
		@Id
		@Column(name = "Student_Id")
		private long sid; // This field represents the unique identifier for the entity, usually used as the primary key.
					// It does not have any specific annotations here, but in a complete entity, it would typically be marked with @Id.

//		@Transient 
		@Column(name = "Name")
		private StudentName sName; // The @Transient annotation indicates that this field should not be persisted in the database.
					// Hibernate will ignore this field when mapping the entity to the table.
					// This is useful for temporary or calculated fields that do not need to be stored.

		@Column(name = "Marks") // This annotation maps the field to a database column named "Marks".
					// The "name" attribute explicitly specifies the column name in the database.
					// If not specified, Hibernate assumes the column name is the same as the field name (in this case, `sMark`).
		private int sMark; // Represents the student's marks, which will be persisted in the "Marks" column of the table.

		
		public long getsid() {
			return sid;
		}
		public void setsid(long sid) {
			this.sid = sid;
		}
		public StudentName getsName() {
			return sName;
		}
		public void setsName(StudentName sName) {
			this.sName = sName;
		}
		public int getsMark() {
			return sMark;
		}
		public void setsMark(int sMark) {
			this.sMark = sMark;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sName=" + sName + ", sMark=" + sMark + "]";
		}
		
		
}
