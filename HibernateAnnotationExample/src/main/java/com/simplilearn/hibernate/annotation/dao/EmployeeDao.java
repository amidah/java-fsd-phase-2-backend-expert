package com.simplilearn.hibernate.annotation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.annotation.persistent.Employee;


public class EmployeeDao {
	
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		Employee employee = new Employee();

		employee.setName("Shawn");
		employee.setAge(28);
		employee.setDepartment("IT");
		
		Employee employee1 = new Employee();

		employee1.setName("Rammy");
		employee1.setAge(28);
		employee1.setDepartment("HR");

		session.save(employee);
		session.save(employee1);

		t.commit();

		System.out.println("Successfully saved...");
		
		sf.close();
		session.close();

	}

}
