package com.simplilearn.hibernate.mapping.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="STUDENT_NAME")
	private String name;
	
	@ManyToMany(targetEntity=Course.class, cascade= {CascadeType.ALL})
	@JoinTable(name="st_co_id", joinColumns= {@JoinColumn(name="st_id")}, 
	inverseJoinColumns= {@JoinColumn(name="co_id")})
	private List<Course> courseList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", courseList=" + courseList + "]";
	}
	
	

}
