package com.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="email")
	private String email;
	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST,
							CascadeType.MERGE, CascadeType.DETACH,
							CascadeType.REFRESH})
	@JoinTable(name="COURSE_STUDENT",
			joinColumns=@JoinColumn(name="STUDENT_ID"),
			inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses;
	
	public Student()
	{
		
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course)
	{
		if(courses==null)
			courses=new ArrayList<Course>();
		courses.add(course);
	}
	public void removeCourse(Course course)
	{
		if(courses.contains(course))
		{
			courses.remove(course);
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email + "]";
	}

}
