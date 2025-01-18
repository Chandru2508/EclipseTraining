package com.Hema.sampleHib01;

// Importing required JPA annotations and utilities
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column; // Used for mapping entity attributes to database columns
import jakarta.persistence.Entity; // Marks this class as a JPA entity
import jakarta.persistence.Id; // Marks this field as the primary key
import jakarta.persistence.ManyToMany; // Defines a many-to-many relationship

@Entity
// Marks this class as a Hibernate entity, which will be mapped to a table in the database
public class Student {

    @Id
    @Column(name = "Student_Id")
    // Marks this field as the primary key and maps it to the "Student_Id" column in the database
    private long sid;

    @Column(name = "Student_Name")
    // Maps this field to the "Student_Name" column in the database
    private String sName;

    @Column(name = "Student_Marks")
    // Maps this field to the "Student_Marks" column in the database
    private int sMark;

    @ManyToMany(mappedBy = "student")
    // Defines a many-to-many relationship between Student and Laptop entities.
    // The "mappedBy" attribute indicates that this is the inverse side of the relationship
    // and is mapped by the "student" property in the Laptop entity.
    private List<Laptop> laptop = new ArrayList<>();

    // Getter method for the `sid` field
    public long getSid() {
        return sid;
    }

    // Setter method for the `sid` field
    public void setSid(long sid) {
        this.sid = sid;
    }

    // Getter method for the `sName` field
    public String getsName() {
        return sName;
    }

    // Setter method for the `sName` field
    public void setsName(String sName) {
        this.sName = sName;
    }

    // Getter method for the `sMark` field
    public int getsMark() {
        return sMark;
    }

    // Setter method for the `sMark` field
    public void setsMark(int sMark) {
        this.sMark = sMark;
    }

    // Getter method for the `laptop` list, which represents the many-to-many relationship
    public List<Laptop> getLaptop() {
        return laptop;
    }

    // Setter method for the `laptop` list
    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        // Overrides the `toString()` method to provide a meaningful string representation of the Student object
        return "Student [sid=" + sid + ", sName=" + sName + ", sMark=" + sMark + "]";
    }
}
