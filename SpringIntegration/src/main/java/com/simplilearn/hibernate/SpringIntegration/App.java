package com.simplilearn.hibernate.SpringIntegration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.hibernate.persistence.entity.Car;
import com.simplilearn.hibernate.spring.dao.CarDAO;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Resource r =new  ClassPathResource("applicationContext.xml");
        
        BeanFactory factory = new XmlBeanFactory(r);
        
        CarDAO carDao = (CarDAO) factory.getBean("cardao");
        
        Car car = new Car();
        car.setName("Porsche");
        car.setColor("red");
        
        
        carDao.saveCarDetails(car);
        
    }
}
