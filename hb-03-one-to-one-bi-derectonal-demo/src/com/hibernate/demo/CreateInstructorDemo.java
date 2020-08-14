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
			 session.beginTransaction();
		
			 int id=2;
			 InstructorDetail instructorDetail= session.get(InstructorDetail.class, id);
			
			 System.out.println("instructorDetail: "+instructorDetail);
			 System.out.println("instructor: "+instructorDetail.getInstructor());


			 session.getTransaction().commit();
			
			 System.out.print("done");
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
