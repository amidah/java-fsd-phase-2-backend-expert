package com.simplilearn.hibernate.cacheexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.annotation.persistent.Employee;
import com.simplilearn.hibernate.annotation.persistent.Student;

public class SecondLevelCacheDemo {
	
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		
        Transaction transaction = null;
        
        try{
        	transaction = session.beginTransaction();
        	
        	Student std = new Student();
        	std.setName("John");
        	std.setAge(25);
        
        	//session.save(std);
       
        	System.out.println("Going to fetch student details from database:");
        	Student std1 = session.load(Student.class, 1);
        	
        	System.out.println("Student Name: " + std1.getName());
        	System.out.println("Student Age: " + std1.getAge());
        	
        		
        	Student std2 = session.load(Student.class, 1);
        	
        	System.out.println("");
        	System.out.println("Going to fetch student details from cache:");
        	System.out.println("Student Name: " + std2.getName());
        	System.out.println("Student Age: " + std2.getAge());
        	
        	
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
