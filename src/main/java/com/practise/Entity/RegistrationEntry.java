package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registrationentry_detail")
public class RegistrationEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String registeredCity;
	
	private String registrationNo;
	
	private String expiryDate;
	
	private String issueDate;


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRegisteredCity() {
		return registeredCity;
	}



	public void setRegisteredCity(String registeredCity) {
		this.registeredCity = registeredCity;
	}



	public String getRegistrationNo() {
		return registrationNo;
	}



	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}



	public String getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}



	public String getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}



	@Override
	public String toString() {
		return "RegistrationEntry [id=" + id + ", registeredCity=" + registeredCity + ", registrationNo="
				+ registrationNo + ", expiryDate=" + expiryDate + ", issueDate=" + issueDate + "]";
	}



	

	
	
	
	
}
