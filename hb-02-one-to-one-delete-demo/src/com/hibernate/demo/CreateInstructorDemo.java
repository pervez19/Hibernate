package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			
			 Instructor instructor= new Instructor("Apon","Ahmed","apon@gmail.com");
		
			 InstructorDetail instructorDetail= new InstructorDetail("aponView","football");
			 instructor.setInstructorDetail(instructorDetail);
		
			 session.beginTransaction();
			
			 session.save(instructor);

			session.getTransaction().commit();
			
			System.out.print("done");
			
			
		}
		finally {
			factory.close();
		}
	}

}
