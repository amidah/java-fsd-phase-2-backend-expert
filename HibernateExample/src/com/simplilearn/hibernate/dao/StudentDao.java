package com.simplilearn.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.persistent.Student;

public class StudentDao {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		Student student = new Student();

		student.setName("John");
		student.setAge(21);

		Student student2 = new Student();
		student2.setName("Sam");
		student2.setAge(22);
		
		Student student3 = new Student();
		student3.setName("Riya");
		student3.setAge(24);
	
		
		session.save(student);
		session.save(student2);
		session.save(student3);

		t.commit();

		System.out.println("Successfully saved...");
		
		sf.close();
		session.close();

	}

}
