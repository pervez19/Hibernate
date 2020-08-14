package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
			 
			 Instructor instructor=session.get(Instructor.class, id);
			 
			 Course course1=new Course("the story of midnight");
			 Course course2=new Course("the story of Covide19");
			 Course course3=new Course("the story of failor");

			 instructor.add(course1);
			 instructor.add(course2);
			 instructor.add(course3);
			 
			 session.save(course1);
			 session.save(course2);
			 session.save(course3);

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
