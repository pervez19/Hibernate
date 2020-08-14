package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			
			 session.beginTransaction();
			 int id=41;
			 Instructor instructor= session.get(Instructor.class, id);
			 System.out.println(instructor);
			 System.out.println(instructor.getCourses());

			 session.getTransaction().commit();
			
			System.out.print("done");
			
			
		}
		finally {
			factory.close();
		}
	}

}
