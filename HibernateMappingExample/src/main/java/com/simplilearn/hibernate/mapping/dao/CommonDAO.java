package com.simplilearn.hibernate.mapping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.hibernate.mapping.persistence.Course;
import com.simplilearn.hibernate.mapping.persistence.Question;
import com.simplilearn.hibernate.mapping.persistence.Student;

public class CommonDAO {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = null;

		Transaction t = null;

		try {

			session = sf.openSession();

			t = session.beginTransaction();

			QuestionDAO qdao = new QuestionDAO();

			List<Question> quesList = qdao.getQuestionAnswerDetails();

			StudentsDAO stdao = new StudentsDAO();
			List<Student> stList = stdao.getStudentCourseDetails();

			session.persist(stList.get(0));
			session.persist(stList.get(1));
			session.persist(stList.get(2));
			session.persist(stList.get(3));
			//session.persist(stList.get(4)); -- generating exception before committing transaction
			t.commit();
			
			//System.out.println("Get last value from student list " + stList.get(4)); -- generating exception after committing transaction
			System.out.println("Successfully saved...");

		} catch (Exception ex) {
			System.out.println("Exception Occurred ---->" + ex.getMessage());
			System.out.println("Exception Ocurred, rolling back the transaction now..");
			t.rollback();
		} finally {
			sf.close();
			session.close();
		}

	}
}
