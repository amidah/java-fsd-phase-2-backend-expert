package com.simplilearn.hibernate.annotation.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.ValueGenerationType;
import org.jboss.logging.Param;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue
	/*Custom Sequence Generator*/
	/*=========================*/
//	@GeneratedValue(generator="sequence-generator")
//	@GenericGenerator(
//			name="sequence-generator",
//			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
//			parameters= {
//					@Parameter(name="sequence_name", value="my_hibernate_sequence"),
//					@Parameter(name="initial_value", value="10")
//			})
	
	/*Custom Table Generator   */
	/*=========================*/
//	@GeneratedValue(strategy=GenerationType.TABLE, generator="table-generator")
//	@TableGenerator(name="table-generator",
//	table="emp_ids",
//	pkColumnName="seq_id",
//	valueColumnName="seq_value")
	
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="DEPARTMENT")
	private String department;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + "]";
	}

}
