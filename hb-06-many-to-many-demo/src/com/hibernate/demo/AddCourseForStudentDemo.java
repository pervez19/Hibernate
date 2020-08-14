package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCourseForStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)

				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			 session.beginTransaction();
			
			 Course course=new Course("the story of Silent");
			 session.save(course);
			 
			 int id=66;
			 Student student1=session.get(Student.class, id);
			 student1.addCourse(course);

			 System.out.println("Course: "+student1);
			 System.out.println("Student: "+student1.getCourses());
			 
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
