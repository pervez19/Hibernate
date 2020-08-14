package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class DropCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			
			 session.beginTransaction();
			 int id=66;
			Student student=session.get(Student.class, id);
			System.out.println("Student: "+student);
			System.out.println("Student course: "+student.getCourses());
			 	
			
			
			List<Course> course=student.getCourses();
			for(Course c:course)
			{
				if(c.getId()==65)
				{
					student.removeCourse(c);
					break;
				}
			}
			session.getTransaction().commit();

			System.out.print("done");
			
			
		}
		finally {
			factory.close();
		}
	}

}
