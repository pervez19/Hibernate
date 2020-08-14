package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateStudentCourseDemo {

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
			
 
			 Course course=new Course("the story of one Stand Night");
	
			 session.save(course);
			 
			 Student student1=new Student("Farhad","hossain","farhad@gmail.com");
			 Student student2=new Student("Shakib","Al Islam","sakib@gmail.com");
			 
			 student1.addCourse(course);
			 student2.addCourse(course);
			 
			 session.save(student1);
			 session.save(student2);
		
			 
			
			 
			 System.out.println("Course: "+course);
			 System.out.println("Student: "+course.getStudents());
			 
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
