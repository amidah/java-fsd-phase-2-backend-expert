package com.simplilearn.hibernate.spring.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.simplilearn.hibernate.persistence.entity.Car;


public class CarDAO {

	HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void saveCarDetails(Car c) {
		hibernateTemplate.save(c);
	}
	
	
}
