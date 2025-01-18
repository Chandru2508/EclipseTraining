package com.Hema.sampleHib01;

// Importing necessary Hibernate classes for session management, transaction, and configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Main class to demonstrate Hibernate functionality.
 */
public class App {
    public static void main(String[] args) {
    	
        // Creating a new Laptop object and setting its properties
        Laptop lap = new Laptop();
        lap.setLid(111); // Setting the laptop ID
        lap.setlName("Dell Latitude"); // Setting the laptop name
    	
        // Creating a new Student object and setting its properties
        Student stu = new Student();
        stu.setSid(1001); // Setting the student ID
        stu.setsName("Hemachandran S"); // Setting the student's name
        stu.setsMark(90); // Setting the student's marks
        stu.getLaptop().add(lap); // Adding the Laptop object to the Student's list of laptops
    	
        lap.getStudent().add(stu); // Adding the Student object to the Laptop's list of students
    	
        // Configuring Hibernate
        // Reads the `hibernate.cfg.xml` file and adds annotated classes for mapping
        Configuration con = new Configuration()
                .configure() // Loads the default configuration file (`hibernate.cfg.xml`)
                .addAnnotatedClass(Student.class) // Adds the Student class to Hibernate configuration
                .addAnnotatedClass(Laptop.class); // Adds the Laptop class to Hibernate configuration
    	
        // Building the ServiceRegistry, which is a registry for all Hibernate services
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties()) // Applies the properties defined in the configuration file
                .build(); // Builds the ServiceRegistry
    	
        // Building the SessionFactory from the configuration and registry
        SessionFactory sf = con.buildSessionFactory(reg);
    	
        // Opening a Hibernate session to interact with the database
        Session session = sf.openSession();
    	
        // Beginning a transaction to ensure atomicity
        Transaction tr = session.beginTransaction();
    	
        // Persisting the Laptop object into the database
        session.persist(lap);
    	
        // Persisting the Student object into the database
        session.persist(stu);
    	
        // Committing the transaction to save changes in the database
        tr.commit();
    	
        // Closing the SessionFactory to release resources
        sf.close();
    }
}
