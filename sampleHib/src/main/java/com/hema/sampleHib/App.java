package com.hema.sampleHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Student stu = new Student();
//    	stu.setsMark(92);
//    	stu.setsid(1001);  			//Here the objects store the setted values and used for save into db; 
//    	stu.setsName("Chandran");	//now commented for fetching method practice
//======================================================================================================================================== 
    	
    	StudentName st = new StudentName();
    	st.setfName("Hema");
    	st.setmName("Chandran");
    	st.setlName("Shanmugam");
    	
    	Student stu1 = new Student();
    	stu1.setsMark(90);
    	stu1.setsid(1001);
    	stu1.setsName(st);

//======================================================================================================================================== 
    	
    	// Load the Hibernate configuration from hibernate.cfg.xml
        // and add the annotated Student class to the configuration
        Configuration con = new Configuration()
                            .configure()
                            .addAnnotatedClass(Student.class);
        
//======================================================================================================================================== 
        
        // Apply the properties from the Hibernate configuration file to the StandardServiceRegistryBuilder
        // `getProperties` retrieves the configuration properties (e.g., database connection settings) from the Configuration object
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                                       .applySettings(con.getProperties())  // Apply the configuration properties to the registry builder
                                       .build();  // Build the StandardServiceRegistry object
        
        Metadata meta  = new MetadataSources(reg) 
                .getMetadataBuilder() 
                .build(); 
//======================================================================================================================================== 
        
        // Build the SessionFactory using the Configuration and the StandardServiceRegistry
        SessionFactory sf = meta.buildSessionFactory();
        
        // Open a new session from the SessionFactory
        Session session = sf.openSession();
        
        // Begin a transaction in the session
        Transaction tr = session.beginTransaction();
//======================================================================================================================================== 
        
        // Persist (save) the Student objects into the database
//        session.persist(stu);  // Save the first student object
//        session.persist(stu1); // Save the second student object  Commented for Fetching practice
        
//======================================================================================================================================== 

//        stu = session.get(Student.class, 1002);  // Here get method used for fetching data from db with class name and primary key
        										 // Sometimes it need to be type casted to class object here (Student)
//======================================================================================================================================== 
       
//======================================================================================================================================== 
        
        // Persist (save) the Student objects into the database
//        session.persist(stu);  // Save the first student object
//        session.persist(stu1); // Save the second student object  Commented for Fetching practice
        
        session.persist(stu1);
//======================================================================================================================================== 
        
        // Commit the transaction to save changes to the database
        tr.commit();
        
        // Close the SessionFactory to release resources
        sf.close();
        
        System.out.println(stu1);
    	
    }
}
