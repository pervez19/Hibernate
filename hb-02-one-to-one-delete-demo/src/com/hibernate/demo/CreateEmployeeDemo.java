package com.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Employee;


public class CreateEmployeeDemo {


	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		System.out.print("create Session");
		try {
			
			
		
			session.beginTransaction();
		
			List<Employee> theEmployee=
					session
					.createQuery("from Employee")
					.getResultList();
			
			
				displayEmployee(theEmployee);

			theEmployee= session
					.createQuery("from Employee s"
							+ " where s.fast_name='apon'")
					.getResultList();
			
			displayEmployee(theEmployee);
			int id=2001;
		
//			Employee employee=session.get(Employee.class, id);
//			System.out.println("id= "+employee);
//			employee.setLast_name("umor Abdulla");
			
			Employee employee=session.get(Employee.class, id);
			System.out.println("id updated= "+employee);
			session.getTransaction().commit();
			
			System.out.print("done");
			
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployee(List<Employee> theEmployee) {
		for(Employee employee: theEmployee)
		{
			System.out.println(employee);
		}
	}

}
