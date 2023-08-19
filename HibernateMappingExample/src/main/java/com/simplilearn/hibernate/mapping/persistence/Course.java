package com.simplilearn.hibernate.mapping.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="COURSE_PRICE")
	private double coursePrice;
	
	@ManyToMany(mappedBy="courseList")
	private List<Student> studentList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseName=" + courseName + ", coursePrice=" + coursePrice + "]";
	}
	
	

}
