package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoin {

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
			 
			 Query<Instructor>query=
					 session.createQuery("Select i from Instructor i "
					 		+ "JOIN FETCH i.courses "
					 		+ "where i.id=:theInstructorId",Instructor.class);
			 query.setParameter("theInstructorId", id);
			 Instructor instructor=query.getSingleResult();
			 
			 System.out.println("instructor: "+instructor);
		
			 session.close();
		
			 System.out.println(instructor.getCourses());

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
