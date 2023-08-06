package com.simplilearn.hibernate.mapping.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.mapping.persistence.Answer;
import com.simplilearn.hibernate.mapping.persistence.Question;

public class QuestionDAO {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();

		Transaction t = session.beginTransaction();
		
//		List<String> answerList1 = new ArrayList<String>();
//		
//		answerList1.add("JAVA is an Object Oriented Programming Language.");
//		answerList1.add("JAVA is platform independent.");
//		
//		List<String> answerList2 = new ArrayList<String>();
//		
//		answerList2.add("Hibernate is an Object Relational Mapping Tool.");
//		answerList2.add("Hibernate is a JAVA based Framework.");
		

		Answer ans1 = new Answer();
		ans1.setAnswer("JAVA is an Object Oriented Programming Language.");
		ans1.setPosterName("John");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("JAVA is platform independent.");
		ans2.setPosterName("Sam");
		
		Answer ans3 = new Answer();
		ans3.setAnswer("Hibernate is an Object Relational Mapping Tool.");
		ans3.setPosterName("Kathy");
		
		Answer ans4 = new Answer();
		ans4.setAnswer("Hibernate is a JAVA based Framework.");
		ans4.setPosterName("Zoe");
		
		
		List<Answer> ansList1 = new ArrayList<Answer>();
		List<Answer> ansList2 = new ArrayList<Answer>();
		
		ansList1.add(ans1);
		ansList1.add(ans2);
		
		ansList2.add(ans3);
		ansList2.add(ans4);
		
		
		Question question1 = new Question();
		question1.setQname("What is JAVA?");
		question1.setAnswers(ansList1);

		Question question2 = new Question();
		question2.setQname("What is Hibernate?");
		question2.setAnswers(ansList2);
		
		session.persist(question1);
		session.persist(question2);
		

		t.commit();

		System.out.println("Successfully saved...");

		sf.close();
		session.close();

	}

}
