package com.java.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue
	private Long customerid;
	private String customerName;
	private String age;
	private String addreess;
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	private Long mobileNo;



	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddreess() {
		return addreess;
	}

	public void setAddreess(String addreess) {
		this.addreess = addreess;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
