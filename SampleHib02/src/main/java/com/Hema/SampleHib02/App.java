package com.Hema.SampleHib02;

// Importing necessary libraries and packages for Hibernate and collection handling
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
//======================================================================================================================
    	
    	// Sample code for creating and persisting entities has been commented out below:

        // Creating a Staffs object and setting its attributes
        // Staffs staff = new Staffs();
        // staff.setName("Hemachandran S");
        // staff.setStaff_id(1001);

        // Creating a Laptop object and setting its attributes
        // Laptop lap = new Laptop();
        // lap.setBrand("Dell");
        // lap.setLap_id(551);
        // lap.setPrice(55000);
        // lap.setSatffs(staff); // Setting the staff reference in the Laptop entity

        // Adding the Laptop to the Staffs entity's laptop collection
        // staff.getLaptop().add(lap);
    	
//======================================================================================================================

        // Configuring Hibernate by specifying annotated entity classes
        Configuration con = new Configuration()
                                .addAnnotatedClass(Laptop.class) // Adding Laptop entity
                                .addAnnotatedClass(Staffs.class); // Adding Staffs entity

        // Building the service registry with the specified Hibernate configuration
        StandardServiceRegistry reg  = new StandardServiceRegistryBuilder()
                                        .configure() // Reads hibernate.cfg.xml for configuration settings
                                        .applySettings(con.getProperties()) // Applies the configuration properties
                                        .build(); // Builds the service registry

        // Creating a SessionFactory from the Configuration and ServiceRegistry
        SessionFactory sf = con.buildSessionFactory(reg);

        // Opening a new session from the SessionFactory
        Session session = sf.openSession();

        // Beginning a transaction to interact with the database
        Transaction tr = session.beginTransaction();
        
//======================================================================================================================

        // Persisting the Laptop and Staffs entities in the database (currently commented out)
        // session.persist(lap);
        // session.persist(staff);
//======================================================================================================================

        // Retrieving a Staffs entity by its primary key (staff_id = 1001)
        Staffs st  = session.get(Staffs.class, 1001); 
        // Printing the name of the retrieved Staffs entity
        System.out.println(st.getName());

      // Accessing the collection of Laptop objects associated with the retrieved Staffs entity
        
//        Collection<Laptop> lap1 = st.getLaptop();
        

        // Explanation of Lazy Fetching:
        // 1. By default, collections (e.g., `laptops`) in Hibernate are fetched lazily when the fetch type is set to `FetchType.LAZY`.
        // 2. With Lazy Fetching, the associated `Laptop` entities are not loaded immediately when the `Staffs` entity is retrieved.
        // 3. The actual query to fetch the `Laptop` collection is triggered only when the collection is accessed, such as by calling `st.getLaptop()`.

        // Iterating over the Laptop collection and printing details (currently commented out)
       
        // for (Laptop laps : lap1) {
        //     System.out.println(laps); // Prints the toString() of each Laptop
        // }

        // Note: Accessing the collection outside the active session can lead to a LazyInitializationException.
        // To avoid this, either access the collection within the session or initialize it explicitly using Hibernate's methods (e.g., Hibernate.initialize()).

//======================================================================================================================

        // Committing the transaction to save any changes made during the session
        tr.commit();

        // Closing the SessionFactory to release resources
        sf.close();
    }
}
