package com.Hema.sampleHib01;

// Importing required annotations for JPA/Hibernate mappings
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column; // Used to define column-level metadata
import jakarta.persistence.Entity; // Marks this class as a JPA entity
import jakarta.persistence.Id; // Marks a field as the primary key
import jakarta.persistence.ManyToMany; // Defines a many-to-many relationship

@Entity
// Marks the class as a Hibernate entity, which will be mapped to a database table
public class Laptop {

    @Id
    @Column(name = "Laptop_Id")
    // Marks this field as the primary key and maps it to the "Laptop_Id" column in the database
    private long lid;

    @Column(name = "LaptopName")
    // Maps this field to the "LaptopName" column in the database
    private String lName;

    @ManyToMany
    // Defines a many-to-many relationship between Laptop and Student entities.
    // This relationship requires a join table in the database.
    private List<Student> student = new ArrayList<>();

    // Getter method for the primary key field `lid`
    public long getLid() {
        return lid;
    }

    // Setter method for the primary key field `lid`
    public void setLid(long lid) {
        this.lid = lid;
    }

    // Getter method for the `lName` field
    public String getlName() {
        return lName;
    }

    // Setter method for the `lName` field
    public void setlName(String lName) {
        this.lName = lName;
    }

    // Getter method for the `student` list, which represents the many-to-many relationship
    public List<Student> getStudent() {
        return student;
    }

    // Setter method for the `student` list
    public void setStudent(List<Student> student) {
        this.student = student;
    }

    // Overrides the `toString()` method to provide a meaningful string representation of the Laptop object
    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", lName=" + lName + "]";
    }
}

/*
 * Example Relationship Annotations:
 *
 * 1. @OneToOne:
 *    - Used when one entity is associated with exactly one other entity.
 *    - Example: A Student has exactly one Passport.
 *    
 *    @OneToOne
 *    @JoinColumn(name = "passport_id") // Specifies the foreign key column
 *    private Passport passport;
 *
 * 2. @OneToMany:
 *    - Used when one entity is associated with multiple other entities.
 *    - Example: A Department has many Employees.
 *    
 *    @OneToMany(mappedBy = "department")
 *    private List<Employee> employees = new ArrayList<>();
 *
 * 3. @ManyToOne:
 *    - Used when multiple entities are associated with a single entity.
 *    - Example: Many Employees belong to one Department.
 *    
 *    @ManyToOne
 *    @JoinColumn(name = "department_id") // Specifies the foreign key column
 *    private Department department;
 *
 * 4. @ManyToMany:
 *    - Used when multiple entities are associated with multiple other entities.
 *    - Example: A Student can enroll in many Courses, and a Course can have many Students.
 *    
 *    @ManyToMany
 *    @JoinTable(
 *        name = "student_course", // Join table name
 *        joinColumns = @JoinColumn(name = "student_id"), // Foreign key for Student
 *        inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key for Course
 *    )
 *    private List<Course> courses = new ArrayList<>();
 */
