package com.simplilearn.hibernate.cacheexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.annotation.persistent.Employee;

/**
 * Hello world!
 *
 */
public class FirstLevelCacheDemo 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		
        Transaction transaction = null;
        
        try{
        	transaction = session.beginTransaction();
        	
        	Employee emp = new Employee();
        	emp.setName("John");
        	emp.setAge(25);
        	emp.setDepartment("IT");
        
        	session.save(emp);
       
        	System.out.println("Going to fetch employee details from database:");
        	Employee emp1 = session.load(Employee.class, 1);
        	
        	System.out.println("Employee Name: " + emp1.getName());
        	System.out.println("Employee Age: " + emp1.getAge());
        	System.out.println("Employee Dept: " + emp1.getDepartment());
        		
        	Employee emp2 = session.load(Employee.class, 1);
        	
        	System.out.println("");
        	System.out.println("Going to fetch employee details from cache:");
        	System.out.println("Employee Name: " + emp2.getName());
        	System.out.println("Employee Age: " + emp2.getAge());
        	System.out.println("Employee Dept: " + emp2.getDepartment());
        	
        	transaction.commit();
        }
        catch(Exception e) {
        	if(transaction != null) {
        		transaction.rollback();
        	}
        }
        finally{
        	session.close();
        }
        
    }
}
