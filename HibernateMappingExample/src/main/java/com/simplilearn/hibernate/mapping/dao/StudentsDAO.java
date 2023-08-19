package com.simplilearn.hibernate.mapping.dao;

import java.util.ArrayList;
import java.util.List;

import com.simplilearn.hibernate.mapping.persistence.Course;
import com.simplilearn.hibernate.mapping.persistence.Student;

public class StudentsDAO {

	public List<Student> getStudentCourseDetails() {
		List<Student> studentList = new ArrayList<Student>();

		Course course1 = new Course();
		course1.setCourseName("Machine Learning");
		course1.setCoursePrice(150);

		Course course2 = new Course();
		course2.setCourseName("Artificial Intelligence");
		course2.setCoursePrice(160);

		Course course3 = new Course();
		course3.setCourseName("Blockchain");
		course3.setCoursePrice(170);

		Course course4 = new Course();
		course4.setCourseName("Cyber Security");
		course4.setCoursePrice(180);

		Student student1 = new Student();
		student1.setName("John");
		List<Course> courseList1 = new ArrayList<Course>();
		courseList1.add(course1);
		courseList1.add(course2);
		student1.setCourseList(courseList1);

		Student student2 = new Student();
		student2.setName("Sam");
		List<Course> courseList2 = new ArrayList<Course>();
		courseList2.add(course3);
		courseList2.add(course4);
		student2.setCourseList(courseList2);

		Student student3 = new Student();
		student3.setName("Arnold");
		student3.setCourseList(courseList1);

		Student student4 = new Student();
		student4.setName("Raphel");
		student4.setCourseList(courseList2);

		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);

		return studentList;
	}

}
