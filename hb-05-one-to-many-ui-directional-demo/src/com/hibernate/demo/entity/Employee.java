package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EID")
	private int eid;
	
	@Column(name="FIRSTNAME")
	private String fast_name;
	
	@Column(name="LASTNAME")
    private String last_name;
	
	@Column(name="EMAIL")
    private String email;
	
	public Employee()
	{
		
	}

	public Employee(int eid,String fast_name, String last_name, String email) {
		this.eid=eid;
		this.fast_name = fast_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFast_name() {
		return fast_name;
	}

	public void setFast_name(String fast_name) {
		this.fast_name = fast_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fast_name=" + fast_name + ", last_name=" + last_name + ", Email=" + email
				+ "]";
	}

	
	
	
	
}
