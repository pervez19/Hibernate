package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateCourseReviewDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			 session.beginTransaction();
			
			 int id=41;
			 
			 Instructor instructor=session.get(Instructor.class, id);
			 
			 Course course1=new Course("the story of midnight");
			
			 course1.setInstructor(instructor);
						 
			 Review review1=new Review("This is awsome course");
			 Review review2=new Review("This course instructor was very helpful");

			 course1.add(review1);
			 course1.add(review2);
			 
			 session.save(course1);

			 System.out.println(course1);
			 System.out.println(course1.getReviews());
			 
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
