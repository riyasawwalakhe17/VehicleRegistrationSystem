package com.practise.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ownerName;
	
	private String vehicleNo;
	
	private String model;
	
	private String vehicleName;
	
	private int registrationYear;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="register_id")
	private List<RegistrationEntry> rEntry ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(int registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	
	public List<RegistrationEntry> getrEntry() {
		return rEntry;
	}

	public void setrEntry(List<RegistrationEntry> rEntry) {
		this.rEntry = rEntry;
	}

	@Override
	public String toString() {
		return "Vehicles [id=" + id + ", ownerName=" + ownerName + ", vehicleNo=" + vehicleNo + ", model=" + model
				+ ", vehicleName=" + vehicleName + ", registrationYear=" + registrationYear + ", rEntry=" + rEntry
				+ "]";
	}

	
	

	

	
	
}
